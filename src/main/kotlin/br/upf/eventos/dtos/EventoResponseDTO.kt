package br.upf.eventos.dtos

import br.upf.eventos.model.Inscricao
import br.upf.eventos.model.StatusEvento
import java.time.LocalDate

data class EventoResponseDTO (
    val nome: String,
    val data: LocalDate,
    val descricao: String,
    val status: StatusEvento,
    val inscritos: List<Inscricao>
)