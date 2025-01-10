package com.avbravo.jettraserverhelloworld.view;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import com.avbravo.jettraserverhelloworld.services.EmployeeService;
import com.jettraserver.definition.JettraView;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

/**
 *
 * @author avbravo
 */
@Path("/view/empleado")
public class EmpleadoView implements JettraView{

    @Inject
    EmployeeService employeeService;
   

    @Override
    public Response draw() {
        return generate("com/web/pages/empleado.html");
    }

}