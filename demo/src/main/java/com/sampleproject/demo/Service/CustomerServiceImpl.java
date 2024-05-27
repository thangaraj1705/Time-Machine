package com.sampleproject.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sampleproject.demo.CustomerRepo.CustomerRepo;
import com.sampleproject.demo.DTO.CustomerDTO;
import com.sampleproject.demo.DTO.CustomerSaveDTO;
import com.sampleproject.demo.DTO.CustomerUpdateDTO;
import com.sampleproject.demo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepo customerRepo;

	@Override
	public String addCustomer(CustomerSaveDTO customerSaveDTO) {
		
		Customer customer=new Customer(
				customerSaveDTO.getCustomername(),customerSaveDTO.getCustomeraddress(),customerSaveDTO.getMobile()
				); 
		
		customerRepo.save(customer);
		return customer.getCustomername();
	}

	@Override
	public List<CustomerDTO> getAllCustomer() {
		List<Customer> getCustomers=customerRepo.findAll();
		List<CustomerDTO> customerDTOList=new ArrayList<>();
		for(Customer customer:getCustomers) {
			CustomerDTO customerDTO=new CustomerDTO(
					customer.getCustomerid(),
					customer.getCustomername(),
					customer.getCustomeraddress(),
					customer.getMobile());
			customerDTOList.add(customerDTO);
		}
		
		return customerDTOList;
	}

	@Override
	public String updateCustomer(CustomerUpdateDTO customerUpdateDTO) {
		
		if(customerRepo.existsById(customerUpdateDTO.getCustomerid())) {
			Customer customer=customerRepo.getById(customerUpdateDTO.getCustomerid());
			customer.setCustomername(customerUpdateDTO.getCustomername());
			customer.setCustomeraddress(customerUpdateDTO.getCustomeraddress());
			customer.setMobile(customerUpdateDTO.getMobile());
			customerRepo.save(customer);
		}
		else {
			System.out.println("customer id is do not exists");
		}
		return null;
	}
	
	@Override
	public Boolean deleteCustomer(int id) {
		if(customerRepo.existsById(id)) {
			customerRepo.deleteById(id);
		}
		else {
			System.out.println("Customer not Available!!!");
		}
		return true;
	}
	
	

}
