package br.upf.sistemadeeventos.converters

import br.upf.sistemadeeventos.dtos.EventoRequestDTO
import br.upf.sistemadeeventos.dtos.EventoResponseDTO
import br.upf.sistemadeeventos.model.Evento
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class EventoConverter {

    fun toEventoResponseDTO(evento: Evento): EventoResponseDTO {
        return EventoResponseDTO(
            nome = evento.nome,
            data = evento.data,
            descricao = evento.descricao,
            status = evento.status,
            dataInicioInsc = evento.dataInicioInsc,
            dataFimInsc = evento.dataFimInsc
        )
    }

    fun toEvento(dto: EventoRequestDTO): Evento {
        return Evento(
            nome = dto.nome,
            data = dto.data,
            descricao = dto.descricao,
            status = dto.status,
            dataInicioInsc = LocalDateTime.now(),
            dataFimInsc = LocalDateTime.now()
        )
    }

}