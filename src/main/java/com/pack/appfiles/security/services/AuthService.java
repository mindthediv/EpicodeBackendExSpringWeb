package com.pack.appfiles.security.services;

import com.pack.appfiles.security.payloads.LoginDto;
import com.pack.appfiles.security.payloads.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    
}
