package br.com.roberto.servlet;

import br.com.roberto.entity.Contato;
import br.com.roberto.entity.Operadora;
import br.com.roberto.repository.ContatoRepository;
import br.com.roberto.repository.OperadoraRepository;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/populaDados")
public class PopulaDadosServlet extends HttpServlet {

    @Inject
    private ContatoRepository contatoRepository;

    @Inject
    private OperadoraRepository operadoraRepository;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        popularDados();
        super.doPost(req, resp);
    }

    public void popularDados(){
        removeOperadorasPreExistentes();
        removeContatosPreExistentes();
        insereOperadoras();
    }

    @Transactional
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

    @Transactional
    private void removeOperadorasPreExistentes() {
        List<Operadora> operadoras = new ArrayList<>();
        operadoras = operadoraRepository.findAll();

        if(operadoras.size()>0){
            operadoras.forEach(operadora -> {
                operadoraRepository.remove(operadora);
            });
        }

    }

    @Transactional
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
