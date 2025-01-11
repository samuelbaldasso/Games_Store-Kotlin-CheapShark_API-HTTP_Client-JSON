package br.com.sbaldass.alugames.model

import java.time.LocalDate
import java.util.Scanner
import java.util.regex.Pattern
import kotlin.random.Random

data class Gamer(var nome: String, var email: String) {
    init {
        if(nome.isNullOrBlank()) {
            throw IllegalArgumentException("Nome inválido.")
        }
        this.email = validarEmail()
    }

    var dataNasc: String? = null
    var username: String? = null
        set(value) {
            field = value
            if (id.isNullOrBlank()) {
                createId()
            }
        }

    var id: String? = null
        private set

    val jogosBuscados = mutableListOf<Game>()

    constructor(nome: String, email: String, dataNasc: String?, username: String?) : this(nome, email) {
        this.dataNasc = dataNasc
        this.username = username
        createId()
    }

    override fun toString(): String {
        return "Gamer(nome='$nome', email='$email', dataNasc=$dataNasc, username=$username, id=$id)"
    }

    private fun createId() {
        val numero = Random.nextInt(10000)
        val tag = String.format("%04d", numero)
        id = "$username#$tag"
    }

    private fun validarEmail(): String {
        val EMAIL_ADDRESS
                : Pattern = Pattern.compile(
            "[a-zA-Z0-9+.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
        )
        val regex = Regex(pattern = EMAIL_ADDRESS.pattern())
        if(regex.matches(email)){
            return email
        }else{
            throw IllegalArgumentException("Email inválido")
        }
    }

    fun alugaJogo(jogo: Game, period: Period): Rental{
        return Rental(this, jogo, period)
    }

    companion object{
        fun criarGamer(leitura: Scanner): Gamer{
            val nome = leitura.nextLine()
            val email = leitura.nextLine()
            val opcao = leitura.nextLine()

            if(opcao.equals("S", true)){
                val dataNasc = leitura.nextLine()
                val username = leitura.nextLine()

                return Gamer(nome, email, dataNasc, username)
            }else{
                return Gamer(nome, email)
            }
        }
    }
}
