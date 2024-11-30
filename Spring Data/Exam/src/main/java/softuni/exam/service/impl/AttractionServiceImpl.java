package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ImportAttractionDTO;
import softuni.exam.models.entity.Attraction;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.AttractionRepository;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.AttractionService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@Service

public class AttractionServiceImpl implements AttractionService {

    private static final String PATH_INPUT = "src/main/resources/files/json/attractions.json";

    private final AttractionRepository attractionRepository;
    private final CountryRepository countryRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;


    @Autowired
    public AttractionServiceImpl(AttractionRepository attractionRepository, CountryRepository countryRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.attractionRepository = attractionRepository;
        this.countryRepository = countryRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.attractionRepository.count() > 0;
    }

    @Override
    public String readAttractionsFileContent() throws IOException {
        return new String(Files.readAllBytes(Path.of(PATH_INPUT)));
    }

    @Override
    public String importAttractions() throws IOException {
        StringBuilder sb = new StringBuilder();

        ImportAttractionDTO[] dtos = this.gson.fromJson(readAttractionsFileContent(), ImportAttractionDTO[].class);

        for (ImportAttractionDTO dto : dtos) {
            Optional<Attraction> attractionOptional = this.attractionRepository.findByName(dto.getName());

            if (!this.validationUtil.isValid(dto) || attractionOptional.isPresent()) {
                sb.append("Invalid attraction").append(System.lineSeparator());
                continue;
            }

            Optional<Country> countryOptional = this.countryRepository.findById(dto.getCountry());

            Attraction attraction = this.modelMapper.map(dto, Attraction.class);
            attraction.setCountry(countryOptional.get());

            this.attractionRepository.saveAndFlush(attraction);
            sb.append(String.format("Successfully imported attraction %s", dto.getName()))
                    .append(System.lineSeparator());

        }

        return sb.toString();
    }

    @Override
    public String exportAttractions() {
        StringBuilder sb = new StringBuilder();

        List<Attraction> attractions = this.attractionRepository.export(300);

        attractions.stream().forEach(a ->
                sb.append(String.format("Attraction with ID%d:\n" +
                                "***%s - %s at an altitude of %sm. somewhere in %s.",
                       a.getId(), a.getName(), a.getDescription(), a.getElevation(), a.getCountry().getName())).append(System.lineSeparator()));

        return sb.toString();
    }
}
