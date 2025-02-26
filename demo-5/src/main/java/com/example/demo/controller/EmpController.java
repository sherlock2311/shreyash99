package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmpDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;

import com.example.demo.service.EmpService;

import jakarta.validation.Valid;
 
//@Controller

@RestController
@RequestMapping("/emp")
public class EmpController {
 
    @Autowired
    EmpService empService;
 
    @GetMapping("/map")
    public static String print() {
    	return "Start done";
    }
 
    @GetMapping("/display")
    public ResponseEntity<List<Employee>> getEmp() throws ResourceNotFoundException{
       return new ResponseEntity<List<Employee>>(empService.getEmpDetails(),HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public Employee updateEmp(@PathVariable int id,@RequestBody Employee emp) throws ResourceNotFoundException {
    	
    	return empService.updateEmp(emp, id);
    }
    
    @PostMapping
    public ResponseEntity<String> saveMap(@Valid @RequestBody EmpDto emp) {
    	String msg=empService.saveEmp(emp);
    	return new ResponseEntity<String>(msg,HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public String deleteStud(@PathVariable int id) {
    	String msg=empService.deleteEmp(id);
    	return msg;
    }
   
    @GetMapping("/")
    public String run() {
        System.out.println("Hello");
        return "Welcome to the future";
    }
 
    	
}
