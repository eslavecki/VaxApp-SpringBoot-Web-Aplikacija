package eng.eslavecki.vaxapp.repository;

import eng.eslavecki.vaxapp.enumeration.*;
import eng.eslavecki.vaxapp.model.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public class VaccineRepositoryImpl implements VaccineRepository {

  List<Vaccine> vaccines = new ArrayList<>(List.of(Vaccine.builder()
          .researchName("Sputnik")
          .manufacturerName("Mother Russia")
          .vaccineType(VaccineType.mRNA)
          .requiredDoseAmount(2)
          .availableDoseAmount(400000)
          .build(),  Vaccine.builder()
          .researchName("AZ150")
          .manufacturerName("Astra Zeneca")
          .vaccineType(VaccineType.VIRAL_VECTOR)
          .requiredDoseAmount(2)
          .availableDoseAmount(150000)
          .build()));

  @Override
  public List<Vaccine> findAll() {
    return getVaccines();
  }

  @Override
  public Optional<Vaccine> findVaccineByResearchName(String researchName) {

    return getVaccines().stream().filter(s -> s.getResearchName().equals(researchName)).findFirst();
  }

  @Override
  public Optional<Vaccine> save(Vaccine vaccine) {

    vaccines.add(vaccine);

    return Optional.of(vaccine);
  }

  private List<Vaccine> getVaccines() {
    return vaccines;
  }
}
