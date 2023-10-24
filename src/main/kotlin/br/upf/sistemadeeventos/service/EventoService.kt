package br.upf.sistemadeeventos.service

import br.upf.sistemadeeventos.model.Evento
import br.upf.sistemadeeventos.model.StatusEvento
import br.upf.sistemadeeventos.repository.EventoRepository
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class EventoService(val repository: EventoRepository) {

    fun listar(): List<Evento> {
        return repository.findAll()
    }

    fun buscaPorId(id: Long): Evento {
        return repository.findAll().first { it.id == id }
    }

    fun cadastra(evento: Evento) {
        repository.cadastrar(evento)
    }

}