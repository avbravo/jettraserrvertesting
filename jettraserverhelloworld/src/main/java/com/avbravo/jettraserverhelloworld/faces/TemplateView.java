package com.avbravo.jettraserverhelloworld.faces;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import com.avbravo.jettraserverhelloworld.services.EmployeeService;
import jakarta.inject.Inject;
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
@Path("/view/template")
public class TemplateView {

    @Inject
    EmployeeService employeeService;

    @GET
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.TEXT_HTML)

    public Response get() {

        var html = """
                 <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Entity Management</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <link href="https://getbootstrap.com/docs/4.0/examples/dashboard/dashboard.css" rel="stylesheet">

    <!-- Bootstrap Icons CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.5.0/font/bootstrap-icons.min.css">

    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .content {
            margin-top: 56px; /* Height of the top navbar */
            flex-grow: 1;
            padding: 20px;
        }
    </style>
</head>
<body>
    <nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0">
        <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#">Employee Management System</a>
        <input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search">
        <ul class="navbar-nav px-3">
            <li class="nav-item text-nowrap">
                <a class="nav-link" href="#">Sign out</a>
            </li>
        </ul>
    </nav>

    <div class="container-fluid">
        <div class="row">
            <nav class="col-md-2 d-none d-md-block bg-light sidebar">
                <div class="sidebar-sticky">
                    <ul class="nav flex-column">
                        <li class="nav-item">
                            <a class="nav-link active" href="#" id="homeLink">
                                <i class="bi bi-house"></i>
                                Dashboard <span class="sr-only">(current)</span>
                            </a>
                        </li>
                       
                        <li class="nav-item">
                            <a class="nav-link" href="#" id="employeeLink">
                                <i class="bi bi-people"></i>
                                Employees
                            </a>
                        </li>
                       
                        <li class="nav-item">
                            <a class="nav-link" href="#" id="departmentLink">
                                <i class="bi bi-building"></i>
                                Department
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#" id="managerLink">
                                <i class="bi bi-user-tie"></i>
                                Manager
                            </a>
                        </li>
                    </ul>

                    <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
                        <span>Others</span>
                        <a class="d-flex align-items-center text-muted" href="#">
                            <i class="bi bi-plus-circle"></i>
                        </a>
                    </h6>
                    <ul class="nav flex-column mb-2">
                        <li class="nav-item">
                            <a class="nav-link" href="#" id="aboutUsLink">
                                <i class="bi bi-info-circle"></i>
                                About US
                            </a>
                        </li>
                    </ul>
                </div>
            </nav>

            <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4 content" id="content">
                   
                   
            </main>
        </div>
    </div>

    <!-- Custom script to load content -->
    <script>
    $(document).ready(function () {
            function loadContent(page) {
                $('#content').load(page);
            }
            
            $('#employeeLink').on('click', function () {
                                   loadContent('http://localhost:8080/api/view/employee');
            });
            $('#departmentLink').on('click', function () {
                loadContent('department.html');
            });
            $('#managerLink').on('click', function () {
                loadContent('manager.html');
            });
            $('#homeLink').on('click', function () {
                loadContent('http://localhost:8080/api/view/home');
            });
            $('#aboutUsLink').on('click', function () {
                loadContent('http://localhost:8080/api/view/about');
            });
            // Load default page
            loadContent('http://localhost:8080/api/view/home');
        });
    </script>
</body>
</html>
           """;
        return Response.ok(html).build();
    }
}
