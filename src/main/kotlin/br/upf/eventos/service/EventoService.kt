package br.upf.eventos.service

import br.upf.eventos.model.Evento
import br.upf.eventos.model.StatusEvento
import java.time.LocalDate

class EventoService {

    fun listar(): List<Evento> {
        val hoje = LocalDate.now()
        val evento = Evento(
            id = 1,
            nome = "UPF em Dança",
            data = hoje,
            dataInicioInsc = hoje.atStartOfDay().plusDays(10),
            dataFimInsc = hoje.atStartOfDay().plusDays(20),
            descricao = "Melhor evento de dança de salão",
            status = StatusEvento.ABERTO
        )
        return listOf(evento)
    }

}