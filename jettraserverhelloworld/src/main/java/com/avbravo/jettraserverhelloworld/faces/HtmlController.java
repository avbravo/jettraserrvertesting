/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.jettraserverhelloworld.faces;

import com.avbravo.jettraserverhelloworld.model.Employee;
import com.avbravo.jettraserverhelloworld.services.EmployeeService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import static j2html.TagCreator.*;
import jakarta.inject.Inject;

/**
 *
 * @author avbravo
 */
@Path("/view/html")
public class HtmlController {
    @Inject
    EmployeeService employeeService;
    
    @GET
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.TEXT_HTML)

    public Response getAll() {

//        var bod = body(
//                h1("Hello, World!"),
//                img().withSrc("/img/hello.png")
//        ).render();
//
//        return Response.ok(bod).build();
         List<Employee> result = employeeService.getAllEmployees();
    var bod =      body(
    div(attrs("#employees"),
        p("Some sibling element"),
        each(filter(result, employee -> employee != null), employee ->
            div(attrs(".employee"),
                h2(employee.getFirstname()),
                img().withSrc(employee.getJobTitle()),
                p(employee.getLastname())
            )
        )
    )
).render();
        
             return Response.ok(bod).build();
        
        
    }

}
