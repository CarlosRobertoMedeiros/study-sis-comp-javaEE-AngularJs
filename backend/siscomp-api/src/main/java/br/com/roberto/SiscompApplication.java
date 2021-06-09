package br.com.roberto;

import io.swagger.jaxrs.config.BeanConfig;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api")
public class SiscompApplication extends Application {

    private static final String BASE_PATH = "/siscomp-api/api";

    public SiscompApplication() {
        BeanConfig conf = new BeanConfig();
        conf.setTitle("SisComp - Api");
        conf.setDescription("SisComp - Sistema Completo");
        conf.setVersion("1.0.0");
        conf.setBasePath(BASE_PATH);
        conf.setResourcePackage("br.com.roberto.v1.rest");

        conf.setScan(true);
        conf.setPrettyPrint(true);

    }
}
