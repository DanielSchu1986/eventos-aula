package br.upf.sistemadeeventos.controller

import br.upf.sistemadeeventos.dtos.EventoRequestDTO
import br.upf.sistemadeeventos.dtos.EventoResponseDTO
import br.upf.sistemadeeventos.service.EventoService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/eventos")
class EventoController(private val service: EventoService) {

    @GetMapping
    fun listar(@RequestParam(required = false) nomeEvento: String?,
        @PageableDefault(size = 10) paginacao: Pageable): Page<EventoResponseDTO> {
        return service.listar(nomeEvento, paginacao)
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): EventoResponseDTO {
        return service.buscaPorId(id)
    }

    @PostMapping
    @Transactional
    fun cadastrar(
        @RequestBody @Valid evento: EventoRequestDTO,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<EventoResponseDTO> {
        val eventoResponse = service.cadastra(evento)
        val uri = uriBuilder.path("/eventos/${eventoResponse.id}")
            .build().toUri()
        return ResponseEntity.created(uri).body(eventoResponse)
    }

    @PutMapping("/{id}")
    @Transactional
    fun update(@PathVariable id: Long, @RequestBody @Valid evento: EventoRequestDTO):
            EventoResponseDTO {
        return service.update(id, evento)
    }

    @DeleteMapping("/{id}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(@PathVariable id: Long) {
        service.remove(id)
    }
}