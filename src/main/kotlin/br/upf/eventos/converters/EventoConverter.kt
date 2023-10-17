package br.upf.eventos.converters

import br.upf.eventos.dtos.EventoDTO
import br.upf.eventos.dtos.EventoResponseDTO
import br.upf.eventos.model.Evento
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class EventoConverter {

    fun toEvento(dto: EventoDTO) : Evento {
        return Evento(
            nome = dto.nome,
            data = dto.data,
            dataInicioInsc = LocalDateTime.now(),
            dataFimInsc = LocalDateTime.now(),
            descricao = dto.descricao,
            status = dto.status
        )
    }

    fun toEventoResponseDTO(evento: Evento): EventoResponseDTO {
        return EventoResponseDTO(
            id = evento.id!!,
            nome = evento.nome,
            data = evento.data,
            descricao = evento.descricao,
            status = evento.status,
            inscritos = evento.inscritos
        )
    }

}