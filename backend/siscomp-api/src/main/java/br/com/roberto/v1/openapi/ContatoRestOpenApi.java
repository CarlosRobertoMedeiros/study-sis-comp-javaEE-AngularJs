package br.com.roberto.v1.openapi;

import br.com.roberto.v1.model.input.ContatoInput;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Api("Contato")
public interface ContatoRestOpenApi {

    @ApiOperation(value = "Consultar Todos os Contatos", notes = "Operação responsável em retornar todos os contatos da base de dados.",
            response = ContatoInput.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso", response = ContatoInput.class),
            @ApiResponse(code = 400, message = "Requisição inválida."),
            @ApiResponse(code = 401, message = "Não Autorizado."),
            @ApiResponse(code = 403, message = "Sem prefil para executar a operação"),
            @ApiResponse(code = 412, message = "Erro Negócio"),
            @ApiResponse(code = 500, message = "Internal Server Error.")})
    Response getContatos();

    @ApiOperation(value = "Consultar Contato por Id", notes = "Operação responsável em retornar um contatos por id da base de dados.",
            response = ContatoInput.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso", response = ContatoInput.class),
            @ApiResponse(code = 400, message = "Requisição inválida."),
            @ApiResponse(code = 401, message = "Não Autorizado."),
            @ApiResponse(code = 403, message = "Sem prefil para executar a operação"),
            @ApiResponse(code = 412, message = "Erro Negócio"),
            @ApiResponse(code = 500, message = "Internal Server Error.")})
    Response getContatosById(Long id);

    @ApiOperation(value = "Consultar Todos os Contatos Paginados", notes = "Operação responsável por consultar todos os contatos, respeitando a paginação.",
            response = ContatoInput.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso", response = ContatoInput.class),
            @ApiResponse(code = 400, message = "Requisição inválida."),
            @ApiResponse(code = 401, message = "Não Autorizado."),
            @ApiResponse(code = 403, message = "Sem prefil para executar a operação"),
            @ApiResponse(code = 412, message = "Erro Negócio"),
            @ApiResponse(code = 500, message = "Internal Server Error.")})
    Response getContatosPaginados(@QueryParam("totalRegistrosPorPagina") int totalRegistrosPorPagina,
                                  @QueryParam("paginaAtual") int paginaAtual);
    @ApiOperation(value = "Inclusão de Dados do Contato", notes = "Operação responsável em incluir os dados do Contato.",
            response = ContatoInput.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Sucesso", response = ContatoInput.class),
            @ApiResponse(code = 400, message = "Requisição inválida."),
            @ApiResponse(code = 401, message = "Não Autorizado."),
            @ApiResponse(code = 403, message = "Sem prefil para executar a operação"),
            @ApiResponse(code = 412, message = "Erro Negócio"),
            @ApiResponse(code = 500, message = "Internal Server Error.") })
    Response insereContato(ContatoInput contato);

    @ApiOperation(value = "Exclusão de Dados do Contato", notes = "Operação responsável por excluir os dados informando o Contato.",
            response = ContatoInput.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso", response = ContatoInput.class),
            @ApiResponse(code = 400, message = "Requisição inválida."),
            @ApiResponse(code = 401, message = "Não Autorizado."),
            @ApiResponse(code = 403, message = "Sem prefil para executar a operação"),
            @ApiResponse(code = 412, message = "Erro Negócio"),
            @ApiResponse(code = 500, message = "Internal Server Error.") })
    Response excluiContato(ContatoInput contato);

    @ApiOperation(value = "Exclusão de Dados do Contato por Id", notes = "Operação responsável por excluir os dados informando o id do Contato.",
            response = ContatoInput.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso", response = ContatoInput.class),
            @ApiResponse(code = 400, message = "Requisição inválida."),
            @ApiResponse(code = 401, message = "Não Autorizado."),
            @ApiResponse(code = 403, message = "Sem prefil para executar a operação"),
            @ApiResponse(code = 412, message = "Erro Negócio"),
            @ApiResponse(code = 500, message = "Internal Server Error.") })
    Response excluiContatoById(Long id);

    @ApiOperation(value = "Alteração dos dados do Contato", notes = "Operação responsável por alterar dados do Contato.",
            response = ContatoInput.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso", response = ContatoInput.class),
            @ApiResponse(code = 400, message = "Requisição inválida."),
            @ApiResponse(code = 401, message = "Não Autorizado."),
            @ApiResponse(code = 403, message = "Sem prefil para executar a operação"),
            @ApiResponse(code = 412, message = "Erro Negócio"),
            @ApiResponse(code = 500, message = "Internal Server Error.") })
    Response atualizaContato(ContatoInput novoContato);
}
