/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.jettraserverhelloworld.view;

import com.avbravo.jettraserverhelloworld.model.Country;
import com.avbravo.jettraserverhelloworld.model.Employee;
import com.avbravo.jettraserverhelloworld.repository.CountryRepository;
import com.avbravo.jettraserverhelloworld.services.EmployeeService;
import com.jettraserver.view.JettraView;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import java.util.List;
import static j2html.TagCreator.*;
import jakarta.inject.Inject;

/**
 *
 * @author avbravo
 */
@Path("/view/jmoordbj2html")
public class JmoordbJ2htmlView implements JettraView{
  @Inject
    CountryRepository countryRepository;
  
    @Override
    public Response draw() {
        List<Country> result = countryRepository.findAll();
        var bod = body(
                div(attrs("#country"),
                        p("Some sibling element"),
                        each(filter(result, country -> country != null), country
                                -> div(attrs(".country"),
                                h2(country.getIdcountry()),
                                p(country.getCountry())
                        )
                        )
                )
        ).render();

        return Response.ok(bod).build();
        
    }

  

//  
}
