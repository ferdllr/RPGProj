package com.ferdllr.Models

public class Character() : iStats {

    override var FOR: Int = 8;
    override var DEX: Int = 8;
    override var INT: Int = 8;
    override var SAB: Int = 8;
    override var CAR: Int = 8;
    override var CON: Int = 8;

    var name: String = ""
    var desc: String = ""
    var age: Int = 0
    var hp: Int = 10
    var points: Int = 27
    var race: Race? = null
}