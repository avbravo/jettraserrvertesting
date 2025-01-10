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
@Path("/view/employee")
public class EmployeeView {

    @Inject
    EmployeeService employeeService;

    @GET
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.TEXT_HTML)

    public Response get() {
        var html = """
         <div class="container mt-5">
    <h1 class="mb-4">Employee</h1>
    <p>Represents an employee in the organization.</p>
    <button class="btn btn-success mb-4" id="newEmployeeButton">Add Employee</button>
    
    <!-- Employee Table -->
    <table id="employeesTable" class="table table-bordered">
        <thead>
            <tr>
                <th>ID</th>
                <th>firstname</th>
                <th>lastname</th>
                <th>jobTitle</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
        </tbody>
    </table>
</div>

<!-- Employee Modal -->
<div class="modal fade" id="employeeModal" tabindex="-1" role="dialog" aria-labelledby="employeeModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="employeeModalLabel">Add Employee</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form id="employeeForm">
                        <div class="form-group">
                            <label for="employeeID">Employee ID:</label>
                            <input type="number" class="form-control" id="employeeID" name="employeeID">
                        </div>
                        
                        <div class="form-group">
                            <label for="name">Name:</label>
                            <input type="text" class="form-control" id="name" name="name">
                        </div>
                        
                        <div class="form-group">
                            <label for="position">Position:</label>
                            <input type="text" class="form-control" id="position" name="position">
                        </div>
                        
//                        <div class="form-group">
//                            <label for="hireDate">Hire Date:</label>
//                            <input type="datetime-local" class="form-control" id="hireDate" name="hireDate">
//                        </div>
                        
//                        <div class="form-group">
//                            <label for="departmentSelect">Department:</label>
//                            <select class="form-control" id="departmentSelect" name="department">
//                                <!-- Department will be populated here -->
//                            </select>
//                        </div>
                        
                    <button type="submit" class="btn btn-primary" id="saveButton">Save</button>
                    <button type="button" class="btn btn-primary" id="updateButton">Update</button>
                </form>
            </div>
        </div>
    </div>
</div>

<script>
    $(document).ready(function () {
                   alert('read function avbravo');`)
        // Fetch all employees and display them
        function loadEmployees() {
                   alert('function');
            $.ajax({
                url: 'http://localhost:8080/api/employees',
                method: 'GET',
                contentType: 'application/json',
                success: function (data) {
                    var tableBody = $('#employeesTable tbody');
                    tableBody.empty();
                    data.forEach(function (employee) {
                         var row = '<tr>' +
                            '<td>' + employee.id + '</td>' +
                            '<td>' + employee.firstname + '</td>' +
                            '<td>' + employee.lastname + '</td>' +
                            '<td>' + employee.jobTitle + '</td>' +
                            '<td class="table-buttons">' +
                            '<button class="btn btn-sm btn-primary mr-1" onclick="editEmployee(\'' + employee.id + '\')">Edit</button>' +
                            '<button class="btn btn-sm btn-danger" onclick="deleteEmployee(\'' + employee.id + '\')">Delete</button>' +
                            '</td>' +
                            '</tr>';
                        tableBody.append(row);
                    });
                },
                    error: function(error) {
                           // Handle any errors here
                           console.error(error);
                   alert("error" +error);
                         }
            });
        }

        loadEmployees();

       

        // Open modal for new employee
        $('#newEmployeeButton').on('click', function () {
            $('#employeeForm')[0].reset();
            $('#employeeID').closest('.form-group').hide();
            $('#employeeModalLabel').text('Add Employee');
            $('#saveButton').show();
            $('#updateButton').hide();
            $('#employeeModal').modal('show');
            loadDepartment();
        });

        // Create new employee
        $('#employeeForm').on('submit', function (e) {
            e.preventDefault();
            var employee = {
                        name: $('#name').val(),
                        position: $('#position').val(),
                        hireDate: $('#hireDate').val(),
                    department: {
                        departmentID: $('#departmentSelect').val()
                    },
            };
            $.ajax({
                url: 'resources/api/employee',
                method: 'POST',
                contentType: 'application/json',
                data: JSON.stringify(employee),
                success: function () {
                    loadEmployees();
                    $('#employeeModal').modal('hide');
                    $('#employeeForm')[0].reset();
                }
            });
        });

        // Update existing employee
        $('#updateButton').on('click', function () {
            var employee = {
                    employeeID: $('#employeeID').val(),
                    name: $('#name').val(),
                    position: $('#position').val(),
                    hireDate: $('#hireDate').val(),
                    department: {
                        departmentID: $('#departmentSelect').val()
                    },
            };
            $.ajax({
                url: 'resources/api/employee',
                method: 'PUT',
                contentType: 'application/json',
                data: JSON.stringify(employee),
                success: function () {
                    loadEmployees();
                    $('#employeeModal').modal('hide');
                    $('#employeeForm')[0].reset();
                }
            });
        });

        // Edit employee (populate form)
        window.editEmployee = function (employeeID) {
            $.ajax({
                url: 'resources/api/employee/' + employeeID,
                method: 'GET',
                contentType: 'application/json',
                success: function (employee) {
                    $('#employeeID').val(employee.employeeID).prop('disabled', true).closest('.form-group').show();
                    $('#name').val(employee.name);
                    $('#position').val(employee.position);
                    $('#hireDate').val(employee.hireDate);
                    $('#departmentSelect').val(employee?.department?.departmentID);
                    $('#employeeModalLabel').text('Edit Employee');
                    $('#saveButton').hide();
                    $('#updateButton').show();
                    $('#employeeModal').modal('show');
                }
            });
        };

        // Delete employee
        window.deleteEmployee = function (employeeID) {
            $.ajax({
                url: 'resources/api/employee/' + employeeID,
                method: 'DELETE',
                success: function () {
                    loadEmployees();
                }
            });
        };
    });
</script>


                   <script
                     src="https://unpkg.com/vue@3/dist/vue.global.js">
                   </script>
                   
                   <script>
                   
                     const app = Vue.createApp({
                       data() {
                         return {
                           message: "Hello World!"
                         }
                       }
                     })
                   
                    app.mount('#app')
                   
                   </script>
                   
                   <div id="app"></div>
           """;
        return Response.ok(html).build();
    }
}