package eng.eslavecki.vaxapp.service;

import eng.eslavecki.vaxapp.model.*;
import eng.eslavecki.vaxapp.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class VaccineServiceImpl implements VaccineService {

    private final VaccineRepository vaccineRepository;

    public VaccineServiceImpl(VaccineRepository vaccineRepository) {
        this.vaccineRepository = vaccineRepository;
    }


    @Override
    public List<Vaccine> findAll() {
        return vaccineRepository.findAll();
    }

    @Override
    public Optional<Vaccine> findVaccineByResearchName(String researchName) {
        return findAll().stream().filter(s -> s.getResearchName().equals(researchName)).findFirst();
    }
}
