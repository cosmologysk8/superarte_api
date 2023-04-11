package app.api.superarte.repository;

import app.api.superarte.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {

    public Users findByEmail(String email);

}
