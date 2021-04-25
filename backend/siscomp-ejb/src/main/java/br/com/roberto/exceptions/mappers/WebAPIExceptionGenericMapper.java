package br.com.roberto.exceptions.mappers;

import br.com.roberto.exceptions.NegocioException;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.logging.Logger;

@Provider
@Priority(Priorities.AUTHORIZATION)
public class WebAPIExceptionGenericMapper implements ExceptionMapper<WebApplicationException> {

    private Logger logger = Logger.getLogger(NegocioException.class.getName());

    @Override
    public Response toResponse(WebApplicationException ex) {
        MensagemExcecao mensagemExcecao = new MensagemExcecao(ex.getResponse().getStatus(),"Erro Genérico "+ ex.getMessage());
        logger.warning(mensagemExcecao.getMensagem());
        return Response.status(ex.getResponse().getStatus())
                .entity(mensagemExcecao)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
