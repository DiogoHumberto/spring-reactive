package br.com.betflow.aposta.infra.persistence;

import br.com.betflow.aposta.infra.enuns.TipoEvento;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("eventos")
public class EventoEntity {

    @Id
    private Long id;

    @Column("tipo")
    private TipoEvento tipo;

    @Column("nome")
    private String nome;

    @Column("data")
    private LocalDate data;

    @Column("descricao")
    private String descricao;

}
