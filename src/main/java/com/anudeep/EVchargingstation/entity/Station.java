package com.anudeep.EVchargingstation.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data

public class Station
{


    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
//    @SequenceGenerator(
//            name = "station_sequence",
//            sequenceName = "station_sequence",
//            allocationSize = 1
//    )
//    @GeneratedValue(
//            strategy =  GenerationType.SEQUENCE,
//            generator = "station_sequence"
//    )
       private  long stationId;
       private String stationName;
       private String stationImage;
       private String stationPricing;
       private String stationAddress;

}
