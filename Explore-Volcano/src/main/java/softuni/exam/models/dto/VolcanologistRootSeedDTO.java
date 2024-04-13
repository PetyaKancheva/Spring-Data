package softuni.exam.models.dto;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@XmlRootElement(name="volcanologists")
@XmlAccessorType(XmlAccessType.FIELD)
public class VolcanologistRootSeedDTO {
    @XmlElement(name="volcanologists")
    private List<VolcanologistSeedDTO> volcanologistsDTOList = new ArrayList<>();

}
