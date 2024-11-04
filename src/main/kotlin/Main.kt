package com.ferdllr

import com.ferdllr.Models.Character
import com.ferdllr.Models.Race
import com.ferdllr.controllers.CharacterController

fun main() {
    val characterController = CharacterController()
    val human = Race(1, 1, 1, 1, 1, 1, "Humano", "+1 em todos os atributos")
    val mainCharacter = Character().apply {
        name = "Hero"
        age = 20
        desc = "A brave hero"
        race = human
        FOR = 5
        DEX = 3
        CON = 4
        hp = 10
    }

    // Salva o personagem
    characterController.saveCharacter(mainCharacter)

    // Atualiza o personagem
    mainCharacter.age = 21
    characterController.updateCharacter(mainCharacter)

    // Exclui o personagem
    characterController.deleteCharacter(mainCharacter.name)
}
fun constCalc(value: Int): Int {
    var modi = -5
    for (i in 1..value) {
        if (i.mod(2) == 0) modi++
    }
    return modi
}