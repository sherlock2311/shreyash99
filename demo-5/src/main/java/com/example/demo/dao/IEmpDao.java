package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Employee;

public interface IEmpDao extends JpaRepository<Employee,Integer>{

}
