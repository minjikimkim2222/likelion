package org.jwtExam.service;

import lombok.RequiredArgsConstructor;
import org.jwtExam.domain.Role;
import org.jwtExam.domain.User;
import org.jwtExam.repository.RoleRepository;
import org.jwtExam.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder; // 비밀번호 암호화를 위한 injection
    // 회원가입
    public User registerUser(User user){
        // User객체에 role 추가할 것
        Role userRole = roleRepository.findByName("USER");
        user.setRoles(Collections.singleton(userRole));

        // 받아온 user 비번을, passwordEncoding해서 넣어주어야 함 !!
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }
}
