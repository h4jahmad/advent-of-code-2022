package org.example.aoc2022

fun main() {
	println(runDay1("Day1Input"))
}

fun runDay1(inputFileName: String): Int {
	val rawInput = object {}::class.java.classLoader.getResource(inputFileName).readText()
	val calories = rawInput.split("\r\n\r\n").map { elf -> elf.lines().map(String::toInt) }

	return calories.map { it.sum() }
		.sortedDescending().take(3).sum()
}