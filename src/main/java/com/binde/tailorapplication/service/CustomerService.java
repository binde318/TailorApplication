package com.binde.tailorapplication.service;

import com.binde.tailorapplication.dto.request.CustomerDTO;
import com.binde.tailorapplication.dto.response.CustomerResponseDTO;
import com.binde.tailorapplication.dto.response.PaginationResponse;
import com.binde.tailorapplication.entity.Designer;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
@Service
public interface CustomerService {
    PaginationResponse getAllCustomers(HttpServletRequest request, String searchTerm, int pageNo, int pageSize, String sortBy, String sortDir);
    CustomerResponseDTO editCustomerById(String Id, CustomerDTO customerDto);

    CustomerResponseDTO getCustomerById(String Id) throws RuntimeException;
    CustomerResponseDTO getCustomerByEmail(String email);

    void deleteCustomer(String Id);
    int countCustomers(HttpServletRequest request);
    CustomerResponseDTO createCustomer(CustomerDTO requestDTO, HttpServletRequest request);
    Designer getDesignerProfile(HttpServletRequest request);
}
