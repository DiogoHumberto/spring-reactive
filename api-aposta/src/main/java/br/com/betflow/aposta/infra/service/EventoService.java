package br.com.betflow.aposta.infra.service;

import br.com.betflow.aposta.infra.controller.dto.EventoDto;
import br.com.betflow.aposta.infra.enuns.TipoEvento;
import br.com.betflow.aposta.infra.persistence.EventoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class EventoService {

    private final EventoRepository eventoRepository;

    public Flux<EventoDto> findAll(){
        return eventoRepository.findAll().map(EventoDto::toDto);
    }


    public Mono<EventoDto> findById(Long id) {
        return eventoRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                .map(EventoDto::toDto);
    }

    public Mono<EventoDto> save(EventoDto dto) {
        return eventoRepository.save(dto.toEntity())
                .map(EventoDto::toDto);
    }

    public Mono<Void> deleteById(Long id) {
        return eventoRepository.findById(id)
                .flatMap(eventoRepository::delete);
    }

    public Mono<EventoDto> alter(EventoDto dto) {
        return eventoRepository.findById(dto.id())
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                .flatMap(evento -> {
                    evento.setTipo(dto.tipo());
                    evento.setNome(dto.nome());
                    evento.setData(dto.data());
                    evento.setDescricao(dto.descricao());
                    return eventoRepository.save(evento);
                })
                .map(EventoDto::toDto);
    }

    public Flux<EventoDto> findByTipo(String tipo) {
        TipoEvento tipoEvento = TipoEvento.valueOf(tipo.toUpperCase());
        return eventoRepository.findByTipo(tipoEvento)
                .map(EventoDto::toDto);
    }
}
