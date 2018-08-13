package com.dat.starter.bootstrap;

import com.dat.starter.domain.Role;
import com.dat.starter.domain.User;
import com.dat.starter.repository.RoleRepository;
import com.dat.starter.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class BootstrapCmdRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(BootstrapCmdRunner.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void run(String... args) throws Exception {

        logger.info("Bootstrapping the app...");

        Role roleAdmin = new Role("ROLE_ADMIN");
        Role roleUser = new Role("ROLE_USER");

        roleRepository.save(roleAdmin);
        roleRepository.save(roleUser);

        User userAdmin = new User("admin", "admin",bCryptPasswordEncoder.encode("password"), true);
        userRepository.save(userAdmin);
        userAdmin.addRole(roleAdmin);
        userRepository.save(userAdmin);

        User user = new User("user", "user",bCryptPasswordEncoder.encode("password"), true);
        userRepository.save(user);
        user.addRole(roleUser);
        userRepository.save(user);
    }
}
