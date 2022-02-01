package eng.eslavecki.vaxapp.controller;

import eng.eslavecki.vaxapp.model.*;
import eng.eslavecki.vaxapp.service.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("vaccine")
public class VaccineController {

    private final VaccineService vaccineService;

    public VaccineController(VaccineService vaccineService) {
        this.vaccineService = vaccineService;
    }

    @GetMapping
    public List<Vaccine> getAllVaccines(){
        return vaccineService.findAll();
    }

    @GetMapping(params = "researchName")
    public Optional<Vaccine> getByResearchName(@RequestParam final String researchName){
        return vaccineService.findVaccineByResearchName(researchName);
    }

}
