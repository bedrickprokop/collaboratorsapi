package br.com.collaboratorsapi.model.service;

import br.com.collaboratorsapi.model.entity.Collaborator;

import java.util.List;

public interface CollaboratorService {

    Collaborator create(Collaborator collaborator);

    Collaborator findOne(Integer collaboratorCode);

    List<Collaborator> findAll();

    Collaborator update(Collaborator collaborator);

    Collaborator delete(Integer collaboratorCode);
}
