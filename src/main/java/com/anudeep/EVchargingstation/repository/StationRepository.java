package com.anudeep.EVchargingstation.repository;

import com.anudeep.EVchargingstation.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationRepository extends JpaRepository<Station,Long>
{

}
