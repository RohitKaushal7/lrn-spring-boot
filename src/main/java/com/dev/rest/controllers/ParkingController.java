package com.dev.rest.controllers;

import java.util.List;
import java.util.Map;

import com.dev.rest.models.Car;
import com.dev.rest.services.ParkingService;
import com.fasterxml.jackson.databind.JsonNode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParkingController {
    
    @Autowired
    ParkingService parkingService;

    @GetMapping("/parking/dim")
    public Map<Integer,Integer> getParkingDimentions(){
        return parkingService.getDim();
    }
    @GetMapping("/parking/space")
    public Map<Integer,List<Car>> getParkingSpace(){
        return parkingService.getSpace();
    }

    @GetMapping("/parking/wq")
    public List<Car> getWaitingQ(){
        return parkingService.getWaitingList();
    }

    @PostMapping("/parking/park")
    public Map<Integer,List<Car>> parkCar(@RequestBody JsonNode car_json){
        Car car = new Car(car_json.get("id").asInt(),car_json.get("size").asInt());
        parkingService.park(car);
        return parkingService.getSpace();
    }

    @PostMapping("/parking/unpark")
    public Map<Integer,List<Car>> unparkCar(@RequestBody JsonNode car_json){
        Car car = new Car(car_json.get("id").asInt(),car_json.get("size").asInt());
        parkingService.unpark(car);
        return parkingService.getSpace();
    }

}
