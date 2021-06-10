package br.com.roberto.repository;

import br.com.roberto.entity.Contato;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;
import java.util.List;

@ApplicationScoped
public class ContatoRepository extends AbstractRepository<Contato, Long>{

    /**
     * Método Implementado exclusivamente para atender paginação utilizando o banco de dados Oracle 11g
     * @param totalRegistrosPorPagina
     * @param paginaAtual
     * @return List<Contato>
     */
    public List<Contato> listaTodosContatosPaginados(int totalRegistrosPorPagina, int paginaAtual){

        StringBuilder jpql = new StringBuilder();

        jpql.append(" SELECT 													 ");
        jpql.append(" 	X.NU_CONTATO,											 ");
        jpql.append(" 	X.DT_ULTIMA_ATUALIZACAO_CONTATO,                         ");
        jpql.append(" 	X.NO_NOME_CONTATO,                                       ");
        jpql.append(" 	X.NM_TELEFONE_CONTATO,                                   ");
        jpql.append(" 	X.CO_OPERADORA                                           ");
        jpql.append(" FROM                                                       ");
        jpql.append(" 	( SELECT                                                 ");
        jpql.append(" 		A.NU_CONTATO,                                        ");
        jpql.append(" 		A.DT_ULTIMA_ATUALIZACAO_CONTATO,                     ");
        jpql.append(" 		A.NO_NOME_CONTATO,                                   ");
        jpql.append(" 		A.NM_TELEFONE_CONTATO,                               ");
        jpql.append(" 		A.CO_OPERADORA,                                      ");
        jpql.append(" 		ROWNUM RNUM                                          ");
        jpql.append(" 	FROM                                                     ");
        jpql.append(" 	  	( SELECT                                             ");
        jpql.append(" 		  		NU_CONTATO,                                  ");
        jpql.append(" 		  		DT_ULTIMA_ATUALIZACAO_CONTATO,               ");
        jpql.append(" 		  		NO_NOME_CONTATO,                             ");
        jpql.append(" 		  		NM_TELEFONE_CONTATO,                         ");
        jpql.append(" 		  		CO_OPERADORA                                 ");
        jpql.append(" 	  		FROM                                             ");
        jpql.append(" 	  			SISCOMP.TB_CONTATOS ORDER BY NU_CONTATO ) A  ");
        jpql.append(" 	  WHERE ROWNUM <= :valorMaximoParaPaginacao              ");
        jpql.append(" 	)X                                                       ");
        jpql.append(" WHERE RNUM  >= :valorMinimoParaPaginacao                   ");

        int valorMaximoParaPaginacao = (paginaAtual * totalRegistrosPorPagina);
        int valorMinumoParaPaginacao = (valorMaximoParaPaginacao - totalRegistrosPorPagina)+1;


        Query query = em.createNativeQuery(String.valueOf(jpql), Contato.class);
        query
            .setParameter("valorMaximoParaPaginacao", valorMaximoParaPaginacao)
            .setParameter("valorMinimoParaPaginacao", valorMinumoParaPaginacao);

        List<Contato> contatos = query.getResultList();
        return contatos;
    }

}
