/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.dev.mafe.airports.controllers;

import br.dev.mafe.airports.entities.Airport;
import br.dev.mafe.airports.services.AirportService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sesidevb
 */
@RestController
public class AirportController {
    
    @Autowired
    private AirportService airportService;
    
    @GetMapping("/airport")
    public List<Airport> findAll() {
        List<Airport> result = airportService.findAll();
        return result;
    }
    /**
     * Endpoint /airports/city/{cityName}
     * @param cityName
     * @return
     */
    @GetMapping("/city/{cityName}")
    public ResponseEntity<List<Airport>> findByCityIgnoreCase(@PathVariable String cityName){
        List<Airport> result = airportService.findByCity(cityName);
       
        if(result.isEmpty()){
            //Ops.. lista vazia...
            //notFound devolve 404
            return ResponseEntity.notFound().build();
            
        } else {
            //Eba! Tem dados!
            //ok devolve 200
            return ResponseEntity.ok(result);
        }
    }
    
}
