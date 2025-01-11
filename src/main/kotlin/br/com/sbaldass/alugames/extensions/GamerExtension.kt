package br.com.sbaldass.alugames.extensions

import br.com.sbaldass.alugames.model.Game
import br.com.sbaldass.alugames.model.GameInfo
import br.com.sbaldass.alugames.model.Gamer
import br.com.sbaldass.alugames.model.GamerInfoJson

fun GamerInfoJson.convert(): Gamer {
    return Gamer(this.nome, this.email, this.dataNasc, this.username)
}