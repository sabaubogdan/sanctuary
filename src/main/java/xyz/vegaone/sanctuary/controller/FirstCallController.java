package xyz.vegaone.sanctuary.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import xyz.vegaone.sanctuary.dto.FirstCall;
import xyz.vegaone.sanctuary.service.FirstCallService;

@RestController
@RequestMapping(value = "/sanctuary/firstcall")
@Slf4j
public class FirstCallController {

    private FirstCallService firstCallService;

    @Autowired
    public FirstCallController(FirstCallService firstCallService) {
        this.firstCallService = firstCallService;
    }

    @GetMapping(value = "{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public FirstCall getFirstCall(@PathVariable(value = "id") Long id) {
        FirstCall firstCall = firstCallService.getFirstCall(id);

        return firstCall;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FirstCall createFirstCall(@RequestBody FirstCall firstCall) {
        FirstCall createFirstCall = firstCallService.createFirstCall(firstCall);

        return createFirstCall;
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFistCall(@PathVariable(value = "id") Long id) {
        firstCallService.deleteFirstCall(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public FirstCall updateFirstCall(@RequestBody FirstCall firstCall) {
        FirstCall updatedFirstCall = firstCallService.updateFirstCall(firstCall);

        return updatedFirstCall;
    }
}
