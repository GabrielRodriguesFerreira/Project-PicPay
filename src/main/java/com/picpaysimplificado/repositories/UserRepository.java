package com.picpaysimplificado.repositories;

import com.picpaysimplificado.domain.user.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findUserByDocument(String document);
  Optional<User> findUserById(Long id);
}
