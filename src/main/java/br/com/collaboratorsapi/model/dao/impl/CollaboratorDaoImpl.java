package br.com.collaboratorsapi.model.dao.impl;

import br.com.collaboratorsapi.model.dao.CollaboratorDao;
import br.com.collaboratorsapi.model.entity.Collaborator;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CollaboratorDaoImpl extends BaseDao<Collaborator> implements CollaboratorDao {

    @Override
    public Collaborator create(Collaborator collaborator) {
        return super.create(collaborator);
    }

    @Override
    public Collaborator findOne(Integer collaboratorCode) {
        return super.findOne(collaboratorCode);
    }

    @Override
    public List<Collaborator> findAll() {
        return super.findAll();
    }

    @Override
    public Collaborator update(Collaborator collaborator) {
        return super.update(collaborator);
    }

    @Override
    public Collaborator delete(Collaborator collaborator) {
        return super.delete(collaborator);
    }
}
