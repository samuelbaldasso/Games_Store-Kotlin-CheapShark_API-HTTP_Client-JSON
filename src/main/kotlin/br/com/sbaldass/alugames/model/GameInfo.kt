package br.com.sbaldass.alugames.model

import br.com.sbaldass.alugames.model.Game

data class GameInfo(var info: Game) {
    override fun toString(): String {
        return info.toString()
    }
}
