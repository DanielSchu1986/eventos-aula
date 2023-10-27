package br.upf.sistemadeeventos.controller

import br.upf.sistemadeeventos.dtos.EventoRequestDTO
import br.upf.sistemadeeventos.dtos.EventoResponseDTO
import br.upf.sistemadeeventos.model.Evento
import br.upf.sistemadeeventos.service.EventoService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
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
    fun buscarPorId(@PathVariable id: Long): EventoResponseDTO {
        return service.buscaPorId(id)
    }

    @PostMapping
    fun cadastrar(@RequestBody @Valid evento: EventoRequestDTO) {
        service.cadastra(evento)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody @Valid evento: EventoRequestDTO) {
        service.update(id, evento)
    }

    @DeleteMapping("/{id}")
    fun deletar(@PathVariable id: Long) {
        service.remove(id)
    }
}