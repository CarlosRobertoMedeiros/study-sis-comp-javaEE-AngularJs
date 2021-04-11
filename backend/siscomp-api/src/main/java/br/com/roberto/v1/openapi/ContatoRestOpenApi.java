package br.com.roberto.v1.openapi;

import br.com.roberto.v1.model.ContatoModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.core.Response;

@Api("Contato")
public interface ContatoRestOpenApi {

    @ApiOperation(value = "Consultar por CPF ou CNPJ", notes = "Operação responsável em consultar um cliente por CPF ou CNPJ.",
            response = ContatoModel.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso", response = ContatoModel.class),
            @ApiResponse(code = 400, message = "Requisição inválida."),
            @ApiResponse(code = 401, message = "Não Autorizado."),
            @ApiResponse(code = 403, message = "Sem prefil para executar a operação"),
            @ApiResponse(code = 412, message = "Erro Negócio"),
            @ApiResponse(code = 500, message = "Internal Server Error.")})
    Response getContatos();

}
