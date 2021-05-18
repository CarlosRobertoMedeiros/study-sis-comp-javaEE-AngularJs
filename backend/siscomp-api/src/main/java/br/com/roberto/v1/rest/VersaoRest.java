package br.com.roberto.v1.rest;

import br.com.roberto.service.VersaoService;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("v1/sisinfo")
@Produces(MediaType.APPLICATION_JSON+";charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON+";charset=utf-8")
public class VersaoRest {

    @EJB
    private VersaoService versaoService;


    /**
     * Responsável por retornar a versão do backend
     * @return Versão atual do meu backend
     */
    @GET
    @Deprecated
    public Response getVersaoAtual(){
        //TODO Implementar melhor a versão conforme a padronização do pom externo
        String dadosDaVersao =versaoService.getVersaoAtual();
        return Response.ok(dadosDaVersao).build();
    }
}
