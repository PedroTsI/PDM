package com.example.therock.game

class Therock(var menor: Int, var maior: Int) {
    var sorteio: Int
    var status: Status

    init {
        this.sorteio = ((this.menor + 1) .. (this.maior - 1)).random()
        this.status = Status.EXECUTANDO
    }

    fun arrochado(): Boolean{
        return this.menor + 1 == this.maior - 1
    }

    fun atualizarIntervalo(chute: Int): Int{
        if (chute < this.sorteio){
            this.menor = chute
            return -1
        }else{
            this.maior = chute
            return 1
        }
    }

    fun chuteValido(chute: Int): Boolean{
        return chute > this.menor && chute < this.maior && chute != this.sorteio
    }

    fun jogar(chute: Int): Int{
        if (!this.chuteValido(chute)) {
            this.status = Status.PERDEU
            return 0
        }
        else{
            var valor = this.atualizarIntervalo(chute)
            if (this.arrochado()){
                this.status = Status.GANHOU
            }
            return valor
        }
    }
}