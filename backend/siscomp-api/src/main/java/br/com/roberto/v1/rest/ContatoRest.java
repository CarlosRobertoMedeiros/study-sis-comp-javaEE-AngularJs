package br.com.roberto.v1.rest;

import br.com.roberto.dto.ContatoDto;
import br.com.roberto.dto.ContatosPaginadosDto;
import br.com.roberto.service.ContatoService;
import br.com.roberto.v1.conversores.ContatoDTOConversor;
import br.com.roberto.v1.model.ContatoModel;
import br.com.roberto.v1.openapi.ContatoRestOpenApi;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped

@Path("v1/contatos")
@Produces(MediaType.APPLICATION_JSON+";charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON+";charset=utf-8")
public class ContatoRest implements ContatoRestOpenApi {

    private Logger logger = Logger.getLogger(ContatoRest.class.getName());

    @EJB
    private ContatoService contatoService;

    /**
     * Consulta todos os contatos
     * @return Lista de Contatos
     */
    @GET
    @Deprecated
    public Response getContatos(){
        List<ContatoDto> contatosResponse = null;
        contatosResponse =  contatoService.getContatos();
        return Response.ok(contatosResponse).build();
    }

    /**
     * Consulta os dados do contato por id
     * @return o Contato
     */
    @GET
    @Path("/{id}")
    public Response getContatosById(@PathParam("id") Long id){
        ContatoDto contatoResponse = null;
        contatoResponse =  contatoService.getContatosById(id);
        return Response.ok(contatoResponse).build();
   }

    /**
     * Lista os contatos respeitando a paginação
     * @param totalRegistrosPorPagina
     * @param paginaAtual
     * @return Response
     */
    @GET
    @Path("/contatos-paginados")
    public Response getContatosPaginados(@QueryParam("totalRegistrosPorPagina") int totalRegistrosPorPagina,
                                                 @QueryParam("paginaAtual") int paginaAtual){

        ContatosPaginadosDto contatoResponse = null;
        contatoResponse =  contatoService.getContatosPaginados(totalRegistrosPorPagina,paginaAtual);
        return Response.ok(contatoResponse).build();
    }

    /**
     * Insere um contato
     * @param contato
     * @return Response
     */
    @POST
    public Response insereContato(ContatoModel contato){
        ContatoDto contatoResponse = null;
        contatoResponse = contatoService.insereContato(ContatoDTOConversor.converterContatoDto(contato));
        return Response.created(getUriParaInsercao(contatoResponse)).entity(contatoResponse).build();

    }

    @PUT
    @Path("/{id}")
    public Response atualizaContato(@PathParam("id") Long id, ContatoModel novoContato){
        ContatoDto contatoResponse = null;
        contatoResponse = contatoService.atualizaContato(id, ContatoDTOConversor.converterContatoDto(novoContato));
        return Response.ok(contatoResponse).build();

    }

    @Override
    @DELETE
    @Path("/{id}")
    public Response excluiContato(@PathParam("id") Long id) {
        contatoService.excluiContatoById(id);
        return Response.ok().build();
    }

    private URI getUriParaInsercao(ContatoDto contatoResponse) {
        URI uri = URI.create("/v1/contatos/"+contatoResponse.getIdContato());
        return uri;
    }
}
