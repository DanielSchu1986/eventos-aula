package br.upf.sistemadeeventos.dtos

import br.upf.sistemadeeventos.model.StatusEvento
import java.time.LocalDate
import java.time.LocalDateTime

data class EventoResponseDTO(
    val nome: String,
    val data: LocalDate,
    val dataInicioInsc: LocalDateTime,
    val dataFimInsc: LocalDateTime,
    val descricao: String,
    val status: StatusEvento
)
