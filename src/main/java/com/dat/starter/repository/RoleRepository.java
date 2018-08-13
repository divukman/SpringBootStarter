package com.dat.starter.repository;

import com.dat.starter.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository()
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRole(final String role);
}
