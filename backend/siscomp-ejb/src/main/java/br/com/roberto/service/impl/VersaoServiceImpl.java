package br.com.roberto.service.impl;


import br.com.roberto.service.VersaoService;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;

@Local
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class VersaoServiceImpl implements VersaoService {

    @Inject
    @Override
    public String getVersaoAtual() {
        //todo: Impelementar para trazer assim
        /*
        * Backend{
        *   Siscomp     = Versão: 0.0.0.1
        *   Siscomp-ejb = Versão: 0.0.0.1
        *   Siscomp-api = Versão: 0.0.0.1
        *   Siscomp-ear = Versão: 0.0.0.1
        * }
        * FrontEnd{
        *   Siscomp-web = Versão: 0.0.0.1
        * }
        *
        */
        return "0.0.0.1";
    }
}
