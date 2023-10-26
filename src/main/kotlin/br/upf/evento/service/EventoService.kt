package br.upf.evento.service

import br.upf.evento.converters.EventoConverter
import br.upf.evento.dtos.EventoDTO
import br.upf.evento.dtos.EventoResponseDTO
import br.upf.evento.exceptions.NotFoundException
import br.upf.evento.repository.EventoRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class EventoService(private val repository: EventoRepository,
    val converter: EventoConverter) {

    fun listar(nomeEvento: String?, paginacao: Pageable): Page<EventoResponseDTO> {
        val evento = if (nomeEvento == null) {
            repository.findAll(paginacao)
        } else {
            repository.findByNome(nomeEvento, paginacao)
        }
        return evento
            .map { converter.toEventoResponseDTO(it) }
    }

    fun buscarPorId(id: Long): EventoResponseDTO {
        val evento = repository.findById(id)
            .orElseThrow { NotFoundException("Evento não encontrado") }
        return converter.toEventoResponseDTO(evento)
    }

    fun cadastrar(dto: EventoDTO): EventoResponseDTO {
        val evento = repository.save(
            converter.toEvento(dto))
        return converter.toEventoResponseDTO(evento)
    }

    fun atualizar(id: Long, dto: EventoDTO): EventoResponseDTO {
        val evento = repository.findById(id)
            .orElseThrow { NotFoundException("Evento não encontrado") }
            .copy(
                nome = dto.nome,
                data = dto.data,
                descricao = dto.descricao,
                status = dto.status
            )
        return converter.toEventoResponseDTO(
            repository.save(evento))
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }

}