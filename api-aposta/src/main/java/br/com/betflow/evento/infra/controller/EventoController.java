package br.com.betflow.evento.infra.controller;

import br.com.betflow.evento.infra.controller.dto.EventoDto;
import br.com.betflow.evento.infra.service.EventoService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

import java.time.Duration;

@RestController
@RequestMapping("api/evento")
public class EventoController {

    private final EventoService eventoService;
    private final Sinks.Many<EventoDto> eventoSink;

    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
        // sincroniza varios events para todos multicast: para todos clientes
        // - onBackpressureBuffer: equaliza potencial do fluxo cliente/server
        this.eventoSink = Sinks.many().multicast().onBackpressureBuffer();
    }

    @GetMapping
    public Flux<EventoDto> findAll(){
        return eventoService.findAll();
    }

    @GetMapping(value = "/categoria/{tipo}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<EventoDto> findByTipo(@PathVariable String tipo){
        return  Flux.merge(eventoService.findByTipo(tipo), eventoSink.asFlux())
                .delayElements(Duration.ofSeconds(4));


    }

    @GetMapping("/{id}")
    public Mono<EventoDto> findById(@PathVariable Long id){
        return eventoService.findById(id);
    }

    @PostMapping
    public Mono<EventoDto> save(@RequestBody EventoDto dto){
        return eventoService.save(dto)
                .doOnSuccess(eventoSink::tryEmitNext);
    }

    @PutMapping
    public Mono<EventoDto> alter(@RequestBody EventoDto dto){
        return eventoService.alter(dto);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteById(@PathVariable Long id){
        return eventoService.deleteById(id);
    }

}
