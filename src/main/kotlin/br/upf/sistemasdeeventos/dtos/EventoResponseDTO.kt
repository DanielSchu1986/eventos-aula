package br.upf.sistemasdeeventos.dtos

import br.upf.sistemasdeeventos.model.Inscricao
import br.upf.sistemasdeeventos.model.StatusEvento
import java.time.LocalDate
import java.time.LocalDateTime

data class EventoResponseDTO(
    val nome: String,
    val data: LocalDate,
    val dataInicioInst: LocalDateTime,
    val dataFimInsc: LocalDateTime,
    val descricao: String,
    val status: StatusEvento,
    val inscritos: List<Inscricao>
)
