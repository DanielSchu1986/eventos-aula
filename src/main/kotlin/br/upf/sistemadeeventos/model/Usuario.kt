package br.upf.sistemadeeventos.model

data class Usuario(
    val id: Long? = null,
    val nome: String,
    val cidade: String,
    val telefone: String
)