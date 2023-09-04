package br.upf.eventos.dtos

import br.upf.eventos.model.Inscricao
import br.upf.eventos.model.StatusEvento
import java.time.LocalDate
import java.time.LocalDateTime

data class EventoResponseDTO(
    val nome: String,
    val data: LocalDate,
    val dataInicioInsc: LocalDateTime,
    val dataFimInsc: LocalDateTime,
    val descricao: String,
    val statusEvento: StatusEvento,
    val inscritos: List<Inscricao>
)
