package br.upf.eventos.exceptions

class NotFoundException(override val message: String)
    : RuntimeException() {
}