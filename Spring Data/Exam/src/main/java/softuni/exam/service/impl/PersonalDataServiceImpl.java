package softuni.exam.service.impl;

import jakarta.xml.bind.JAXBException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ImportPersonalDataDTO;
import softuni.exam.models.dto.ImportPersonalDataRootDTO;
import softuni.exam.models.entity.Attraction;
import softuni.exam.models.entity.Country;
import softuni.exam.models.entity.PersonalData;
import softuni.exam.repository.PersonalDataRepository;
import softuni.exam.service.PersonalDataService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;


@Service
public class PersonalDataServiceImpl implements PersonalDataService {

    private static final String PATH_INPUT = "src/main/resources/files/xml/personal_data.xml";

    private final PersonalDataRepository personalDataRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    @Autowired
    public PersonalDataServiceImpl(PersonalDataRepository personalDataRepository, XmlParser xmlParser, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.personalDataRepository = personalDataRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.personalDataRepository.count() > 0;
    }

    @Override
    public String readPersonalDataFileContent() throws IOException {
        return new String(Files.readAllBytes(Path.of(PATH_INPUT)));

    }

    @Override
    public String importPersonalData() throws JAXBException {
        StringBuilder sb = new StringBuilder();

        ImportPersonalDataRootDTO dtos = this.xmlParser.parse(PATH_INPUT, ImportPersonalDataRootDTO.class);

        for (ImportPersonalDataDTO dto : dtos.getPersonalDataDTOS()) {
            Optional<PersonalData> personalDataOptional = this.personalDataRepository.findByCardNumber(dto.getCardNumber());

            if (!this.validationUtil.isValid(dto) || personalDataOptional.isPresent()) {
                sb.append("Invalid personal data").append(System.lineSeparator());
                continue;
            }

            PersonalData pData = this.modelMapper.map(dto, PersonalData.class);

            this.personalDataRepository.saveAndFlush(pData);
            sb.append(String.format("Successfully imported personal data for visitor with card number %s", dto.getCardNumber()))
                    .append(System.lineSeparator());

        }

        return sb.toString();
    }
}
