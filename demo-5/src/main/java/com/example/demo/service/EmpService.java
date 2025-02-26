package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IEmpDao;
import com.example.demo.dto.EmpDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;


@Service
public class EmpService implements IEmpService {
	@Autowired
	IEmpDao empdao;
	
	@Override
	public String deleteEmp(int id) {
		// TODO Auto-generated method stub
		empdao.deleteById(id);
		return "Deleted";
	}
	public Employee getByEmpId(int id) throws ResourceNotFoundException  {
		Optional<Employee> emp = empdao.findById(id);
		if(emp.isPresent()) {
			return emp.get();
		}else {
			throw new ResourceNotFoundException("Emp id not fount exception");
		}
		}
	@Override
	public String saveEmp(EmpDto emp) {
		// TODO Auto-generated method stub
		
//		emp1.setEmpId(emp.getEmpId());
//		emp1.setEmpName(emp.getEmpName());
		Employee emp1=new Employee();
		
		ModelMapper model=new ModelMapper();
		model.map(emp,emp1);
		empdao.save(emp1);
		return "Emp is Saved";
	}
	@Override
	public List<Employee> getEmpDetails() {
		// TODO Auto-generated method stub
		return empdao.findAll();
	}
	@Override
	public Employee updateEmp(Employee emp, int id) throws ResourceNotFoundException {
			return empdao.save(emp);
		    }

 }


