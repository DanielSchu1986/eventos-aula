package br.upf.eventos.controller

import br.upf.eventos.model.Evento
import br.upf.eventos.model.StatusEvento
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RestController
@RequestMapping("/eventos")
class EventoController {

    @GetMapping
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