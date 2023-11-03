package br.upf.sistemadeeventos.repository

import br.upf.sistemadeeventos.dtos.EventoRequestDTO
import br.upf.sistemadeeventos.exceptions.NotFoundException
import br.upf.sistemadeeventos.model.Evento
import br.upf.sistemadeeventos.model.StatusEvento
import br.upf.sistemadeeventos.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
interface UsuarioRepository: JpaRepository<Usuario, Long> {

}