package br.com.roberto.entity;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "TB_OPERADORAS", schema = "SISCOMP")
public class Operadora {

    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_OPERADORAS")
    //@SequenceGenerator(name = "GEN_OPERADORAS", sequenceName = "SEQ_OPERADORA", schema = "SISCOMP", allocationSize = 1)
    //@Column(name = "NU_OPERADORA")
    //private Long idOperadora;

    @EqualsAndHashCode.Include
    @Id
    @Column(name = "CO_OPERADORA")
    private Long codigoOperadora;

    @Column(name = "NM_OPERADORA", length = 50, nullable = false)
    private String nomeOperadora;

    @Column(name = "TP_OPERADORA", length = 1, nullable = false)
    private String tipoOperadora;

}
