package org.filterTest.filterexam4.service;

import lombok.RequiredArgsConstructor;
import org.filterTest.filterexam4.entity.Role;
import org.filterTest.filterexam4.entity.User;
import org.filterTest.filterexam4.repository.RoleRepository;
import org.filterTest.filterexam4.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    // 회원가입
    @Transactional
    public User registerUser(User user){
        // 회원가입을 위해서 Role을 알아와서, Role 정보를 찾아 넣어주어야 함
        // 이 메서드를 통해서, 회원가입한 회원은 일반회원이라고 가정하고 ROLE_USER로 Role을 얻어와서 저장합시다.
        Role userRole = roleRepository.findByName("ROLE_USER");
        user.setRoles(Collections.singleton(userRole));

        return userRepository.save(user);
    }

    // 회원정보보기
    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }
}
