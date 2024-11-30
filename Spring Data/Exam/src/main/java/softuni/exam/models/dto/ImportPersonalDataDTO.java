package softuni.exam.models.dto;

import jakarta.validation.constraints.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "personal_data")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportPersonalDataDTO {

    @XmlElement(name = "age")
    @Min(1)
    @Max(100)
    private int age;

    @XmlElement(name = "gender")
    private String gender;

    @XmlElement(name = "birth_date")
    private String birthDate;

    @XmlElement(name = "card_number")
    @Size(min = 9, max = 9)
    private String cardNumber;

    @Min(1)
    @Max(100)
    public int getAge() {
        return age;
    }

    public void setAge(@Min(1) @Max(100) int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public @Size(min = 9, max = 9) String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(@Size(min = 9, max = 9) String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
