package br.upf.eventos.converters

import br.upf.eventos.dtos.EventoDTO
import br.upf.eventos.dtos.EventoResponseDTO
import br.upf.eventos.model.Evento
import org.springframework.stereotype.Component

@Component
class EventoConverter {

    fun toEvento(dto: EventoDTO): Evento {
        return Evento(
            nome = dto.nome!!,
            data = dto.data!!,
            dataInicioInsc = dto.dataInicioInsc,
            dataFimInsc = dto.dataFimInsc,
            descricao = dto.descricao,
            status = dto.status
        )
    }

    fun toEventoResponseDTO(evento: Evento): EventoResponseDTO {
        return EventoResponseDTO(
            nome = evento.nome,
            data = evento.data,
            dataInicioInsc = evento.dataInicioInsc,
            dataFimInsc = evento.dataFimInsc,
            descricao = evento.descricao,
            statusEvento = evento.status,
            inscritos = evento.inscritos
        )
    }

}