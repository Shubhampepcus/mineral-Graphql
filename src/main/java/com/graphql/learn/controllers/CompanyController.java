package com.graphql.learn.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.graphql.learn.entities.Company;
import com.graphql.learn.entities.User;
import com.graphql.learn.services.CompanyService;

@Controller
@RequestMapping
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/companies")
    public List<Company> getCompanyList() {
        return companyService.getCompanyList();
    }

    @QueryMapping("allCompanies")
    public List<Company> getComList() {
        return companyService.getCompanyList();
    }
    
    @QueryMapping("getCompany")
    public Company getCompanyById(@Argument int companyId){
        return companyService.getCompanyById(companyId);
    }

}
