/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.dev.mafe.airports.repositories;

import br.dev.mafe.airports.entities.Airport;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author sesidevb
 */
public interface AirportRepository extends JpaRepository<Airport, Long>{

    List<Airport> findByCityIgnoreCase(String city);
    List<Airport> findByCountryIgnoreCase(String country);
   
    Airport findByIataCode(String iataCode);
    
}
