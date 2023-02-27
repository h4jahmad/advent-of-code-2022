package org.example.aoc2022

const val LOWER_CASE_TOLERANCE: Int = 96
const val UPPER_CASE_TOLERANCE: Int = 38

fun main() {
	println(runDay3Part2("Day3Input"))
}

fun runDay3Part1(inputFileName: String): Long {
	val rawValue = getFileRawValue(inputFileName)

	return rawValue.lines().map { rucksack ->
		rucksack.substring(0 until rucksack.length / 2).toSet() to rucksack.substring(rucksack.length / 2).toSet()
	}
		.flatMap { (first, second) -> first.filter(second::contains) }
		.sumOf(::getPriority).toLong()
}

fun runDay3Part2(inputFileName: String): Long {
	val rawValue = getFileRawValue(inputFileName)
	return rawValue.lines()
		.chunked(3) { elfGroup ->
			elfGroup.map { it.toSet() }
		}
		.flatMap { itemsDistinct ->
			itemsDistinct[0] intersect itemsDistinct[1] intersect itemsDistinct[2]
		}.sumOf { getPriority(it) }.toLong()
}

private fun getPriority(diffChar: Char): Int =
	if (diffChar.isUpperCase()) {
		diffChar - UPPER_CASE_TOLERANCE
	} else {
		diffChar - LOWER_CASE_TOLERANCE
	}.code