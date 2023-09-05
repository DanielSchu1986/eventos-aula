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
            descricao = "Melhor evento de Dança de Passo Fundo",
            status = StatusEvento.PREVISTO,
            inscritos = listOf()
        )
        val evento2 = Evento(
            id = 2,
            nome = "X Semana do conhecimento",
            data = hoje.plusDays(3),
            dataInicioInsc = hoje.atStartOfDay().plusDays(13),
            dataFimInsc = hoje.atStartOfDay().plusDays(23),
            descricao = "Melhor evento de conhecimento de Passo Fundo",
            status = StatusEvento.ABERTO,
            inscritos = listOf()
        )
        val evento3 = Evento(
            id = 3,
            nome = "Jornada Integrada da Matemática",
            data = hoje.plusDays(5),
            dataInicioInsc = hoje.atStartOfDay().plusDays(15),
            dataFimInsc = hoje.atStartOfDay().plusDays(25),
            descricao = "Melhor evento de matemática de Passo Fundo",
            status = StatusEvento.CANCELADO,
            inscritos = listOf()
        )
        eventos = mutableListOf(evento1, evento2, evento3)
    }

    fun findAll() = eventos
    fun cadastrar(evento: Evento): Evento {
        val eventoComId = evento.copy(id = idCont++)
        eventos.add(eventoComId)
        return eventoComId
    }

    fun update(eventoAtualizar: Evento): Evento {
        findAll()
            .removeIf { it.id == eventoAtualizar.id }
        eventos.add(eventoAtualizar)
        return eventoAtualizar
    }

    fun deletar(id: Long) {
        val evento = eventos.first { it.id == id }
        eventos.remove(evento)
    }
}