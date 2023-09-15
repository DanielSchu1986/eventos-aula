package br.upf.sistemasdeeventos.service

import br.upf.sistemasdeeventos.converters.EventoConverter
import br.upf.sistemasdeeventos.dtos.EventoDTO
import br.upf.sistemasdeeventos.dtos.EventoResponseDTO
import br.upf.sistemasdeeventos.model.Evento
import br.upf.sistemasdeeventos.repository.EventoRepository
import org.springframework.stereotype.Service

@Service
class EventoService(
    val repository: EventoRepository,
    val converter: EventoConverter
) {

    fun listar(): List<EventoResponseDTO> {
        return repository.findAll()
            .map(converter::toEventoResponseDTO)
    }

    fun buscarPorId(id: Long): EventoResponseDTO {
        val evento = repository.findAll().first{ it.id == id }
        return converter.toEventoResponseDTO(evento)
    }

    fun cadastrar(dto: EventoDTO) {
        repository.cadastrar(converter.toEvento(dto))
    }

    fun atualizar(id: Long, dto: EventoDTO) {
        val evento = repository.findAll().first { it.id == id }
        repository.update(evento.copy(
            nome = dto.nome,
            data = dto.data,
            dataInicioInsc = dto.dataInicioInsc,
            dataFimInsc = dto.dataFimInsc,
            descricao = dto.descricao,
            status = dto.status
        ))
    }

}