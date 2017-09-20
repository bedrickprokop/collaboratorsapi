package br.com.collaboratorsapi.model.service.impl;

import br.com.collaboratorsapi.exception.ApplicationException;
import br.com.collaboratorsapi.model.dao.CollaboratorDao;
import br.com.collaboratorsapi.model.entity.Collaborator;
import br.com.collaboratorsapi.model.service.CollaboratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.core.Response;
import java.util.List;

//TODO analisar anotações de transação e add para cada método exceto os de busca
@Service
@Transactional
public class CollaboratorServiceImpl implements CollaboratorService {

    @Autowired
    private CollaboratorDao collaboratorDao;

    @Override
    public Collaborator create(Collaborator collaborator) {
        return collaboratorDao.create(collaborator);
    }

    @Override
    public Collaborator findOne(Integer collaboratorCode) {
        Collaborator collaborator = collaboratorDao.findOne(collaboratorCode);
        if (null != collaborator) {
            return collaborator;
        }
        throw new ApplicationException("response.error.entity.notfound",
                Response.Status.NOT_FOUND.getStatusCode());
    }

    @Override
    public List<Collaborator> findAll() {
        return collaboratorDao.findAll();
    }

    @Override
    public Collaborator update(Collaborator collaborator) {
        if (null != collaborator.getCode()) {
            return collaboratorDao.update(collaborator);
        }
        throw new ApplicationException("response.error.missing.attribute",
                Response.Status.BAD_REQUEST.getStatusCode());
    }

    @Override
    public Collaborator delete(Integer collaboratorCode) {
        Collaborator collaborator = collaboratorDao.findOne(collaboratorCode);
        if (null != collaborator) {
            return collaboratorDao.delete(collaborator);
        }
        throw new ApplicationException("response.error.entity.notfound",
                Response.Status.NOT_FOUND.getStatusCode());
    }
}
