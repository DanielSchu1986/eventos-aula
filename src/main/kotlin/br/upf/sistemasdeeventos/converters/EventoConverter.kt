package br.upf.sistemasdeeventos.converters

import br.upf.sistemasdeeventos.dtos.EventoDTO
import br.upf.sistemasdeeventos.dtos.EventoResponseDTO
import br.upf.sistemasdeeventos.model.Evento
import org.springframework.stereotype.Component

@Component
class EventoConverter {

    fun toEvento(dto: EventoDTO): Evento {
        return Evento(
            nome = dto.nome,
            data = dto.data,
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
            dataInicioInst = evento.dataInicioInsc,
            dataFimInsc = evento.dataFimInsc,
            descricao = evento.descricao,
            status = evento.status,
            inscritos = evento.inscritos
        )
    }

}