package br.com.ricardoribeiro.supplier_api.repository;

import br.com.ricardoribeiro.supplier_api.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Long> {

    UserDetails findByEmail(String email);

}
