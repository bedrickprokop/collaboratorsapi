package br.com.collaboratorsapi.model.dao.impl;

import br.com.collaboratorsapi.model.dao.CollaboratorDao;
import br.com.collaboratorsapi.model.entity.Collaborator;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CollaboratorDaoImpl implements CollaboratorDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Collaborator create(Collaborator collaborator) {
        entityManager.persist(collaborator);
        return collaborator;
    }

    @Override
    public Collaborator findOne(Integer collaboratorCode) {
        return entityManager.find(Collaborator.class, collaboratorCode);
    }

    @Override
    public List<Collaborator> findAll() {
        String query = "SELECT NEW Collaborator(c.code, c.name, c.login, c.profile) FROM Collaborator c";
        TypedQuery<Collaborator> typedQuery = entityManager.createQuery(query, Collaborator.class);
        return typedQuery.getResultList();
    }

    @Override
    public Collaborator update(Collaborator collaborator) {
        return entityManager.merge(collaborator);
    }

    @Override
    public Collaborator delete(Collaborator collaborator) {
        entityManager.remove(collaborator);
        return collaborator;
    }
}
