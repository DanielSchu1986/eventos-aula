package br.upf.eventos.dtos

import br.upf.eventos.model.Inscricao
import br.upf.eventos.model.StatusEvento
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.time.LocalDate
import java.time.LocalDateTime

data class EventoDTO(
    @field:NotBlank(message = "Evento sempre deve ter um nome!")
    val nome: String,
    @field:NotNull(message = "Evento deve ter uma data")
    val data: LocalDate,
    @field:NotBlank(message = "Evento deve ter uma descricao")
    val descricao: String,
    val status: StatusEvento
)
