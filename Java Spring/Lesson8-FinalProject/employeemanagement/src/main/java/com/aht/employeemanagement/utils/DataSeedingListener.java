package com.aht.employeemanagement.utils;

import com.aht.employeemanagement.model.admin.Role;
import com.aht.employeemanagement.model.admin.User;
import com.aht.employeemanagement.repository.RoleRepository;
import com.aht.employeemanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class DataSeedingListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent arg0) {
        // Roles
        if (roleRepository.findByName("ADMIN") == null) {
            roleRepository.save(new Role("ADMIN"));
        }

        if (roleRepository.findByName("USER") == null) {
            roleRepository.save(new Role("USER"));
        }

        // Admin account
        if (userRepository.findByMail("admin@gmail.com") == null) {
            User admin = new User();
            admin.setMail("admin@gmail.com");
            admin.setPass(passwordEncoder.encode("123456"));
            HashSet<Role> roles = new HashSet<>();
            roles.add(roleRepository.findByName("ADMIN"));
            roles.add(roleRepository.findByName("USER"));
            admin.setRoles(roles);
            userRepository.save(admin);
        }

        // Member account
        if (userRepository.findByMail("member@gmail.com") == null) {
            User user = new User();
            user.setMail("member@gmail.com");
            user.setPass(passwordEncoder.encode("123456"));
            HashSet<Role> roles = new HashSet<>();
            roles.add(roleRepository.findByName("USER"));
            user.setRoles(roles);
            userRepository.save(user);
        }
    }
}
