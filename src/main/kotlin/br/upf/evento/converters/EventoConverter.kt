package br.upf.evento.converters

import br.upf.evento.dtos.EventoDTO
import br.upf.evento.dtos.EventoResponseDTO
import br.upf.evento.model.Evento
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class EventoConverter {

    fun toEvento(dto: EventoDTO): Evento {
        return Evento(
            nome = dto.nome,
            data = dto.data,
            dataFimInsc = LocalDateTime.now(),
            dataInicioInsc = LocalDateTime.now(),
            descricao = dto.descricao,
            status = dto.status
        )
    }

    fun toEventoResponseDTO(evento: Evento): EventoResponseDTO {
        return EventoResponseDTO(
            id = evento.id,
            nome = evento.nome,
            data = evento.data,
            dataInicioInsc = evento.dataInicioInsc,
            dataFimInsc = evento.dataFimInsc,
            descricao = evento.descricao,
            status = evento.status
        )
    }

}
