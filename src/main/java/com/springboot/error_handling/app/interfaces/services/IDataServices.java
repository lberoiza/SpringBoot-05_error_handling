package com.springboot.error_handling.app.interfaces.services;

import java.util.List;

public interface IDataServices<T extends Object> {

  public List<T> getList();

  public T getById(Integer id);

}
