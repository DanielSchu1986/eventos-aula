package br.upf.eventos.service

import br.upf.eventos.model.Evento
import br.upf.eventos.model.StatusEvento
import br.upf.eventos.repository.EventoRepository
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class EventoService(private val repository: EventoRepository) {

    fun listar(): List<Evento> {
        return repository.findAll()
    }

    fun buscarPorId(id: Long): Evento {
        return repository.findAll().first { it.id == id }
    }

}