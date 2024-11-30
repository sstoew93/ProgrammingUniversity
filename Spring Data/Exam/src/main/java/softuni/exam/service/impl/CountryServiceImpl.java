package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ImportCountryDTO;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CountryService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;


@Service
public class CountryServiceImpl implements CountryService {
    private static final String PATH_INPUT = "src/main/resources/files/json/countries.json";

    private final CountryRepository countryRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.countryRepository = countryRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.countryRepository.count() > 0;
    }

    @Override
    public String readCountryFileContent() throws IOException {
        return new String(Files.readAllBytes(Path.of(PATH_INPUT)));
    }

    @Override
    public String importCountries() throws IOException {
        StringBuilder sb = new StringBuilder();

        ImportCountryDTO[] dtos = this.gson.fromJson(readCountryFileContent(), ImportCountryDTO[].class);

        for (ImportCountryDTO dto : dtos) {
            Optional<Country> countryOptional = this.countryRepository.findByName(dto.getName());

            if (!this.validationUtil.isValid(dto) || countryOptional.isPresent()) {
                sb.append("Invalid country").append(System.lineSeparator());
                continue;
            }

            Country country = this.modelMapper.map(dto, Country.class);

            this.countryRepository.saveAndFlush(country);
            sb.append(String.format("Successfully imported country %s", dto.getName()))
                    .append(System.lineSeparator());

        }

        return sb.toString();
    }
}
