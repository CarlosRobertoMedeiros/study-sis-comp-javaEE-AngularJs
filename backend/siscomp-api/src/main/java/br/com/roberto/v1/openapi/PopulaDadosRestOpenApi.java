package br.com.roberto.v1.openapi;

import br.com.roberto.v1.model.input.OperadoraInput;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.core.Response;

@Api("Popula-Dados")
public interface PopulaDadosRestOpenApi {

    @ApiOperation(value = "Popula os Dados", notes = "Responsável por inserir os dados iniciais de Operadoras e contatos na base de dados.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso"),
            @ApiResponse(code = 400, message = "Requisição inválida."),
            @ApiResponse(code = 401, message = "Não Autorizado."),
            @ApiResponse(code = 403, message = "Sem prefil para executar a operação"),
            @ApiResponse(code = 412, message = "Erro Negócio"),
            @ApiResponse(code = 500, message = "Internal Server Error.")})
    void popularDados();

}
