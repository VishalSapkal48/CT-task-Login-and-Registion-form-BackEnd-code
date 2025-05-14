package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.LoginEntity.LoginEntitys;
import com.example.demo.Repository.LoginRepository;

@Service
public class ServiceLayerImpl implements ServiceLinterface {

    @Autowired
    private LoginRepository repo;

    @Override
    public String register(LoginEntitys entity) {

        // Check if email already exists
        if (repo.findByEmail(entity.getEmail()) != null) {
            return "Email already exists";
        }

        // Check for empty name
        if (entity.getFullName() == null || entity.getFullName().trim().isEmpty()) {
            return "Full name is required";
        }

      
        String emailRegex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        if (!entity.getEmail().matches(emailRegex)) {
            return "Invalid email format";
        }

        // passwrod regex: 8–15 chars, 1 uppercase, 1 lowercase, 1 special, 1 digit
        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[@.#$!%*?&])(?=.*\\d)[a-zA-Z\\d@.#$!%*?&]{8,15}$";
        if (!entity.getPassword().matches(passwordRegex)) {
            return "Password must be 8–15 characters, include upper/lowercase, digit, and special char";
        }

       
        repo.save(entity);
        return "Success";
    }



    @Override
    public boolean login(String email, String password) {
        LoginEntitys entity = repo.findByEmail(email);
        return entity != null && entity.getPassword().equals(password);
    }
}
