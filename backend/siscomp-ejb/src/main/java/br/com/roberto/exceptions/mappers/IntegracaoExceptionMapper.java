package br.com.roberto.exceptions.mappers;

import br.com.roberto.exceptions.IntegracaoException;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.logging.Logger;

@Provider
@Priority(Priorities.AUTHORIZATION)
public class IntegracaoExceptionMapper implements ExceptionMapper<IntegracaoException> {

    private Logger logger = Logger.getLogger(IntegracaoException.class.getName());

    @Override
    public Response toResponse(IntegracaoException e) {

        MensagemExcecao mensagemExcecao = new MensagemExcecao(Response.Status.BAD_REQUEST.getStatusCode(),e.getMessage());
        logger.warning(mensagemExcecao.getMensagem());
        return Response
                .status(Response.Status.BAD_REQUEST)
                .entity(mensagemExcecao)
                .build();
    }

}
