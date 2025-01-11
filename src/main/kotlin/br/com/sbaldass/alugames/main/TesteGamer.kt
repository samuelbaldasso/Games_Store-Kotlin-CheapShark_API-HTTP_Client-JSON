package br.com.sbaldass.alugames.main

import br.com.sbaldass.alugames.model.Gamer
import br.com.sbaldass.alugames.model.Period
import br.com.sbaldass.alugames.model.Rental
import br.com.sbaldass.alugames.services.APISearch
import java.time.LocalDate

fun main() {
    val apiSearch = APISearch().consumeGamers()
    val games = APISearch().consumeAPI()

    val gamer = apiSearch[3]

    val jogo = games[10]

    val periodo = Period(LocalDate.now(), LocalDate.now().plusDays(7))
    val aluguel = gamer.alugaJogo(jogo, periodo)
    println("$gamer $jogo $aluguel")
}
