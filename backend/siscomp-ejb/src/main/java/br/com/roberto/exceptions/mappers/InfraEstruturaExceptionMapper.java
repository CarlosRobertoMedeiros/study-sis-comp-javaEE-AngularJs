package br.com.roberto.exceptions.mappers;

import br.com.roberto.exceptions.InfraEstruturaException;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.logging.Logger;

@Provider
@Priority(Priorities.AUTHORIZATION)
public class InfraEstruturaExceptionMapper implements ExceptionMapper<InfraEstruturaException> {

    private Logger logger = Logger.getLogger(InfraEstruturaException.class.getName());

    @Override
    public Response toResponse(InfraEstruturaException e) {

        MensagemExcecao mensagemExcecao = new MensagemExcecao(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),e.getMessage());
        logger.severe(mensagemExcecao.getMensagem());
        return Response
                .status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(mensagemExcecao)
                .build();
    }

}
