package br.com.collaboratorsapi.model.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Locale;

@Repository
public class BaseDao<T> {

    @Autowired
    private MessageSource messageSource;

    @PersistenceContext
    protected EntityManager entityManager;

    private Class<T> getGenericTypeClass() {
        try {

            String className = ((ParameterizedType) getClass().getGenericSuperclass())
                    .getActualTypeArguments()[0].getTypeName();

            Class<?> clazz = Class.forName(className);
            return (Class<T>) clazz;
        } catch (Exception e) {

            String message = messageSource.getMessage("internal.error.class.notgeneric",
                    null, LocaleContextHolder.getLocale());

            throw new IllegalStateException(message, e);
        }
    }

    public T create(T entity) {
        entityManager.persist(entity);
        return entity;
    }

    public T findOne(Integer entityId) {
        try {
            return entityManager.find(getGenericTypeClass(), entityId);
        } catch (PersistenceException e) {
            throw new RuntimeException(e);
        }
    }

    public List<T> findAll() {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaBuilderQuery = criteriaBuilder.createQuery(getGenericTypeClass());
        Root<T> rootEntry = criteriaBuilderQuery.from(getGenericTypeClass());
        CriteriaQuery<T> all = criteriaBuilderQuery.select(rootEntry);
        TypedQuery<T> allQuery = entityManager.createQuery(all);

        return allQuery.getResultList();
    }

    public T update(T entity) {
        return entityManager.merge(entity);
    }

    public T delete(T entity) {
        entityManager.remove(entity);
        return entity;
    }

}
