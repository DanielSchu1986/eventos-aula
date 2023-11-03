package br.upf.sistemadeeventos.service

import br.upf.sistemadeeventos.converters.EventoConverter
import br.upf.sistemadeeventos.dtos.EventoRequestDTO
import br.upf.sistemadeeventos.dtos.EventoResponseDTO
import br.upf.sistemadeeventos.exceptions.NotFoundException
import br.upf.sistemadeeventos.repository.EventoRepository
import org.springframework.stereotype.Service

@Service
class EventoService(val repository: EventoRepository,
    val converter: EventoConverter) {

    fun listar(): List<EventoResponseDTO> {
        return repository.findAll()
            .map { converter.toEventoResponseDTO(it) }
    }

    fun buscaPorId(id: Long): EventoResponseDTO {
        val evento = repository.findById(id)
            .orElseThrow { NotFoundException("Evento não encontrado!") }
        return converter.toEventoResponseDTO(evento)
    }

    fun cadastra(dto: EventoRequestDTO): EventoResponseDTO {
        val eventoAdicionado = repository.save(converter.toEvento(dto))
        return converter.toEventoResponseDTO(eventoAdicionado)
    }

    fun update(id: Long, evento: EventoRequestDTO): EventoResponseDTO {
        val eventoAntigo = repository.findById(id)
            .orElseThrow { NotFoundException("Evento não encontrado!") }
        val eventoAdicionado = repository.save(
            eventoAntigo.copy(
                nome = evento.nome,
                data = evento.data,
                descricao = evento.descricao,
                status = evento.status
        ))
        return converter.toEventoResponseDTO(eventoAdicionado)
    }

    fun remove(id: Long) {
        repository.deleteById(id)
    }

}