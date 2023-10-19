package br.upf.evento.exceptions

class NotFoundException(override val message: String)
    : RuntimeException()