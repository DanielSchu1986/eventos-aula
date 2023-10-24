package br.upf.eventos.controller

import br.upf.eventos.dtos.EventoDTO
import br.upf.eventos.dtos.EventoResponseDTO
import br.upf.eventos.model.Evento
import br.upf.eventos.service.EventoService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

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
    fun cadastrar(@RequestBody @Valid evento: EventoDTO,
                  uriBuilder: UriComponentsBuilder): ResponseEntity<EventoResponseDTO> {
        val eventoResponse = service.cadastrar(evento)
        val uri = uriBuilder.path("/eventos/${eventoResponse.id}").build().toUri()
        return  ResponseEntity.created(uri).body(eventoResponse)
    }

    @PutMapping("/{id}")
    fun atualizar(@PathVariable id: Long,
                  @RequestBody @Valid evento: EventoDTO): EventoResponseDTO {
        return service.atualizar(id, evento)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun daletar(@PathVariable id: Long) {
        service.deletar(id)
    }
}