package br.com.collaboratorsapi.controller;

import br.com.collaboratorsapi.model.entity.Collaborator;
import br.com.collaboratorsapi.model.service.CollaboratorService;
import org.springframework.stereotype.Controller;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Controller
@Path("/collaborator")
public class CollaboratorController {

    @Inject
    private CollaboratorService collaboratorService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@Valid Collaborator collaborator) {
        collaborator = collaboratorService.create(collaborator);
        return Response.ok(collaborator).status(Response.Status.CREATED.getStatusCode()).build();
    }

    @GET
    @Path("{collaboratorCode}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findOne(@PathParam("collaboratorCode") Integer collaboratorCode) {
        Collaborator collaborator = collaboratorService.findOne(collaboratorCode);
        return Response.ok(collaborator).status(Response.Status.OK.getStatusCode()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        List<Collaborator> all = collaboratorService.findAll();
        return Response.ok(all).status(Response.Status.OK.getStatusCode()).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@Valid Collaborator collaborator) {
        collaborator = collaboratorService.update(collaborator);
        return Response.ok(collaborator).build();
    }

    @DELETE
    @Path("{collaboratorCode}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("collaboratorCode") Integer collaboratorCode) {
        Collaborator deleted = collaboratorService.delete(collaboratorCode);
        return Response.ok(deleted).build();
    }
}
