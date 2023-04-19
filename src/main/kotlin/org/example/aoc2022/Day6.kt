package org.example.aoc2022

fun main() {
	val input = getFileRawValue("Day6Input")
	println("Day1: ${Day6.runDay6(input, 4)}")
	println("Day2: ${Day6.runDay6(input, 14)}")
}

object Day6 {

	fun runDay6(input: String, distinctCount: Int): Int {
		for (i in 0 until input.length - distinctCount) {
			val occurrences = mutableMapOf<Char, Int>()
			for (j in i until i + distinctCount) {
				occurrences[input[j]] = occurrences[input[j]]?.inc() ?: 1
			}
			if (occurrences.all { (_, v) -> v == 1 }) {
				return i + distinctCount
			}
		}
		return -1
	}
}