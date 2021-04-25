package br.com.roberto.exceptions.mappers;

import br.com.roberto.exceptions.NegocioException;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.logging.Logger;

@Provider
@Priority(Priorities.AUTHORIZATION)
public class NegocioExceptionMapper implements ExceptionMapper<NegocioException> {

    private Logger logger = Logger.getLogger(NegocioException.class.getName());

    @Override
    public Response toResponse(NegocioException e) {

        MensagemExcecao mensagemExcecao = new MensagemExcecao(Response.Status.PRECONDITION_FAILED.getStatusCode(),e.getMessage());
        logger.warning(mensagemExcecao.getMensagem());
        return Response
                .status(Response.Status.PRECONDITION_FAILED)
                .entity(mensagemExcecao)
                .build();
    }

}
