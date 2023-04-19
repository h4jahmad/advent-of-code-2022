package org.example.aoc2022

fun main() {
	println(Day1.partOne("Day1Input"))
}

object Day1 {
	fun partOne(inputFileName: String): Int {
		val rawInput = object {}::class.java.classLoader.getResource(inputFileName).readText()
		val calories = rawInput
			.split("\r\n\r\n")
			.map { elf ->
				elf.lines().map(String::toInt)
			}

		return calories.maxOf { it.sum() }
	}

	fun partTwo(inputFileName: String): Int {
		val rawInput = object {}::class.java.classLoader.getResource(inputFileName).readText()
		val calories = rawInput
			.split("\r\n\r\n")
			.map { elf ->
				elf.lines().map(String::toInt)
			}
		return calories
			.map { it.sum() }
			.sortedDescending()
			.take(3)
			.sum()
	}

}