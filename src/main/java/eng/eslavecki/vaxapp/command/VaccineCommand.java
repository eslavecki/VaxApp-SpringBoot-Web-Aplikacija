package eng.eslavecki.vaxapp.command;

import eng.eslavecki.vaxapp.enumeration.*;
import lombok.*;

import javax.validation.constraints.*;

@Data
public class VaccineCommand {
    @NotNull
    @NotBlank
    private String researchName;
    @NotNull
    @NotBlank
    private String manufacturerName;
    @NotNull
    private VaccineType vaccineType;
    @NotNull
    @PositiveOrZero
    private Integer requiredDoseAmount;
    @NotNull
    @PositiveOrZero
    private Integer availableDoseAmount;

}
