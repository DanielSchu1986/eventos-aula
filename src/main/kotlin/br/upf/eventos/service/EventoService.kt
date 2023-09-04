package br.upf.eventos.service

import br.upf.eventos.EventoRepository
import br.upf.eventos.model.Evento
import org.springframework.stereotype.Service

@Service
class EventoService(private val repository: EventoRepository) {

    fun listar(): List<Evento> {
        return repository.findAll()
    }
}

