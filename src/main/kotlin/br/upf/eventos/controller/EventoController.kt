package br.upf.eventos.controller

import br.upf.eventos.model.Evento
import br.upf.eventos.model.StatusEvento
import br.upf.eventos.service.EventoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RestController
@RequestMapping("/eventos")
class EventoController(val service: EventoService) {

    @GetMapping
    fun listar(): List<Evento> {
        return service.listar()
    }
}

