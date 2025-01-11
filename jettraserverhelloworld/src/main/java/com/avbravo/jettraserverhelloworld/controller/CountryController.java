/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.jettraserverhelloworld.controller;

import com.avbravo.jettraserverhelloworld.model.Country;
import com.avbravo.jettraserverhelloworld.repository.CountryRepository;
import com.avbravo.jettraserverhelloworld.repository.CountryRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author avbravo
 */
@Path("/country")
@ApplicationScoped
public class CountryController {

    

    @Inject
    CountryRepository countryRepository;




    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
     public Response findAll() {
//        List<Country> result = new ArrayList<>();
     List<Country> result = countryRepository.findAll();
               return Response.ok(result).build();
    }
// </editor-fold>

    
}
