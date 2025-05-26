package com.friend.farmers.respository;

import com.friend.farmers.models.AppRole;
import com.friend.farmers.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {

    Optional<Role> findByRoleName(AppRole appRole);
}
