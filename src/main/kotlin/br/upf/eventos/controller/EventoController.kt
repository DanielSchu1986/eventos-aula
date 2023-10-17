package br.upf.eventos.controller

import br.upf.eventos.dtos.EventoDTO
import br.upf.eventos.model.Evento
import br.upf.eventos.service.EventoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/eventos")
class EventoController(val service: EventoService) {

    @GetMapping
    fun listar(): List<Evento> {
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): Evento {
        return service.buscarPorId(id)
    }

    @PostMapping
    fun cadastrar(@RequestBody evento: EventoDTO) {
        service.cadastrar(evento)
    }

}