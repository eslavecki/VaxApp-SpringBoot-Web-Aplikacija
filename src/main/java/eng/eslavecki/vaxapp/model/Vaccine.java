package eng.eslavecki.vaxapp.model;

import eng.eslavecki.vaxapp.enumeration.*;
import lombok.*;

@Data
@Builder
public class Vaccine {
    private String researchName;
    private String manufacturerName;
    private VaccineType vaccineType;
    private Integer requiredDoseAmount;
    private Integer availableDoseAmount;

}
