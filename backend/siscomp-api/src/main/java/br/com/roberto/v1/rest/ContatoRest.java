package br.com.roberto.v1.rest;

import br.com.roberto.dto.ContatoDto;
import br.com.roberto.dto.ContatosDto;
import br.com.roberto.dto.ContatosPaginadosDto;
import br.com.roberto.service.ContatoService;
import br.com.roberto.v1.conversores.api.ContatoInputParaContatoDto;
import br.com.roberto.v1.model.input.ContatoInput;
import br.com.roberto.v1.openapi.ContatoRestOpenApi;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@ApplicationScoped
@Path("v1/contatos")
@Produces(MediaType.APPLICATION_JSON+";charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON+";charset=utf-8")
public class ContatoRest implements ContatoRestOpenApi {

    @EJB
    private ContatoService contatoService;

    /**
     * Consulta todos os contatos
     * Futuramente esse método vai cair em desuso devido a uma grande quantidade de dados
     * @return Lista de Contatos
     */
    @GET
    @Deprecated
    public Response getContatos(){
        ContatosDto  contatosResponse =  contatoService.getContatos();
        return Response.ok(contatosResponse).build();
    }

    /**
     * Consulta os dados do contato por id
     * @return o Contato
     */
    @GET
    @Path("/{id}")
    public Response getContatosById(@PathParam("id") Long id){
        ContatoDto  contatoResponse =  contatoService.getContatosById(id);
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

        ContatosPaginadosDto contatoResponse =  contatoService.getContatosPaginados(totalRegistrosPorPagina,paginaAtual);
        return Response.ok(contatoResponse).build();
    }

    /**
     * Insere um contato
     * @param contatoInput
     * @return Response
     */
    @POST
    public Response insereContato(ContatoInput contatoInput){
        ContatoDto contatoDtoRequest = ContatoInputParaContatoDto.toDtoObject(contatoInput);
        ContatoDto contatoResponse = contatoService.insereContato(contatoDtoRequest);
        return Response.created(getUriParaInsercao(contatoResponse)).entity(contatoResponse).build();
    }

    /**
     * Atualiza os dados de um contato existente
     * @param id
     * @param novoContato
     * @return
     */
    @PUT
    @Path("/{id}")
    public Response atualizaContato(@PathParam("id") Long id, ContatoInput novoContato){
        ContatoDto contatoDtoRequest = ContatoInputParaContatoDto.toDtoObject(novoContato);
        ContatoDto contatoResponse = contatoService.atualizaContato(id, contatoDtoRequest);
        return Response.ok(contatoResponse).build();
    }

    /**
     * Exclui um contato existente
     * @param id
     * @return
     */
    @DELETE
    @Path("/{id}")
    public Response excluiContato(@PathParam("id") Long id) {
        contatoService.excluiContatoById(id);
        return Response.ok().build();
    }

    /**
     * Método responsáel por trazer o location na inserção do dados no Header do response
     * @param contatoResponse
     * @return
     */
    private URI getUriParaInsercao(ContatoDto contatoResponse) {
        URI uri = URI.create("/v1/contatos/"+contatoResponse.getIdContato());
        return uri;
    }
}
