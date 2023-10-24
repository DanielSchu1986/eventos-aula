package br.upf.sistemadeeventos.controller

import br.upf.sistemadeeventos.model.Evento
import br.upf.sistemadeeventos.service.EventoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RestController
@RequestMapping("/eventos")
class EventoController(private val service: EventoService) {

    @GetMapping
    fun listar(): List<Evento> {
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): Evento {
        return service.buscaPorId(id)
    }

    @PostMapping
    fun cadastrar(@RequestBody evento: Evento) {
        service.cadastra(evento)
    }
}