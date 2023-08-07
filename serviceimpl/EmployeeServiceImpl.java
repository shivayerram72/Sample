package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Exception.ResourceNotFound;
import com.example.demo.module.Employee;
import com.example.demo.repo.EmployeeRepo;
import com.example.demo.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepo repo;

	@Override
	public Employee addEmployee(Employee e) {


		return repo.save(e);
	}

	@Override
	public Employee getById(Integer eid) {


		return repo.findById(eid).orElseThrow(()->new ResourceNotFound("Employee", "Id", eid));
	}

	@Override
	public List<Employee> getByDesignation(String designation) {
		return repo.findByDesignation(designation);
	}

	@Override
	public List<Employee> getByLessSal(Double sal) {
		return repo.findByLessSal(sal);
	}

	@Override
	public Employee updateEmployee(Employee e) {

		Employee e1=repo.findById(e.getEid()).orElse(null);
		if(e1!=null)
		{
			e1.setEname(e1.getEname());
			e1.setDesignation(e1.getDesignation());
			e1.setSal(e1.getSal());
			e1.setPhno(e1.getPhno());
			return repo.save(e1);
		}
		else
		{
			throw new ResourceNotFound("Employee", "id", e.getEid());
		}
	}



}
