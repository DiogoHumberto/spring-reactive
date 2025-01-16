package br.com.betflow.evento.infra.controller.dto;

import br.com.betflow.evento.infra.enuns.TipoEvento;
import br.com.betflow.evento.infra.persistence.EventoEntity;

import java.time.LocalDate;

public record EventoDto(Long id,
                        TipoEvento tipo,
                        String nome,
                        LocalDate data,
                        String descricao) {

    public static EventoDto toDto(EventoEntity evento) {
        return new EventoDto(evento.getId(), evento.getTipo(), evento.getNome(),
                evento.getData(), evento.getDescricao());
    }

    public EventoEntity toEntity() {
        EventoEntity evento = new EventoEntity();
//        evento.setId(this.id);
        evento.setNome(this.nome);
        evento.setTipo(this.tipo);
        evento.setData(this.data);
        evento.setDescricao(this.descricao);
        return  evento;
    }
}