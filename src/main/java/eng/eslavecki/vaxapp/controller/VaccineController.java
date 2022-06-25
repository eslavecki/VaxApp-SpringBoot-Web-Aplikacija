package eng.eslavecki.vaxapp.controller;

import eng.eslavecki.vaxapp.command.*;
import eng.eslavecki.vaxapp.dto.*;
import eng.eslavecki.vaxapp.service.*;
import org.springframework.http.*;
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
    public List<VaccineDTO> getAllVaccines(){
        return vaccineService.findAll();
    }

    @GetMapping("/{researchName}")
    public Optional<VaccineDTO> getByResearchName(@PathVariable final String researchName){
        return vaccineService.findVaccineByResearchName(researchName);
    }

    @PostMapping
    public ResponseEntity<VaccineDTO> saveVaccine(@RequestBody final VaccineCommand vaccineCommand){

        return vaccineService.save(vaccineCommand)
                .map(
                        vaccineDTO -> ResponseEntity
                                .status(HttpStatus.CREATED)
                                .body(vaccineDTO)
                )
                .orElseGet(
                        () -> ResponseEntity
                                .status(HttpStatus.CONFLICT)
                                .build()
                );
    }

    @DeleteMapping(params = "researchName")
    public HttpStatus deleteVaccine(@RequestParam String researchName){

        HttpStatus status;

        vaccineService.findAll().remove(vaccineService.findAll().indexOf(vaccineService.findVaccineByResearchName(researchName)));

        return null;
    }


}
