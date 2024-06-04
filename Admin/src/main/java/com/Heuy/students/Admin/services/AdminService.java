package com.Heuy.students.Admin.services;

import com.Heuy.students.Admin.entites.Admin;
import com.Heuy.students.Admin.repo.AdminRepo;
import org.springframework.stereotype.Service;

@Service
public record AdminService(AdminRepo adminRepo) {
    String AddAdmin(Admin admin){
        adminRepo.save(admin);
        return "admin added";
    }
}
