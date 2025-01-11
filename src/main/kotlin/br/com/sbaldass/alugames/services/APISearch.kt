package br.com.sbaldass.alugames.services

import br.com.sbaldass.alugames.extensions.convert
import br.com.sbaldass.alugames.model.Game
import br.com.sbaldass.alugames.model.GameInfo
import br.com.sbaldass.alugames.model.Gamer
import br.com.sbaldass.alugames.model.GamerInfoJson
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers

class APISearch {
    private fun consumeData(address: String): String {
        val client: HttpClient = HttpClient.newHttpClient()
        val request =
            HttpRequest.newBuilder().uri(URI.create(address)).build()

        val response = client.send(request, BodyHandlers.ofString())

        val json = response.body()
        return json
    }

    fun consumeAPI(): List<Game> {
        val api = consumeData(
            "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/jogos.json"
        )
        val gson = Gson()
        val objectType = object : TypeToken<List<Game>>() {
        }.type
        val list: List<Game> = gson.fromJson(api, objectType)
        return list
    }

    fun consumeGamers(): List<Gamer> {
        val client = consumeData("https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json")

        val gson = Gson()

        val objectType = object : TypeToken<List<GamerInfoJson>>() {
        }.type
        val list: List<GamerInfoJson> = gson.fromJson(client, objectType)
        return list.map { gamerInfoJson ->
            gamerInfoJson.convert()
        };
    }
}