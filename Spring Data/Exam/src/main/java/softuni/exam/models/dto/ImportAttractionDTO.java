package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public class ImportAttractionDTO {

    @Expose
    @Size(min = 5, max = 40)
    private String name;

    @Expose
    @Size(min = 10, max = 100)
    private String description;

    @Expose
    @Size(min = 3, max = 30)
    private String type;

    @Expose
    @Min(0)
    private int elevation;

    @Expose
    private Long country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getElevation() {
        return elevation;
    }

    public void setElevation(int elevation) {
        this.elevation = elevation;
    }

    public Long getCountry() {
        return country;
    }

    public void setCountry(Long country) {
        this.country = country;
    }
}
