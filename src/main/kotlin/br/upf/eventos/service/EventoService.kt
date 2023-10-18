package br.upf.eventos.service

import br.upf.eventos.converters.EventoConverter
import br.upf.eventos.dtos.EventoDTO
import br.upf.eventos.dtos.EventoResponseDTO
import br.upf.eventos.exceptions.NotFoundException
import br.upf.eventos.model.Evento
import br.upf.eventos.repository.EventoRepository
import org.springframework.stereotype.Service

private const val ERROR_MESSAGE = "Evento não encontrado!!!"

@Service
class EventoService(private val repository: EventoRepository,
    val converter: EventoConverter) {

    fun listar(): List<EventoResponseDTO> {
        return repository.findAll()
            .map(converter::toEventoResponseDTO)
    }

    fun buscarPorId(id: Long): EventoResponseDTO {
        val evento = repository.findAll().firstOrNull { it.id == id }
            ?: throw NotFoundException(ERROR_MESSAGE)
        return converter.toEventoResponseDTO(evento)
    }

    fun cadastrar(dto: EventoDTO): EventoResponseDTO {
        return converter.toEventoResponseDTO(
            repository.cadastrar(converter.toEvento(dto)))
    }

    fun atualizar(id: Long, dto: EventoDTO) : EventoResponseDTO {
        val evento = repository.findAll().firstOrNull { it.id == id }
            ?: throw NotFoundException(ERROR_MESSAGE)
        return converter.toEventoResponseDTO(
            repository.update(evento, converter.toEvento(dto))
        )
    }

    fun deletar(id: Long) {
        val evento = repository.findAll().first { it.id == id }
        repository.deletar(evento)
    }

}