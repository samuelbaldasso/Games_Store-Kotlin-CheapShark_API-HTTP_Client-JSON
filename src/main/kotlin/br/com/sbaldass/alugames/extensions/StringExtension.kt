package br.com.sbaldass.alugames.extensions

import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

fun String.transform(): Int{
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    val dataNasc = LocalDate.parse(this, formatter)
    val hoje = LocalDate.now()
    val idade = Period.between(dataNasc, hoje).years
    return idade
}