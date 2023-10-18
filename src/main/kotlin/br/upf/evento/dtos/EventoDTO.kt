package br.upf.evento.dtos

import br.upf.evento.model.Inscricao
import br.upf.evento.model.StatusEvento
import jakarta.validation.constraints.NotBlank
import java.time.LocalDate
import java.time.LocalDateTime

data class EventoDTO(
    @field:NotBlank(message = "O evento deve ter um nome")
    val nome: String,
    val data: LocalDate,
    val descricao: String,
    val status: StatusEvento,
)
