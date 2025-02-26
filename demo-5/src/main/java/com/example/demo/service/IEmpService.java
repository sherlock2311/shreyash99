package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.EmpDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;

public interface IEmpService {

	String deleteEmp(int id);

	Employee updateEmp(Employee emp, int id) throws ResourceNotFoundException;

	List<Employee> getEmpDetails();

	//String saveEmp(Employee emp);

	String saveEmp(EmpDto emp);

}
