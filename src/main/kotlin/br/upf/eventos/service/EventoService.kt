package br.upf.eventos.service

import br.upf.eventos.converters.EventoConverter
import br.upf.eventos.dtos.EventoDTO
import br.upf.eventos.model.Evento
import br.upf.eventos.repository.EventoRepository
import org.springframework.stereotype.Service

@Service
class EventoService(private val repository: EventoRepository,
    val converter: EventoConverter) {

    fun listar(): List<Evento> {
        return repository.findAll()
    }

    fun buscarPorId(id: Long): Evento {
        return repository.findAll().first { it.id == id }
    }

    fun cadastrar(dto: EventoDTO) {
        repository.cadastrar(converter.toEvento(dto))
    }

}