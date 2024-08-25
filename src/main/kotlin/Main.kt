package com.ferdllr

import com.ferdllr.Models.Character
import com.ferdllr.Models.Race

fun main() {
    var raceMenu = true;
    var gameStart = false;
    var human = Race(1,1,1,1,1,1, "Humano", "+1 em todos os atributos")
    var gnome = Race(0,0,2,0,0,0, "Gnomo", "+2 de inteligencia")
    var dragonborn = Race(2,0,0,0,1, 0, "Dragonborn", "+2 de força e +1 de carisma")
    var mainCharacter = Character()
    println("-------------------")
    println("JOGO RPG")
    print("digite o nome de seu personagem: ")
    mainCharacter.name = readln()
    print("digite a idade de seu personagem: ")
    mainCharacter.age = readln().toInt()
    print("descreva seu personagem: ")
    mainCharacter.desc = readln()

    fun printCharAttributes(){
        println("nome: ${mainCharacter.name}")
        println("idade: ${mainCharacter.age}")
        println("desc: ${mainCharacter.desc}")
        println("vida: ${mainCharacter.hp}")
    }
    fun printStats(){
        println("força: ${mainCharacter.FOR}")
        println("destreza: ${mainCharacter.DEX}")
        println("inteligencia: ${mainCharacter.INT}")
        println("sabedoria: ${mainCharacter.SAB}")
        println("carisma: ${mainCharacter.CAR}")
        println("constituição: ${mainCharacter.CON}")
    }

    do{
        mainCharacter.resStats()
        println("------------------------------------")
        println("selecione a raça de seu personagem (1-3): ")
        println("---")
        println("1- ${human.name}")
        println(human.desc)
        println("---")
        println("2- ${gnome.name}")
        println(gnome.desc)
        println("---")
        println("3- ${dragonborn.name}")
        println(dragonborn.desc)
        println("------------------------------------")
        print("raça: ")

        when(readln().toInt()) {
            1 -> {
                mainCharacter.race = human
                mainCharacter.raceTraits(human)
            }
            2 -> {
                mainCharacter.race = gnome
                mainCharacter.raceTraits(gnome)
            }
            3 -> {
                mainCharacter.race = dragonborn
                mainCharacter.raceTraits(dragonborn)
            }
        }
        println("------------------------------------")
        println("você escolheu a classe ${mainCharacter.race?.name}, aqui estão seus atributos:")
        printStats()
        println("------------------------------------")
        print("deseja continuar (S/N): ")
        if(readln() == "S") raceMenu = false
    } while(raceMenu)
    println("-----------------------------------------")
    var playerAttInputs = arrayOf(0,0,0,0,0,0)
    val attributesArray = arrayOf("força", "destreza", "inteligencia", "sabedoria", "carisma", "constituição")
    do{
        for((index, value) in attributesArray.withIndex()){
            println("-- pontos: ${mainCharacter.points} --")
            print("quantos pontos você deseja adicionar de ${value}: ")
            var input = readln().toInt();
            if (mainCharacter.points >= input) {
                playerAttInputs[index] = input
                mainCharacter.points -= input
            };

        }
        mainCharacter.addStats(playerAttInputs)
    } while (mainCharacter.points > 0)
    println("\n\n\n--------------------------------------")
    mainCharacter.hp += constCalc(mainCharacter.CON)
    println("seu personagem: ")
    printCharAttributes()
    printStats()

}

fun constCalc(value: Int): Int {
    var modi = -5;
    for(i in 1..value){
        if (i.mod(2) == 0) modi++
    }
    return modi
}