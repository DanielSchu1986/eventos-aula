package br.upf.sistemasdeeventos.service

import br.upf.sistemasdeeventos.model.Evento
import br.upf.sistemasdeeventos.model.StatusEvento
import br.upf.sistemasdeeventos.repository.EventoRepository
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class EventoService(
    val repository: EventoRepository
) {

    fun listar(): List<Evento> {
        return repository.findAll()
    }

}