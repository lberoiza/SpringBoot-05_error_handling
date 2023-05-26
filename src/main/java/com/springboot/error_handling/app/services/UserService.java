package com.springboot.error_handling.app.services;

import java.util.List;
import java.util.ArrayList;

import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.springboot.error_handling.app.exceptions.UserNotFoundException;
import com.springboot.error_handling.app.interfaces.services.IDataServices;
import com.springboot.error_handling.app.models.User;

@Primary
@Service("UserService")
public class UserService implements IDataServices<User, UserNotFoundException> {

  private List<User> list;

  public UserService() {
    list = new ArrayList<>();
    list.add(new User(1, "Luis", "Beroiza"));
    list.add(new User(2, "Marcos", "Dante"));
    list.add(new User(3, "Juan", "Ramirez"));
    list.add(new User(4, "Elisabeth", "Smith"));
    list.add(new User(5, "Catalina", "Salazar"));
    list.add(new User(6, "Andrea", "Martinez"));
  }

  @Override
  public List<User> getList() {
    return list;
  }

  @Override
  public User getById(Integer id) throws UserNotFoundException {
    Optional<User> result = list.stream().filter(user -> user.getId() == id).findFirst();
    
    if(result.isEmpty()) throw UserNotFoundException.fromId(id);
    
    return result.orElse(null);
  }

}
