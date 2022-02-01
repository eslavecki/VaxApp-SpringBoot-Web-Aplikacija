package eng.eslavecki.vaxapp.service;

import eng.eslavecki.vaxapp.model.*;

import java.util.*;

public interface VaccineService {

    List<Vaccine> findAll();

    Optional<Vaccine> findVaccineByResearchName(String researchName);
}
