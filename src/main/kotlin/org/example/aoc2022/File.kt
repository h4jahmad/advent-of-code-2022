package org.example.aoc2022

fun getFileRawValue(fileName: String) =
	object {}::class.java.classLoader.getResource(fileName).readText()