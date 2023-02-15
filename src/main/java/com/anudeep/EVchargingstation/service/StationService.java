package com.anudeep.EVchargingstation.service;

import com.anudeep.EVchargingstation.entity.Station;
import com.anudeep.EVchargingstation.error.StationNotFoundException;

import java.util.List;

public interface StationService
{
    public Station saveStation(Station station);

    public List<Station> fetchStationList();

    public Station fetchStationById(Long stationId) throws StationNotFoundException;

    public void deleteStationById(Long stationId);

    public Station updateStation(Long stationId, Station station);
}
