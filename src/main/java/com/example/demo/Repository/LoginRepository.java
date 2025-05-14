package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.LoginEntity.LoginEntitys;

@Repository
public interface LoginRepository extends JpaRepository<LoginEntitys, Integer> {
    LoginEntitys findByEmail(String email);
}
