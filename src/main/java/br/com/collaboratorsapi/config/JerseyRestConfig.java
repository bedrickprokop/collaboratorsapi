package br.com.collaboratorsapi.config;

import br.com.collaboratorsapi.controller.CollaboratorController;
import br.com.collaboratorsapi.exception.ApplicationExceptionMapper;
import br.com.collaboratorsapi.exception.ValidationExceptionMapper;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

@Configuration
@ApplicationPath("api")
public class JerseyRestConfig extends ResourceConfig {

    @PostConstruct
    private void init() {
        registerControllers();
        registerMappers();
    }

    private void registerControllers() {
        registerClasses(CollaboratorController.class);
    }

    private void registerMappers() {
        registerClasses(ApplicationExceptionMapper.class,
                ValidationExceptionMapper.class);
    }
}