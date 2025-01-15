package br.com.betflow.aposta.infra.controller;

import br.com.betflow.aposta.infra.persistence.EventoEntity;
import br.com.betflow.aposta.infra.persistence.EventoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("api/evento")
@RequiredArgsConstructor
public class EventoController {

    private final EventoRepository eventoRepository;


    @GetMapping
    public Flux<EventoEntity> findAll(){
        return eventoRepository.findAll();
    }
}
