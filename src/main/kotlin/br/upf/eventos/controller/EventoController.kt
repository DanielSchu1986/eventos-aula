package br.upf.eventos.controller

import br.upf.eventos.dtos.EventoDTO
import br.upf.eventos.dtos.EventoResponseDTO
import br.upf.eventos.model.Evento
import br.upf.eventos.service.EventoService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/eventos")
class EventoController(val service: EventoService) {

    @GetMapping
    fun listar(): List<EventoResponseDTO> {
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): EventoResponseDTO {
        return service.buscarPorId(id)
    }

    @PostMapping
    fun cadastrar(@RequestBody @Valid evento: EventoDTO) {
        service.cadastrar(evento)
    }

    @PutMapping("/{id}")
    fun atualizar(@PathVariable id: Long, @RequestBody @Valid evento: EventoDTO){
        service.atualizar(id, evento)
    }

}