package br.upf.eventos.repository

import br.upf.eventos.model.Evento
import br.upf.eventos.model.StatusEvento
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
interface EventoRepository: JpaRepository<Evento, Long> {
    fun findByNome(nomeEvento: String): List<Evento>

}