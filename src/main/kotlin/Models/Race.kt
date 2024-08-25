package com.ferdllr.Models

class Race(
    override var FOR: Int,
    override var DEX: Int,
    override var INT: Int,
    override var SAB: Int,
    override var CAR: Int,
    override var CON: Int,
    var raceName: String,
    var raceDesc: String
) : iStats {
    var name: String = raceName
    var desc: String = raceDesc
}