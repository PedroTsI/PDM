package com.example.rgb

class Palet {
    private var lista = mutableListOf<Color>()

    fun add(color: Color){
        this.lista.add(color)
    }

    fun get(index: Int): Color{
        return this.lista[index]
    }

    fun get(): MutableList<Color>{
        return this.lista
    }

    fun delete(index: Int){
        this.lista.removeAt(index)
    }

    fun size(): Int{
        return this.lista.size
    }
}