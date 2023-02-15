package com.anudeep.EVchargingstation.service;

import com.anudeep.EVchargingstation.entity.Station;
import com.anudeep.EVchargingstation.error.StationNotFoundException;
import com.anudeep.EVchargingstation.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StationServiceImplementation implements StationService
{
     @Autowired
    private StationRepository stationRepository;


    @Override
    public Station saveStation(Station station)
    {

        return stationRepository.save(station);
    }

    @Override
    public List<Station> fetchStationList() {
        return stationRepository.findAll();
    }

    @Override
    public Station fetchStationById(Long stationId) throws StationNotFoundException {
        Optional<Station> station =
                stationRepository.findById(stationId);

        if(!station.isPresent()) {
            throw new StationNotFoundException("Station Not Available");
        }

        return  station.get();
    }

    @Override
    public void deleteStationById(Long stationId) {
        stationRepository.deleteById(stationId);
    }

    @Override
    public Station updateStation(Long stationId, Station station) {
        Station station1 = stationRepository.findById(stationId).get();

        if(Objects.nonNull(station.getStationName()) &&
                !"".equalsIgnoreCase(station.getStationName())) {
            station1.setStationName(station.getStationName());
        }

        if(Objects.nonNull(station.getStationPricing()) &&
                !"".equalsIgnoreCase(station.getStationPricing())) {
            station1.setStationPricing(station.getStationPricing());
        }

        if(Objects.nonNull(station.getStationAddress()) &&
                !"".equalsIgnoreCase(station.getStationAddress())) {
            station1.setStationAddress(station.getStationAddress());
        }

        return stationRepository.save(station1);
    }

}
