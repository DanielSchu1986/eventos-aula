package br.upf.sistemadeeventos.repository

import br.upf.sistemadeeventos.model.Evento
import br.upf.sistemadeeventos.model.StatusEvento
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
class EventoRepository (private var eventos: MutableList<Evento>) {

    private var idCont = 4L

    init {
        val hoje = LocalDate.now()
        val evento1 = Evento(
            id = 1,
            nome = "UPF em Dança 1" ,
            data = hoje,
            dataInicioInsc = hoje.atStartOfDay().plusDays( 10),
            dataFimInsc = hoje.atStartOfDay().plusDays( 20),
            descricao = "Melhor evento de Dança de Passo Fundo" ,
            status = StatusEvento.PREVISTO,
            inscritos = listOf()
        )
        val evento2 = Evento(
            id = 2,
            nome = "UPF em Dança 2" ,
            data = hoje,
            dataInicioInsc = hoje.atStartOfDay().plusDays( 10),
            dataFimInsc = hoje.atStartOfDay().plusDays( 20),
            descricao = "Melhor evento de Dança de Passo Fundo 23" ,
            status = StatusEvento.PREVISTO,
            inscritos = listOf()
        )
        val evento3 = Evento(
            id = 3,
            nome = "UPF em Dança 3" ,
            data = hoje,
            dataInicioInsc = hoje.atStartOfDay().plusDays( 10),
            dataFimInsc = hoje.atStartOfDay().plusDays( 20),
            descricao = "Melhor evento de Dança de Passo Fundo 3" ,
            status = StatusEvento.PREVISTO,
            inscritos = listOf()
        )
        eventos = mutableListOf(evento1, evento2, evento3)
    }

    fun findAll() = eventos

    fun cadastrar(evento: Evento) {
        eventos.add(evento.copy(id = idCont++))
    }

}