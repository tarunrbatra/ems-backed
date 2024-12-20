package com.tbatra.ems.controller;

import com.tbatra.ems.dto.EmployeeDTO;
import com.tbatra.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Endpoint to create a new employee
    @PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO savedEmployee = employeeService.createEmployee(employeeDTO);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable("id") Long employeeId) {
        EmployeeDTO employeeDTO = employeeService.getEmployee(employeeId);
        return ResponseEntity.ok(employeeDTO);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployee() {
        List<EmployeeDTO> employeeDTOs = employeeService.getAllEmployees();

        return ResponseEntity.ok(employeeDTOs);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable("id") Long employeeId,
                                                      @RequestBody EmployeeDTO updatedEmployeeDTO) {
        EmployeeDTO employeeDTO = employeeService.updateEmployee(employeeId, updatedEmployeeDTO);
        return ResponseEntity.ok(employeeDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee " + employeeId + " deleted successfully.");
    }


    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello from EMployee Controller");
    }

}
