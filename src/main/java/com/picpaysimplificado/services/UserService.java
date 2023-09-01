package com.picpaysimplificado.services;

import com.picpaysimplificado.domain.user.User;
import com.picpaysimplificado.domain.user.UserType;
import com.picpaysimplificado.repositories.UserRepository;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserRepository repository;

  public void validateTransaction(User sender, BigDecimal amount)
    throws Exception {
    if (sender.getUserType() == UserType.MERCHANT) {
      throw new Exception("USUARIO NÃO ESTA AUTORIZADO A REALIZAR TRANSAÇÕES");
    }

    if (sender.getBalance().compareTo(amount) < 0) {
      throw new Exception("USUARIO NÃO TEM SALDO SUFICIENTE");
    }
  }

  public User findUserById(Long id) throws Exception {
    return this.repository.findUserById(id)
      .orElseThrow(() -> new Exception("USUARIO NAO ENCONTRADO"));
  }

  public void saveUser(User user) throws Exception {
    this.repository.save(user);
  }
}
