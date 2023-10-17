package br.upf.eventos.repository

import br.upf.eventos.model.Evento
import br.upf.eventos.model.StatusEvento
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
class EventoRepository(private var eventos: MutableList<Evento>) {
    private var idCont = 4L
    init {
        val hoje = LocalDate.now()
        val evento1 = Evento(
            id = 1,
            nome = "UPF em Dança",
            data = hoje,
            dataInicioInsc = hoje.atStartOfDay().plusDays(10),
            dataFimInsc = hoje.atStartOfDay().plusDays(20),
            descricao = "Melhor evento de dança de salão",
            status = StatusEvento.ABERTO
        )
        val evento2 = Evento(
            id = 2,
            nome = "UPF em Dança 2",
            data = hoje,
            dataInicioInsc = hoje.atStartOfDay().plusDays(10),
            dataFimInsc = hoje.atStartOfDay().plusDays(20),
            descricao = "Melhor evento de dança de salão 2",
            status = StatusEvento.ABERTO
        )
        val evento3 = Evento(
            id = 3,
            nome = "UPF em Dança 3",
            data = hoje,
            dataInicioInsc = hoje.atStartOfDay().plusDays(10),
            dataFimInsc = hoje.atStartOfDay().plusDays(20),
            descricao = "Melhor evento de dança de salão 3",
            status = StatusEvento.ABERTO
        )
        eventos = mutableListOf(evento1, evento2, evento3)
    }

    fun findAll() = eventos
    fun cadastrar(evento: Evento) {
        eventos.add(evento.copy(id = idCont++))
    }

}