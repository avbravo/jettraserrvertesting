/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.jettraserverhelloworld.controller;

/**
 *
 * @author avbravo
 */
import com.avbravo.jettraserverhelloworld.model.Employee;
import com.avbravo.jettraserverhelloworld.services.EmployeeService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@Path("/employees")
@ApplicationScoped
public class EmployeeController {

//       @Inject
//    @ConfigProperty(name = "defaultName")
//    private String defaultName;
       
     @Inject
    EmployeeService employeeService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
//       @Operation(summary = "Obtiene todos los proyectoes", description = "Retorna todos los proyectoes disponibles")
//    @APIResponse(responseCode = "500", description = "Servidor inalcanzable")
//    @APIResponse(responseCode = "200", description = "Los proyectoes")
//    @Tag(name = "BETA", description = "Esta api esta en desarrollo")
//    @APIResponse(description = "Employyee", responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Collection.class, readOnly = true, description = "employees", required = true, name = "employees")))
    public Response getAll() {
        List<Employee> result = employeeService.getAllEmployees();
        return Response.ok(result).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(Employee employee) throws URISyntaxException {
        int newEmployeeId = employeeService.addEmployee(employee);
        URI uri = new URI("/employees/" + newEmployeeId);
        return Response.created(uri).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response update(@PathParam("id") int id, Employee employee) {
        Optional<Employee> match = employeeService.getAllEmployees().stream().filter(c -> c.getId() == id).findFirst();
        Employee updateEmployee = match.get();
        updateEmployee.setFirstname(employee.getFirstname());
        updateEmployee.setLastname(employee.getLastname());
        updateEmployee.setJobTitle(employee.getJobTitle());
        employeeService.update(updateEmployee);
        return Response.ok().build();
    }   
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getEmployee(@PathParam("id") int id) {
        Optional<Employee> match = employeeService.getAllEmployees().stream().filter(c -> c.getId() == id).findFirst();
        Employee emp = match.get();
        if (match.isPresent()) {
            return Response.ok(emp, MediaType.APPLICATION_JSON).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") int id) {
        Optional<Employee> match = employeeService.getAllEmployees().stream().filter(c -> c.getId() == id).findFirst();
        Employee newEmployee = match.get();
        employeeService.delete(newEmployee);       
        return Response.ok().build();
    }
}
