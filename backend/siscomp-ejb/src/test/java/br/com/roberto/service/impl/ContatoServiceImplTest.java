package br.com.roberto.service.impl;

import br.com.roberto.dto.ContatoDto;
import br.com.roberto.entity.Contato;
import br.com.roberto.exceptions.NegocioException;
import br.com.roberto.repository.ContatoRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ContatoServiceImplTest{

    @Mock
    private List<Contato> contatosMocks;

    @Mock
    private List<ContatoDto> contatosDtoMocks;

    @Mock
    private ContatoRepository contatoRepository;

    private void carregaContatosMocks(){
        this.contatosMocks = new ArrayList<>();
        this.contatosMocks.add(new Contato(Long.valueOf(1),"06689401073","Antonio Nunes","2198745898"));
        this.contatosMocks.add(new Contato(Long.valueOf(2),"49900370066","Lucia Da Silva","6158741236"));
        this.contatosMocks.add(new Contato(Long.valueOf(3),"31619396033","Thiago Pereira","3194753678"));
    }

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        this.carregaContatosMocks();
        Mockito.when(contatoRepository.findAll()).thenReturn(contatosMocks);
        //Mockito.when(contatoService.somar(1,2)).thenReturn(3);
    }

    @Test
    public void getContatos() {
        //ContatoServiceImpl contatoService = new ContatoServiceImpl();
        List<Contato> contatoInterno = contatosMocks;
        assertEquals(contatoInterno.size(),3);
    }

    @Test(expected = NullPointerException.class)
    public void getContatosEmCasoDeErro() {
        contatoRepository = null;
        List<Contato> contatoInterno = contatoRepository.findAll();
        Mockito.when(contatoInterno==null)
                .thenThrow(new NegocioException("Não foi Possível retornar contatos"));
    }


}
