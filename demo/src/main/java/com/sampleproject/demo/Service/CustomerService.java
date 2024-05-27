package com.sampleproject.demo.Service;

import java.util.List;

import com.sampleproject.demo.DTO.CustomerDTO;
import com.sampleproject.demo.DTO.CustomerSaveDTO;
import com.sampleproject.demo.DTO.CustomerUpdateDTO;

public interface CustomerService {

	String addCustomer(CustomerSaveDTO customerSaveDTO);

	List<CustomerDTO> getAllCustomer();

	String updateCustomer(CustomerUpdateDTO customerUpdateDTO);

	Boolean deleteCustomer(int id);



}
