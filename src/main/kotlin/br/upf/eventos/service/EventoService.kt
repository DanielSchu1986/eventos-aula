package br.upf.eventos.service

import br.upf.eventos.converters.EventoConverter
import br.upf.eventos.dtos.EventoDTO
import br.upf.eventos.dtos.EventoRequestDTO
import br.upf.eventos.dtos.EventoResponseDTO
import br.upf.eventos.exceptions.NotFoundException
import br.upf.eventos.repository.EventoRepository
import org.springframework.stereotype.Service

private const val EVENTO_NOT_FOUND_MESSAGE = "Evento não encontrado"

@Service
class EventoService(private val repository: EventoRepository,
    private val converter: EventoConverter) {

    fun listar(): List<EventoResponseDTO> {
        return repository.findAll()
            .map { converter.toEventoResponseDTO(it) }
    }

    fun buscaPorId(id: Long): EventoResponseDTO {
        val evento = repository.findAll()
            .firstOrNull { it.id == id }
            ?: throw NotFoundException(EVENTO_NOT_FOUND_MESSAGE)
        return converter.toEventoResponseDTO(evento)
    }

    fun cadastrar(dto: EventoDTO): EventoResponseDTO {
        val evento = repository.cadastrar(converter.toEvento(dto))
        return converter.toEventoResponseDTO(evento)
    }

    fun atualizar(id: Long, dto: EventoRequestDTO): EventoResponseDTO {
        val evento = repository.findAll()
            .firstOrNull { it.id == id }
            ?: throw NotFoundException(EVENTO_NOT_FOUND_MESSAGE)
        val eventoAtualizar =
            evento.copy(
                nome = dto.nome ?: evento.nome,
                data = dto.data ?: evento.data,
                dataFimInsc = dto.dataFimInsc ?: evento.dataFimInsc,
                dataInicioInsc = dto.dataInicioInsc ?: evento.dataInicioInsc,
                descricao = dto.descricao ?: evento.descricao,
                status = dto.status ?: evento.status,
            )
        return converter.toEventoResponseDTO(repository.update(eventoAtualizar))
    }

    fun deletar(id: Long) {
        repository.deletar(id)
    }
}

