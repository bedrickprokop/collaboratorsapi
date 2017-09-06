package br.com.collaboratorsapi.model.dao;

import br.com.collaboratorsapi.model.entity.Collaborator;

import java.util.List;

public interface CollaboratorDao {

    Collaborator create(Collaborator collaborator);

    Collaborator findOne(Integer collaboratorCode);

    List<Collaborator> findAll();

    Collaborator update(Collaborator collaborator);

    Collaborator delete(Collaborator collaborator);

}
