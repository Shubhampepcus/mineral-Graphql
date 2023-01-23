package com.graphql.learn.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.graphql.learn.entities.Company;
import com.graphql.learn.entities.User;
import com.graphql.learn.repositories.CompanyRepository;

@Component
@Service
public class CompanyService {
    
    @Autowired 
    private CompanyRepository companyRepository;
    
    public List<Company> getCompanyList(){
        return companyRepository.findAll();
        
    }

    public Company getCompanyById(int companyId) {
        return companyRepository.findByCompanyId(companyId);
    }
    

}
