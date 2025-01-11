package br.com.sbaldass.alugames.model

import java.time.LocalDate
import java.time.Period

data class Period(val dataInicial: LocalDate, val dataFinal: LocalDate) {

    val emDias = Period.between(dataInicial, dataFinal).days


}