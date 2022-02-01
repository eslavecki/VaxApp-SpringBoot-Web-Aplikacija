package eng.eslavecki.vaxapp.repository;

import eng.eslavecki.vaxapp.enumeration.*;
import eng.eslavecki.vaxapp.model.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public class VaccineRepositoryImpl implements VaccineRepository {
  @Override
  public List<Vaccine> findAll() {
    return getVaccines();
  }

  @Override
  public Optional<Vaccine> findVaccineByResearchName(String researchName) {

    return getVaccines().stream().filter(s -> s.getResearchName().equals(researchName)).findFirst();
  }

  private List<Vaccine> getVaccines() {
    List<Vaccine> vaccines = new ArrayList<>();

    vaccines.add(
        Vaccine.builder()
            .researchName("Sputnik")
            .manufacturerName("Mother Russia")
            .vaccineType(VaccineType.mRNA)
            .requiredDoseAmount(2)
            .availableDoseAmount(400000)
            .build());

    vaccines.add(
        Vaccine.builder()
            .researchName("AZ150")
            .manufacturerName("Astra Zeneca")
            .vaccineType(VaccineType.VIRAL_VECTOR)
            .requiredDoseAmount(2)
            .availableDoseAmount(150000)
            .build());
    return vaccines;
  }
}
