package com.tbatra.ems.service;

import com.tbatra.ems.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO getEmployee(Long id);

    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO employeeDTO);

    void deleteEmployee(Long employeeId);

}
