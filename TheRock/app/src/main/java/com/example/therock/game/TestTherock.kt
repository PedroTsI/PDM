package com.example.therock.game

class TestTherock {
    fun main(){
    var jogo = Therock(1, 100)

    println(jogo.menor)
    println(jogo.maior)
    println(jogo.sorteio)
    println(jogo.status)
    println(jogo.jogar(12))

    var sorteio = jogo.sorteio
    println(jogo.jogar(sorteio - 1))
    println(jogo.jogar(sorteio + 1))
    println(jogo.status)
    }
}