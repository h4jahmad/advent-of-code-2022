package org.example.aoc2022

import kotlin.IllegalArgumentException

fun main() {
	println(runDay2Part2("Day2Input"))
}

fun runDay2(inputFileName: String): Int {
	val rawInput = object {}::class.java.classLoader.getResource(inputFileName).readText()
	val moveList = rawInput.lines().map { row ->
		row.elementAt(0) to getPMove(row.elementAt(2))
	}
	var point = 0
	moveList.forEach { move ->
		point += processMove(move)
	}

	return point
}

fun runDay2Part2(inputFileName: String): Int {
	val rawInput = object {}::class.java.classLoader.getResource(inputFileName).readText()
	val resultList = rawInput.lines().map { row ->
		getMove(row.elementAt(0)) to getResult(row.elementAt(2))
	}
	var point = 0
	resultList.forEach { result ->
		point += processResult(result)
	}

	return point
}

fun processResult(result: Pair<Pair<Char, Int>, Pair<Char, Int>>): Int = result.second.second + when (result.second) {
	R_DRAW -> {
		result.first.second
	}

	R_LOSE -> {
		when (result.first) {
			ROCK -> SCISSORS.second
			PAPER -> ROCK.second
			SCISSORS -> PAPER.second
			else -> throw IllegalArgumentException()
		}
	}

	R_WIN -> {
		when (result.first) {
			ROCK -> PAPER.second
			PAPER -> SCISSORS.second
			SCISSORS -> ROCK.second
			else -> throw IllegalArgumentException()
		}
	}

	else -> throw IllegalArgumentException()
}


fun processMove(move: Pair<Char, Pair<Char, Int>>): Int {
	if (move.first - move.second.first == -23) return DRAW + move.second.second

	if ((move.first == OP_ROCK && move.second == P_SCISSORS) ||
		(move.first == OP_PAPER && move.second == P_ROCK) ||
		(move.first == OP_SCISSORS && move.second == P_PAPER)
	) return LOST + move.second.second

	return WIN + move.second.second
}

fun getPMove(move: Char): Pair<Char, Int> = when (move) {
	'X' -> P_ROCK
	'Y' -> P_PAPER
	'Z' -> P_SCISSORS
	else -> throw IllegalArgumentException()
}

fun getMove(move: Char): Pair<Char, Int> = when (move) {
	'A' -> ROCK
	'B' -> PAPER
	'C' -> SCISSORS
	else -> throw IllegalArgumentException()
}

fun getResult(result: Char): Pair<Char, Int> = when (result) {
	'X' -> R_LOSE
	'Y' -> R_DRAW
	'Z' -> R_WIN
	else -> throw IllegalArgumentException()
}

const val WIN = 6
const val DRAW = 3
const val LOST = 0
const val OP_ROCK = 'A'
const val OP_PAPER = 'B'
const val OP_SCISSORS = 'C'
val P_ROCK = 'X' to 1
val P_PAPER = 'Y' to 2
val P_SCISSORS = 'Z' to 3

val R_LOSE = 'X' to 0
val R_DRAW = 'Y' to 3
val R_WIN = 'z' to 6
val ROCK = 'A' to 1
val PAPER = 'B' to 2
val SCISSORS = 'C' to 3

// Rock defeats Scissors, Scissors defeats Paper, Paper defeats Rock
