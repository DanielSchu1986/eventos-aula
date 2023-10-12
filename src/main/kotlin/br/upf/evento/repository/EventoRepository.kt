package br.upf.evento.repository

import br.upf.evento.model.Evento
import br.upf.evento.model.StatusEvento
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
class EventoRepository(private var eventos: MutableList<Evento>) {

    init {
        val hoje = LocalDate.now()
        val evento1 = Evento(
            id = 1,
            nome = "UPF em Dança 1",
            data = hoje,
            dataInicioInsc = hoje.atStartOfDay().plusDays(10),
            dataFimInsc = hoje.atStartOfDay().plusDays(20),
            descricao = "Melhor eventos de dança da região 1",
            status = StatusEvento.ABERTO
        )
        val evento2 = Evento(
            id = 2,
            nome = "UPF em Dança 2",
            data = hoje,
            dataInicioInsc = hoje.atStartOfDay().plusDays(10),
            dataFimInsc = hoje.atStartOfDay().plusDays(20),
            descricao = "Melhor eventos de dança da região 2",
            status = StatusEvento.ABERTO
        )
        val evento3 = Evento(
            id = 3,
            nome = "UPF em Dança 3",
            data = hoje,
            dataInicioInsc = hoje.atStartOfDay().plusDays(10),
            dataFimInsc = hoje.atStartOfDay().plusDays(20),
            descricao = "Melhor eventos de dança da região 3",
            status = StatusEvento.ABERTO
        )
        eventos = mutableListOf(evento1, evento2, evento3)
    }

    fun findAll() = eventos

}