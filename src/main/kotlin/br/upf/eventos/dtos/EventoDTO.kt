package br.upf.eventos.dtos

import br.upf.eventos.model.Inscricao
import br.upf.eventos.model.StatusEvento
import java.time.LocalDate
import java.time.LocalDateTime

data class EventoDTO(
    val nome: String,
    val data: LocalDate,
    val descricao: String,
    val status: StatusEvento
)
