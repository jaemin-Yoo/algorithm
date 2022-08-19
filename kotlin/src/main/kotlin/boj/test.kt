package com.jaemin.practicekotlin

fun main() {
    val coco = Bird("coco")
}

class Bird {
    init {
        println("init start")
    }

    constructor(name: String, test: Unit = println("args start")) {
        println("constructor start")
    }
}