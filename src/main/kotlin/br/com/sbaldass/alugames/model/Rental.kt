package br.com.sbaldass.alugames.model

import java.time.LocalDate
import java.time.Period

data class Rental(val gamer: Gamer, val jogo: Game, val period: br.com.sbaldass.alugames.model.Period){

    var preco: Double = jogo.preco * period.emDias

    override fun toString(): String {
        return "Rental(gamer=${gamer.nome}, jogo=${jogo.titulo}, preco=$preco)"
    }
}
