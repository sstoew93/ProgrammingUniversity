package softuni.exam.models.dto;


import com.google.gson.annotations.Expose;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ImportCountryDTO {

    @Expose
    @Size(min = 3, max = 40)
    private String name;

    @Expose
    @Positive
    private double area;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
}
