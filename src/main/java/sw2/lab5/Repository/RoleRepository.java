package sw2.lab5.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sw2.lab5.Entity.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
