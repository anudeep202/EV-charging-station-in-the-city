package com.anudeep.EVchargingstation.controller;

import com.anudeep.EVchargingstation.entity.Station;
import com.anudeep.EVchargingstation.error.StationNotFoundException;
import com.anudeep.EVchargingstation.service.StationService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StationController
{

//    private final Logger logger = LoggerFactory.getLogger(StationController.class);

    @Autowired
    private StationService stationService;

    @PostMapping("/chargingStation")
    public Station saveStation(@Valid @RequestBody Station station)
    {
//        logger.info("Inside saveStation of StationController");
        return stationService.saveStation(station);
    }

    @GetMapping("/chargingStation")
    public List<Station> fetchStationList() {
//        logger.info("Inside fetchDepartmentList of DepartmentController");
        return stationService.fetchStationList();
    }

    @GetMapping("/chargingStation/{id}")
    public Station fetchStationById(@PathVariable("id") Long stationId)
            throws StationNotFoundException {
        return stationService.fetchStationById(stationId);
    }

    @DeleteMapping("/chargingStation/{id}")
    public String deleteStationById(@PathVariable("id") Long stationId) {
        stationService.deleteStationById(stationId);
        return "Station deleted Successfully!!";
    }

    @PutMapping("/chargingStation/{id}")
    public Station updateStation(@PathVariable("id") Long stationId,
                                       @RequestBody Station station) {
        return stationService.updateStation(stationId,station);
    }




}
