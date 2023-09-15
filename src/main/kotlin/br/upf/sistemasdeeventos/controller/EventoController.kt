package br.upf.sistemasdeeventos.controller

import br.upf.sistemasdeeventos.dtos.EventoDTO
import br.upf.sistemasdeeventos.dtos.EventoResponseDTO
import br.upf.sistemasdeeventos.service.EventoService
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
class EventoController(
    val service: EventoService
) {

    @GetMapping
    fun listar(): List<EventoResponseDTO> {
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): EventoResponseDTO {
        return service.buscarPorId(id)
    }

    @PostMapping
    fun cadastrar (@RequestBody @Valid dto: EventoDTO) {
        service.cadastrar(dto)
    }

    @PutMapping("/{id}")
    fun atualizar(@PathVariable id: Long, @RequestBody @Valid dto: EventoDTO) {
        service.atualizar(id, dto)
    }

}