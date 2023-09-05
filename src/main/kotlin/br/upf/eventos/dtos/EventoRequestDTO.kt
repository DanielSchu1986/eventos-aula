package br.upf.eventos.dtos

import br.upf.eventos.model.StatusEvento
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.time.LocalDate
import java.time.LocalDateTime

data class EventoRequestDTO(
    val nome: String?,
    val data: LocalDate?,
    val dataInicioInsc: LocalDateTime?,
    val dataFimInsc: LocalDateTime?,
    val descricao: String?,
    val status: StatusEvento?
)
