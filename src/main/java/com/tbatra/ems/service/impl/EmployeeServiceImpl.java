package com.tbatra.ems.service.impl;

import com.tbatra.ems.dto.EmployeeDTO;
import com.tbatra.ems.entity.Employee;
import com.tbatra.ems.exception.NotFoundException;
import com.tbatra.ems.mapper.EmployeeMapper;
import com.tbatra.ems.repository.EmployeeRepository;
import com.tbatra.ems.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepository employeeRepository;

    private EmployeeServiceImpl (EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDTO);

        return EmployeeMapper.mapToEmployeeDTO(employeeRepository.save(employee));

    }

    @Override
    public EmployeeDTO getEmployee(Long id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new NotFoundException("Employee does not exist with given id : " + id));

        return EmployeeMapper.mapToEmployeeDTO(employee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeDTO> employeeDTOS = employeeRepository
                .findAll()
                .stream()
                .map(employee -> EmployeeMapper.mapToEmployeeDTO(employee))
                .collect(Collectors.toList());

        return employeeDTOS;
    }

    @Override
    public EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO employeeDTO) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new NotFoundException("Employee does not exist with given id : " + employeeId));

        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setEmail(employeeDTO.getEmail());

        EmployeeDTO upatedEmploeeDTO = EmployeeMapper.mapToEmployeeDTO(employee);

        return upatedEmploeeDTO;
    }

    @Override
    public void deleteEmployee(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new NotFoundException("Employee does not exist with given id : " + employeeId));

        employeeRepository.delete(employee);

    }
}
