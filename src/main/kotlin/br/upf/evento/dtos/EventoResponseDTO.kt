package br.upf.evento.dtos

import br.upf.evento.model.StatusEvento
import java.time.LocalDate
import java.time.LocalDateTime

data class EventoResponseDTO (
    val id: Long? = null,
    val nome: String,
    val data: LocalDate,
    val dataInicioInsc: LocalDateTime,
    val dataFimInsc: LocalDateTime,
    val descricao: String,
    val status: StatusEvento,
)