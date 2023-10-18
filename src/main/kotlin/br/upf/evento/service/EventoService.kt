package br.upf.evento.service

import br.upf.evento.model.Evento
import br.upf.evento.repository.EventoRepository
import org.springframework.stereotype.Service

@Service
class EventoService(private val repository: EventoRepository) {

    fun listar(): List<Evento> {
        return repository.findAll()
    }

    fun buscarPorId(id: Long): Evento {
        return repository.findAll().first { it.id == id }
    }

    fun cadastrar(evento: Evento) {
        repository.cadastrar(evento)
    }

}