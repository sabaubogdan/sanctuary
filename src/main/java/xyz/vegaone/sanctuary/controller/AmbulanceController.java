package xyz.vegaone.sanctuary.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import xyz.vegaone.sanctuary.dto.Ambulance;
import xyz.vegaone.sanctuary.service.AmbulanceService;

@RestController
@RequestMapping(value = "/sanctuary/ambulance")
@Slf4j
public class AmbulanceController {

    private AmbulanceService ambulanceService;

    @Autowired
    public AmbulanceController(AmbulanceService ambulanceService) {
        this.ambulanceService = ambulanceService;
    }

    @GetMapping(value = "{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Ambulance getAmbulance(@PathVariable(value = "id") Long id){
        Ambulance ambulance = ambulanceService.getAmbulance(id);

        return ambulance;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ambulance createAmbulance(@RequestBody Ambulance ambulance){
        Ambulance createAmbulance = ambulanceService.createAmbulance(ambulance);

        return createAmbulance;
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAmbulance(@PathVariable(value = "id")Long id){
        ambulanceService.deleteAmbulance(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Ambulance updateAmbulance(@RequestBody Ambulance ambulance){
        Ambulance updatedAmbulance = ambulanceService.updateAmbulance(ambulance);

        return updatedAmbulance;
    }

}
