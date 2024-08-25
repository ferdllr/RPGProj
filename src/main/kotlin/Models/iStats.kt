package com.ferdllr.Models

interface iStats {

    var FOR: Int;
    var DEX: Int;
    var INT: Int;
    var SAB: Int;
    var CAR: Int;
    var CON: Int;

    fun raceTraits(race: Race){
        this.FOR += race.FOR;
        this.DEX += race.DEX;
        this.INT += race.INT;
        this.SAB += race.SAB;
        this.CAR += race.CAR;
        this.CON += race.CON;
    }
    fun resStats(){
        this.FOR = 8;
        this.DEX = 8;
        this.INT = 8;
        this.SAB = 8;
        this.CAR = 8;
        this.CON = 8;
    }
    fun addStats(array: Array<Int>){
        this.FOR += array[0];
        this.DEX += array[1];
        this.INT += array[2];
        this.SAB += array[3];
        this.CAR += array[4];
        this.CON += array[5];
    }
}