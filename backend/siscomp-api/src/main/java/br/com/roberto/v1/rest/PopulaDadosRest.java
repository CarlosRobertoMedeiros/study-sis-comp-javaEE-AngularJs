package br.com.roberto.v1.rest;

import br.com.roberto.service.PopulaDadosService;
import br.com.roberto.v1.openapi.PopulaDadosRestOpenApi;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RequestScoped
@Path("v1/popula-dados")
@Produces(MediaType.APPLICATION_JSON+";charset=utf-8")
public class PopulaDadosRest implements PopulaDadosRestOpenApi {

    @EJB
    private PopulaDadosService populaDadosService;


    @GET
    @Override
    public void popularDados(){
        populaDadosService.popularDados();
    }


}
