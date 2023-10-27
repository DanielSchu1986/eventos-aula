package br.upf.sistemadeeventos.dtos

import br.upf.sistemadeeventos.model.StatusEvento
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.time.LocalDate

data class EventoRequestDTO (
    @field:NotBlank(message = "Todo o evento deve ter um nome")
    val nome: String,
    @field:NotNull(message = "Data não pode ser nula")
    val data: LocalDate,
    val descricao: String,
    val status: StatusEvento
)