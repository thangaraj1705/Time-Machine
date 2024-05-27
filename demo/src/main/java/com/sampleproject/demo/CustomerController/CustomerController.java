package com.sampleproject.demo.CustomerController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sampleproject.demo.DTO.CustomerDTO;
import com.sampleproject.demo.DTO.CustomerSaveDTO;
import com.sampleproject.demo.DTO.CustomerUpdateDTO;
import com.sampleproject.demo.Service.CustomerService;


@RestController
@CrossOrigin
@RequestMapping("api/v1/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping(path="/save")
	public String saveCustomer(@RequestBody CustomerSaveDTO customerSaveDTO) {
		
		String id=customerService.addCustomer(customerSaveDTO);
		
		return id;
		
	}
	@GetMapping(path="/getAllCustomer")
	public List<CustomerDTO> getAllCustomer() {
		
List<CustomerDTO>allCustomers=customerService.getAllCustomer();		
		return allCustomers;
		
	}
	
	@PostMapping(path="/update")
	public String updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO) {
		
		String id=customerService.updateCustomer(customerUpdateDTO);
		
		return id;
		
	}
	
	@DeleteMapping(path="/delete/{id}")
	public String deleteCustomer(@PathVariable (value="id") int id) {
		
		Boolean deletecustomer=customerService.deleteCustomer(id);
		
		
		return "Deleted";
		
	}


}
