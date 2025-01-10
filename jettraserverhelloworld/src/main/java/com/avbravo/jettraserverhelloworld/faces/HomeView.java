/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.jettraserverhelloworld.faces;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 *
 * @author avbravo
 */
@Path("/view/home")
public class HomeView {

    @GET
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.TEXT_HTML)

    public Response get() {

        var html = """
    <div>
    <h2>Jettra View</h2>
    <p>Genera Vistas y Formularios MVC.</p>
</div>
          """;
        return Response.ok(html).build();
    }

}
