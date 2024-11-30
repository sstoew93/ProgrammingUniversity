package softuni.exam.service.impl;

import jakarta.xml.bind.JAXBException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ImportPersonalDataDTO;
import softuni.exam.models.dto.ImportPersonalDataRootDTO;
import softuni.exam.models.dto.ImportVisitorDTO;
import softuni.exam.models.dto.ImportVisitorsRootDTO;
import softuni.exam.models.entity.Attraction;
import softuni.exam.models.entity.Country;
import softuni.exam.models.entity.PersonalData;
import softuni.exam.models.entity.Visitor;
import softuni.exam.repository.AttractionRepository;
import softuni.exam.repository.CountryRepository;
import softuni.exam.repository.PersonalDataRepository;
import softuni.exam.repository.VisitorRepository;
import softuni.exam.service.VisitorService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;


@Service
public class VisitorServiceImpl implements VisitorService {

    private static final String PATH_INPUT = "src/main/resources/files/xml/visitors.xml";

    private final VisitorRepository visitorRepository;
    private final PersonalDataRepository personalDataRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private CountryRepository countryRepository;
    private AttractionRepository attractionRepository;

    @Autowired
    public VisitorServiceImpl(VisitorRepository visitorRepository, PersonalDataRepository personalDataRepository, XmlParser xmlParser, ModelMapper modelMapper, ValidationUtil validationUtil, CountryRepository countryRepository, AttractionRepository attractionRepository) {
        this.visitorRepository = visitorRepository;
        this.personalDataRepository = personalDataRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.countryRepository = countryRepository;
        this.attractionRepository = attractionRepository;
    }

    @Override
    public boolean areImported() {
        return this.visitorRepository.count() > 0;
    }

    @Override
    public String readVisitorsFileContent() throws IOException {
        return new String(Files.readAllBytes(Path.of(PATH_INPUT)));

    }

    @Override
    public String importVisitors() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

        ImportVisitorsRootDTO dtos = this.xmlParser.parse(PATH_INPUT, ImportVisitorsRootDTO.class);

        for (ImportVisitorDTO dto : dtos.getVisitorsDTO()) {
            Optional<Visitor> visitorName = this.visitorRepository.findByFirstNameAndLastName(dto.getFirstName(), dto.getLastName());
            Optional<Visitor> visitorNumber = this.visitorRepository.findByPersonalData(dto.getPersonalDataId());

            if (!this.validationUtil.isValid(dto) || visitorName.isPresent() || visitorNumber.isPresent()) {
                sb.append("Invalid visitor").append(System.lineSeparator());
                continue;
            }

            Optional <PersonalData> dataId = this.personalDataRepository.findById(dto.getPersonalDataId());
            Optional<Country> countryId = this.countryRepository.findById(dto.getCountry());
            Optional<Attraction> attractionId = this.attractionRepository.findById(dto.getAttraction());

            Visitor visitor = this.modelMapper.map(dto, Visitor.class);

            visitor.setPersonalData(dataId.get());
            visitor.setCountries(countryId.get());
            visitor.setAttraction(attractionId.get());

            this.visitorRepository.saveAndFlush(visitor);
            sb.append(String.format("Successfully imported visitor %s %s", dto.getFirstName(), dto.getLastName()))
                    .append(System.lineSeparator());;

        }

        return sb.toString();

    }
}
