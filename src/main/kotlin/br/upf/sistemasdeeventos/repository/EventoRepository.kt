package br.upf.sistemasdeeventos.repository

import br.upf.sistemasdeeventos.model.Evento
import br.upf.sistemasdeeventos.model.StatusEvento
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
class EventoRepository(
    private var eventos: MutableList<Evento>) {

    private var idCont = 4L

    init {
        val hoje = LocalDate.now()
        val evento = Evento(
            id = 1,
            nome = "UPF em dança",
            data = hoje,
            dataInicioInsc = hoje.atStartOfDay().plusDays(10),
            dataFimInsc = hoje.atStartOfDay().plusDays(20),
            descricao = "Melhor evento de dança de passo fundo",
            status = StatusEvento.PREVISTO
        )
        val evento2 = Evento(
            id = 2,
            nome = "UPF em dança 2",
            data = hoje,
            dataInicioInsc = hoje.atStartOfDay().plusDays(10),
            dataFimInsc = hoje.atStartOfDay().plusDays(20),
            descricao = "Melhor evento de dança de passo fundo",
            status = StatusEvento.PREVISTO
        )
        val evento3 = Evento(
            id = 3,
            nome = "UPF em 3",
            data = hoje,
            dataInicioInsc = hoje.atStartOfDay().plusDays(10),
            dataFimInsc = hoje.atStartOfDay().plusDays(20),
            descricao = "Melhor evento de dança de passo fundo",
            status = StatusEvento.PREVISTO
        )
        eventos = mutableListOf(
            evento,
            evento2,
            evento3)
    }

    fun findAll() = eventos
    fun cadastrar(evento: Evento) {
        eventos.add(evento.copy(id = idCont++))
    }

    fun update(evento: Evento) {
        eventos.removeIf { it.id == evento.id }
        eventos.add(evento)
    }
}