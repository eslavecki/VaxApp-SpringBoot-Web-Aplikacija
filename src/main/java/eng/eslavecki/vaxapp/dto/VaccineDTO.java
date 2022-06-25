package eng.eslavecki.vaxapp.dto;

import lombok.*;

@Data
@Builder
public class VaccineDTO {
    private String manufacturerName;
    private String researchName;
    private Integer requiredDoseAmount;
}
