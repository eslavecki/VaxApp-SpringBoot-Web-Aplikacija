package eng.eslavecki.vaxapp.service;

import eng.eslavecki.vaxapp.command.*;
import eng.eslavecki.vaxapp.dto.*;
import eng.eslavecki.vaxapp.model.*;
import eng.eslavecki.vaxapp.repository.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.stream.*;

@Service
public class VaccineServiceImpl implements VaccineService {

    private final VaccineRepository vaccineRepository;

    public VaccineServiceImpl(VaccineRepository vaccineRepository) {
        this.vaccineRepository = vaccineRepository;
    }


    @Override
    public List<VaccineDTO> findAll() {
        return vaccineRepository.findAll().stream().map(this::mapVaccineToDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<VaccineDTO> findVaccineByResearchName(String researchName) {
        return findAll().stream().filter(s -> s.getResearchName().equals(researchName)).findFirst();
    }

    @Override
    public Optional<VaccineDTO> save(VaccineCommand vaccineCommand) {

        Vaccine vaccine = mapVaccineCommandToEntity(vaccineCommand);

        Optional<Vaccine> vacc = vaccineRepository.save(vaccine);



        return  Optional.of(mapVaccineToDTO(vacc.get()));
    }

    private VaccineDTO mapVaccineToDTO(final Vaccine vaccine){
    return VaccineDTO.builder()
        .manufacturerName(vaccine.getManufacturerName())
        .researchName(vaccine.getResearchName())
        .requiredDoseAmount(vaccine.getRequiredDoseAmount())
        .build();
    }

    private Vaccine mapVaccineCommandToEntity(final VaccineCommand vaccineCommand){
    return Vaccine.builder()
        .manufacturerName(vaccineCommand.getManufacturerName())
        .researchName(vaccineCommand.getResearchName())
        .requiredDoseAmount(vaccineCommand.getRequiredDoseAmount())
        .vaccineType(vaccineCommand.getVaccineType())
        .availableDoseAmount(vaccineCommand.getAvailableDoseAmount())
        .build();
    }


}
