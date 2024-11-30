package softuni.exam.models.dto;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "personal_datas")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportPersonalDataRootDTO {

    @XmlElement(name = "personal_data")
    private List<ImportPersonalDataDTO> personalDataDTOS;

    public List<ImportPersonalDataDTO> getPersonalDataDTOS() {
        return personalDataDTOS;
    }

    public void setPersonalDataDTOS(List<ImportPersonalDataDTO> personalDataDTOS) {
        this.personalDataDTOS = personalDataDTOS;
    }
}
