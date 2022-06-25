package eng.eslavecki.vaxapp.service;

import eng.eslavecki.vaxapp.command.*;
import eng.eslavecki.vaxapp.dto.*;

import java.util.*;

public interface VaccineService {

    List<VaccineDTO> findAll();

    Optional<VaccineDTO> findVaccineByResearchName(String researchName);

    Optional<VaccineDTO> save(VaccineCommand vaccineCommand);
}
