package br.com.collaboratorsapi.model.service;

import java.util.List;

public interface GenericService<T> {

    T create(T entity);

    T findOne(Integer entityCode);

    List<T> findAll();

    T update(T entity);

    T delete(Integer entityCode);
}
