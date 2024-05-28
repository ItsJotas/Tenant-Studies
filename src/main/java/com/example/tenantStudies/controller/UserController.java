package com.example.tenantStudies.controller;

import com.example.tenantStudies.model.User;
import com.example.tenantStudies.service.UserService;
import com.example.tenantStudies.tenant.TenantContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/{brand}/user")
public class UserController{

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User getUser(@PathVariable String brand, @PathVariable Long id){
        TenantContext.getInstance().setCurrentTenant(brand);

        return userService.findById(id);
    }
}
