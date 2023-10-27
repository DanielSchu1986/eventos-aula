package br.upf.sistemadeeventos.service

import br.upf.sistemadeeventos.converters.EventoConverter
import br.upf.sistemadeeventos.dtos.EventoRequestDTO
import br.upf.sistemadeeventos.dtos.EventoResponseDTO
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
        val evento = repository.findAll().first { it.id == id }
        return converter.toEventoResponseDTO(evento)
    }

    fun cadastra(dto: EventoRequestDTO) {
        repository.cadastrar(
            converter.toEvento(dto))
    }

    fun update(id: Long, evento: EventoRequestDTO) {
        repository.update(id, evento)
    }

    fun remove(id: Long) {
        repository.remove(id)
    }

}