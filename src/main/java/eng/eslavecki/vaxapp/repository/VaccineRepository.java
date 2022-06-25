package eng.eslavecki.vaxapp.repository;

import eng.eslavecki.vaxapp.model.*;

import java.util.*;

public interface VaccineRepository {

    List<Vaccine> findAll();

    Optional<Vaccine> findVaccineByResearchName(String researchName);

    Optional<Vaccine> save(Vaccine vaccine);
}
