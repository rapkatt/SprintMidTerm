package com.example.midterm.Controllers;

import com.example.midterm.Models.Customers;
import com.example.midterm.Repositories.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {
    private CustomersRepository customerRepository;

    @Autowired
    public MainController(CustomersRepository customerRepository)
    {
        this.customerRepository = customerRepository;
    }


    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String customers(Model model) {
        List<Customers> customersList = customerRepository.findAll();
        if (customersList != null) {
            model.addAttribute("customers", customersList);
        }
        return "index";
    }

    @PostMapping(value = "/index")
    public String addToCustomers(String firstName, Customers customer) {
        customer.setEmailAddress(firstName);
        customerRepository.save(customer);
        return "redirect:/index";
    }
}