package br.com.roberto.service.impl;

import br.com.roberto.entity.Contato;
import br.com.roberto.entity.Operadora;
import br.com.roberto.exceptions.NegocioException;
import br.com.roberto.repository.ContatoRepository;
import br.com.roberto.repository.OperadoraRepository;
import br.com.roberto.service.PopulaDadosService;
import oracle.jdbc.pool.OracleDataSource;

import javax.ejb.*;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

@Local
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@Dependent
public class PopulaDadosServiceImpl  implements PopulaDadosService, Serializable {

    @Inject
    private ContatoRepository contatoRepository;

    @Inject
    private OperadoraRepository operadoraRepository;

    public PopulaDadosServiceImpl() { }

    @Override
    public void popularDados() {
        removeOperadorasPreExistentes();
        removeContatosPreExistentes();
        insereOperadoras();
        insereContatos();
    }

    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    private void insereContatos() {

        Operadora operadoraOi =  operadoraRepository.findById(14L);
        Contato contato = new Contato("Carlos Roberto Medeiros","(61)99999-9999",
                GregorianCalendar.getInstance(), operadoraOi);

        Operadora operadoraVivo =  operadoraRepository.findById(15L);
        Contato contato1 = new Contato("Luciene Alves Medeiros","(61)88888-8888",
                GregorianCalendar.getInstance(), operadoraVivo);

        Contato contato2 = new Contato("Antonio Nunes Silva","(61)7777-7777",
                GregorianCalendar.getInstance(), operadoraVivo);

        Operadora operadoraTim =  operadoraRepository.findById(41L);
        Contato contato3 = new Contato("Lucia Maria de Lima","(61)6666-6666",
                GregorianCalendar.getInstance(), operadoraTim);

        Operadora operadoraEmbratel =  operadoraRepository.findById(28L);
        Contato contato4 = new Contato("Francisco de Assis Lima","(61)5555-5555",
                GregorianCalendar.getInstance(), operadoraEmbratel);

        try{
            contatoRepository.persist(contato);
            contatoRepository.persist(contato1);
            contatoRepository.persist(contato2);
            contatoRepository.persist(contato3);
            contatoRepository.persist(contato4);
        }catch (RuntimeException ex){
            throw new NegocioException("Erro =>"+ex.getMessage());

        }

    }

    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    private void insereOperadoras() {
        Operadora operadoraOi = new Operadora();
        operadoraOi.setCodigoOperadora(14L);
        operadoraOi.setNomeOperadora("Oi");
        operadoraOi.setTipoOperadora("C");

        Operadora operadoraVivo = new Operadora();
        operadoraVivo.setCodigoOperadora(15L);
        operadoraVivo.setNomeOperadora("Vivo");
        operadoraVivo.setTipoOperadora("C");

        Operadora operadoraEmbratel = new Operadora();
        operadoraEmbratel.setCodigoOperadora(28L);
        operadoraEmbratel.setNomeOperadora("Embratel");
        operadoraEmbratel.setTipoOperadora("F");

        Operadora operadoraTim = new Operadora();
        operadoraTim.setCodigoOperadora(41L);
        operadoraTim.setNomeOperadora("Tim");
        operadoraTim.setTipoOperadora("C");


        operadoraRepository.persist(operadoraOi);
        operadoraRepository.persist(operadoraVivo);
        operadoraRepository.persist(operadoraEmbratel);
        operadoraRepository.persist(operadoraTim);


    }

    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    private void removeOperadorasPreExistentes() {
        List<Operadora> operadoras = new ArrayList<>();
        operadoras = operadoraRepository.findAll();

        if(operadoras.size()>0){
            operadoras.forEach(operadora -> {
                operadoraRepository.remove(operadora);
            });
        }

    }

    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    private void removeContatosPreExistentes() {
        List<Contato> contatos = new ArrayList<>();
        contatos = contatoRepository.findAll();

        if(contatos.size()>0){
            contatos.forEach(contato -> {
                contatoRepository.remove(contato);
            });
        }
    }


}
