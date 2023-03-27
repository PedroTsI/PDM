package com.example.gossipapp

class Cadastro {
    private var lista: MutableList<Gossip>

    init {
        this.lista = mutableListOf()
    }

    fun add(gossip: Gossip){
        this.lista.add(gossip)
    }

    fun size(): Int{
        return this.lista.size
    }

    fun get(): Gossip{
        return this.lista.random()
    }
}