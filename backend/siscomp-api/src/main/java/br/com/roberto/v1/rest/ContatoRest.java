package br.com.roberto.v1.rest;

import br.com.roberto.dto.ContatoDto;
import br.com.roberto.dto.ContatosPaginadosDto;
import br.com.roberto.exceptions.InfraEstruturaException;
import br.com.roberto.exceptions.NegocioException;
import br.com.roberto.service.ContatoService;
import br.com.roberto.v1.openapi.ContatoRestOpenApi;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
     * @return
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
            return Response.status(NegocioException.CODIGO).build();
        }catch (InfraEstruturaException infra){
            logger.severe(infra.getMessage());
            return Response.status(InfraEstruturaException.CODIGO).build();
        }
    }

}
