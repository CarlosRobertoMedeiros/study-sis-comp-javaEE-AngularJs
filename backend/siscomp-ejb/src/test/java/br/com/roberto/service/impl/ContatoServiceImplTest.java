package br.com.roberto.service.impl;

import br.com.roberto.dto.ContatoDto;
import br.com.roberto.entity.Contato;
import br.com.roberto.repository.ContatoRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class ContatoServiceImplTest{

    @Mock
    private List<Contato> contatosMocks = null;

    @Mock
    private List<ContatoDto> contatosDtoMocks = null;

    @Mock
    private ContatoRepository contatoRepository = null;

    private void carregaContatosMocks(){
        contatosMocks.add(new Contato(Long.valueOf(1),"06689401073","Antonio Nunes","2198745898"));
        contatosMocks.add(new Contato(Long.valueOf(2),"49900370066","Lucia Da Silva","6158741236"));
        contatosMocks.add(new Contato(Long.valueOf(3),"31619396033","Thiago Pereira","3194753678"));
    }

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        Mockito.when(contatoRepository.findAll()).thenReturn(contatosMocks);
    }


    @Test
    public void getContatos() {
        List<Contato> contatoInterno = contatoRepository.findAll();

        contatoInterno.forEach(contato -> {
            contatosDtoMocks.add(new ContatoDto(contato.getId(),contato.getCpf(),contato.getNome(),contato.getTelefone()));
        });

        //assertEquals(contatoInterno.size(),3);
    }

//    public ContatosPaginadosDto getContatosPaginados(int totalRegistrosPorPagina, int paginaAtual) {
//        return null;
//    }
//
//    public ContatoDto getContatosById(Long id) {
//        return null;
//    }
//
//    public ContatoDto insereContato(ContatoDto contatoDto) {
//        return null;
//    }
//
//    public ContatoDto atualizaContato(Long id, ContatoDto converterContatoDto) {
//        return null;
//    }
//
//    public void excluiContatoById(Long id) {
//
//    }
}
