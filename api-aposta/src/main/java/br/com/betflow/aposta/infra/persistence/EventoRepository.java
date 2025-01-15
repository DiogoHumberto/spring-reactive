package br.com.betflow.aposta.infra.persistence;

import br.com.betflow.aposta.infra.enuns.TipoEvento;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface EventoRepository extends ReactiveCrudRepository<EventoEntity, Long> {

    Flux<EventoEntity> findByTipo(TipoEvento tipoEvento);
}
