package br.upf.evento.repository

import br.upf.evento.dtos.EventoDTO
import br.upf.evento.model.Evento
import br.upf.evento.model.Inscricao
import br.upf.evento.model.StatusEvento
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
interface InscricaoRepository: JpaRepository<Inscricao, Long> {

}