package com.Heuy.students.Admin.repo;

import com.Heuy.students.Admin.entites.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Long> {
}
