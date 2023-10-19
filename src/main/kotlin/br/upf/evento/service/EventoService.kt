package br.upf.evento.service

import br.upf.evento.converters.EventoConverter
import br.upf.evento.dtos.EventoDTO
import br.upf.evento.dtos.EventoResponseDTO
import br.upf.evento.model.Evento
import br.upf.evento.repository.EventoRepository
import org.springframework.stereotype.Service

@Service
class EventoService(private val repository: EventoRepository,
    val converter: EventoConverter) {

    fun listar(): List<EventoResponseDTO> {
        return repository.findAll()
            .map { converter.toEventoResponseDTO(it) }
    }

    fun buscarPorId(id: Long): EventoResponseDTO {
        val evento = repository.findAll().first { it.id == id }
        return converter.toEventoResponseDTO(evento)
    }

    fun cadastrar(dto: EventoDTO): EventoResponseDTO {
        val evento = repository.cadastrar(
            converter.toEvento(dto))
        return converter.toEventoResponseDTO(evento)
    }

    fun atualizar(id: Long, dto: EventoDTO): EventoResponseDTO {
        val evento = repository.findAll().first { it.id == id }
        return converter.toEventoResponseDTO(
            repository.update(evento, dto))
    }

    fun deletar(id: Long) {
        repository.deletar(id)
    }

}