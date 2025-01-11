package br.com.sbaldass.alugames.model

data class Game(var titulo: String, var capa: String, var preco: Double, var descricao: String? = null){
    override fun toString(): String {
        return "Game(titulo='$titulo', capa='$capa', preco=$preco, descricao=$descricao)"
    }
}
