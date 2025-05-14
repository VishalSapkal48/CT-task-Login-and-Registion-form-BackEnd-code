package com.example.demo.Service;

import com.example.demo.LoginEntity.LoginEntitys;

public interface ServiceLinterface {
	     String register(LoginEntitys entity);
	     boolean login(String email, String password);

}
