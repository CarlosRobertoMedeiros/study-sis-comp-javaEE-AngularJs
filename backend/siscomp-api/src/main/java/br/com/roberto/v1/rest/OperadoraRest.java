package br.com.roberto.v1.rest;

import br.com.roberto.dto.ContatosDto;
import br.com.roberto.dto.OperadorasDto;
import br.com.roberto.service.OperadoraService;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("v1/operadoras")
@Produces(MediaType.APPLICATION_JSON+";charset=utf-8")
public class OperadoraRest {

    @EJB
    private OperadoraService operadoraService;

    @GET
    public Response getOperadoras(){
        OperadorasDto operadorasResponse =  operadoraService.getOperadoras();
        return Response.ok(operadorasResponse).build();
    }

}
