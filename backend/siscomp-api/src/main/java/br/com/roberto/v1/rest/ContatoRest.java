package br.com.roberto.v1.rest;

import br.com.roberto.dto.ContatoDto;
import br.com.roberto.dto.ContatosPaginadosDto;
import br.com.roberto.exceptions.InfraEstruturaException;
import br.com.roberto.exceptions.NegocioException;
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
public class ContatoRest implements ContatoRestOpenApi {

    private Logger logger = Logger.getLogger(ContatoRest.class.getName());

    @EJB
    private ContatoService contatoService;

    /**
     * Consulta todos os contatos
     * @return Lista de Contatos
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Deprecated
    public Response getContatos(){

        List<ContatoDto> contatosResponse = null;

        try {
            contatosResponse =  contatoService.getContatos();
            return Response.ok(contatosResponse).build();
        } catch (NegocioException ne) {
            logger.info(ne.getMessage());
            return Response.status(Response.Status.fromStatusCode(NegocioException.CODIGO)).build();
        }catch (InfraEstruturaException infra) {
            logger.severe(infra.getMessage());
            return Response.status(Response.Status.fromStatusCode(InfraEstruturaException.CODIGO)).build();
        }
    }

    /**
     * Consulta os dados do contato por id
     * @return o Contato
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response getContatosById(@PathParam("id") Long id){
        ContatoDto contatoResponse = null;

        try {
            contatoResponse =  contatoService.getContatosById(id);
            return Response.ok(contatoResponse).build();
        } catch (NegocioException ne) {
            logger.info(ne.getMessage());
            return Response.status(Response.Status.fromStatusCode(NegocioException.CODIGO)).build();
        }catch (InfraEstruturaException infra) {
            logger.severe(infra.getMessage());
            return Response.status(Response.Status.fromStatusCode(InfraEstruturaException.CODIGO)).build();
        }
    }

    /**
     * Lista os contatos respeitando a paginação
     * @param totalRegistrosPorPagina
     * @param paginaAtual
     * @return Response
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/contatos-paginados")
    public Response getContatosPaginados(@QueryParam("totalRegistrosPorPagina") int totalRegistrosPorPagina,
                                                 @QueryParam("paginaAtual") int paginaAtual){

        ContatosPaginadosDto contatoResponse = null;
        try {
            contatoResponse =  contatoService.getContatosPaginados(totalRegistrosPorPagina,paginaAtual);
            return Response.ok(contatoResponse).build();
        }catch (NegocioException ne){
            logger.info(ne.getMessage());
            return Response.status(NegocioException.CODIGO).build();
        }catch (InfraEstruturaException infra){
            logger.severe(infra.getMessage());
            return Response.status(InfraEstruturaException.CODIGO).build();
        }
    }

    /**
     * Insere um contato
     * @param contato
     * @return Response
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insereContato(ContatoModel contato){
        ContatoDto contatoResponse = null;

        try{
            contatoResponse = contatoService.insereContato(ContatoDTOConversor.converterContatoDto(contato));
            return Response.created(getUriParaInsercao(contatoResponse)).entity(contatoResponse).build();
        }catch(NegocioException ne){
            logger.info(ne.getMessage());
            return Response.status(ne.CODIGO).build();
        }catch(InfraEstruturaException ie){
            logger.severe(ie.getMessage());
            return Response.status(ie.CODIGO).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response atualizaContato(@PathParam("id") Long id, ContatoModel novoContato){
        ContatoDto contatoResponse = null;

        try{
            contatoResponse = contatoService.atualizaContato(id, ContatoDTOConversor.converterContatoDto(novoContato));
            return Response.ok(contatoResponse).build();
        }catch(NegocioException ne){
            logger.info(ne.getMessage());
            return Response.status(ne.CODIGO).build();
        }catch(InfraEstruturaException ie){
            logger.severe(ie.getMessage());
            return Response.status(ie.CODIGO).build();
        }
    }

    @Override
    @DELETE
    @Path("/{id}")
    public Response excluiContato(@PathParam("id") Long id) {
        try{
            contatoService.excluiContatoById(id);
            return Response.ok().build();
        }catch(NegocioException ne){
            logger.info(ne.getMessage());
            return Response.status(ne.CODIGO).build();
        }catch(InfraEstruturaException ie){
            logger.severe(ie.getMessage());
            return Response.status(ie.CODIGO).build();
        }
    }

    private URI getUriParaInsercao(ContatoDto contatoResponse) {
        URI uri = URI.create("/v1/contatos/"+contatoResponse.getIdContato());
        return uri;
    }
}
