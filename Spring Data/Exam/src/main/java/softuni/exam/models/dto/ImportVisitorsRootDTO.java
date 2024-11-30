package softuni.exam.models.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "visitors")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportVisitorsRootDTO {

    @XmlElement(name = "visitor")
    private List<ImportVisitorDTO> visitorsDTO;


    public List<ImportVisitorDTO> getVisitorsDTO() {
        return visitorsDTO;
    }

    public void setVisitorsDTO(List<ImportVisitorDTO> visitorsDTO) {
        this.visitorsDTO = visitorsDTO;
    }
}
