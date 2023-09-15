package br.upf.sistemasdeeventos.dtos

import br.upf.sistemasdeeventos.model.StatusEvento
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Null
import java.time.LocalDate
import java.time.LocalDateTime

data class EventoDTO(
    @field:NotBlank(message = "Evento sempre deve ter um nome")
    val nome: String,
    @field:NotNull(message = "Evento sempre deve ter uma data")
    val data: LocalDate,
    val dataInicioInsc: LocalDateTime,
    val dataFimInsc: LocalDateTime,
    val descricao: String,
    val status: StatusEvento
)
