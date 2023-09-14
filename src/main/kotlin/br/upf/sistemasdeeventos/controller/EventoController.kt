package br.upf.sistemasdeeventos.controller

import br.upf.sistemasdeeventos.model.Evento
import br.upf.sistemasdeeventos.model.StatusEvento
import br.upf.sistemasdeeventos.service.EventoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RestController
@RequestMapping("/eventos")
class EventoController(
    val service: EventoService
) {

    @GetMapping
    fun listar(): List<Evento> {
        return service.listar()
    }

}