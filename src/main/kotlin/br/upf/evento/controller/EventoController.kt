package br.upf.evento.controller

import br.upf.evento.dtos.EventoDTO
import br.upf.evento.dtos.EventoResponseDTO
import br.upf.evento.model.Evento
import br.upf.evento.service.EventoService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/eventos")
class EventoController(private val service: EventoService) {

    @GetMapping
    fun listar(): List<EventoResponseDTO> {
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long) : EventoResponseDTO {
        return service.buscarPorId(id)
    }

    @PostMapping
    fun cadastrar(@RequestBody @Valid evento: EventoDTO) {
        service.cadastrar(evento)
    }

}