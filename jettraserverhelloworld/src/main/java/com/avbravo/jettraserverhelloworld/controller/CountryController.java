/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.jettraserverhelloworld.controller;

import com.avbravo.jettraserverhelloworld.model.Country;
import com.avbravo.jettraserverhelloworld.repository.CountryRepository;
import com.avbravo.jettraserverhelloworld.repository.HistoryRepository;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

/**
 *
 * @author avbravo
 */
@Path("country")
//@RolesAllowed({"admin"})
public class CountryController {

    
    // <editor-fold defaultstate="collapsed" desc="Inject">
    @Inject
    CountryRepository countryRepository;
    
 
     @Inject
HistoryRepository historyRepository;

// </editor-fold>


    // <editor-fold defaultstate="collapsed" desc="findAll">
    @GET
    @RolesAllowed({"admin"})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
     public List<Country> findAll() {
        
        return countryRepository.findAll();
    }
// </editor-fold>

    
}
