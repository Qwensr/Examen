package com.example.Examen.controller;

import com.example.Examen.dto.ParkingPlaceDto;
import com.example.Examen.enums.ParkingType;
import com.example.Examen.service.impl.ParkingPlacesServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("parking-spots/")
public class ParkingPlaceController {

    private final ParkingPlacesServiceImpl service;

    @PostMapping("create")
    public ParkingPlaceDto createParkingPlace(ParkingPlaceDto parkingPlaceDto){
        return service.create(parkingPlaceDto);
    }

    @GetMapping("findAll")
    public List<ParkingPlaceDto> findAll(){
        return service.findAll();
    }

    @GetMapping("findById/{id}")
    public ParkingPlaceDto findById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping("findNotReservedPlaces")
    public List<ParkingPlaceDto> findNotReservedPlaces(){
        return service.findNotReservedPlaces();
    }

    @GetMapping("findPlacesByParkingType")
    public List<ParkingPlaceDto> findPlacesByParkingType(ParkingType parkingType){
        return service.findPlacesByParkingType(parkingType);
    }

    @DeleteMapping("delete")
    public void deleteById(@RequestParam Long id){
        service.delete(id);
    }

}
