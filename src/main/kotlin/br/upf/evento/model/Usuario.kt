package br.upf.evento.model

import jakarta.persistence.*

@Entity
data class Usuario (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val nome: String,
    val cidade: String,
    val telefone: String,

    @OneToMany(mappedBy = "usuario")
    val inscricoes: List<Inscricao> = listOf()
)
