package com.jisellemartins.arq.carrinho.service;

import java.util.List;

public interface GenericService<T> {
    List<T> getAll();

    T get(Integer id, String noSuchElementException);

    void save(T entity);

    void update(T entity);

    void delete(Integer id);
}
