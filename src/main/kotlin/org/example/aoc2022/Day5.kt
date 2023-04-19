package org.example.aoc2022

import java.util.*

fun main() {
	println("Day1: ${Day5.runDay5Part1("Day5Input")}")
	println("Day2: ${Day5.runDay5Part2("Day5Input")}")
}

object Day5 {

	fun runDay5Part1(fileName: String): String {
		val rawInput = getFileRawValue(fileName).split("\r\n\r\n")

		return extractStacks(rawInput[0])
			.moveCratesOneByOne(extractInstructions(rawInput[1]))
			.map {
				it.crates.peek()
			}.joinToString("")
	}

	fun runDay5Part2(fileName: String): String {
		val rawInput = getFileRawValue(fileName).split("\r\n\r\n")

		return extractStacks(rawInput[0])
			.moveCratesBatch(extractInstructions(rawInput[1]))
			.map {
				it.crates.peek()
			}.joinToString("")
	}

	private fun List<SupplyStack>.moveCratesOneByOne(
		instructions: List<Instruction>,
	): List<SupplyStack> {
		val list = this.toMutableList()
		instructions.forEach { instruction ->
			val fromStackIndex = list.getIndexByStack(instruction.from)
			val toStackIndex = list.getIndexByStack(instruction.to)
			repeat(instruction.cratesToMoveCount) {
				list[toStackIndex]
					.crates
					.push(
						list[fromStackIndex]
							.crates
							.pop()
					)
			}
		}
		return list
	}

	private fun List<SupplyStack>.moveCratesBatch(
		instructions: List<Instruction>,
	): List<SupplyStack> {
		val list = this.toMutableList()
		instructions.forEach { instruction ->
			val fromStackIdx = list.getIndexByStack(instruction.from)
			val toStackIdx = list.getIndexByStack(instruction.to)
			val cratesToMove = Stack<Char>()
			repeat(instruction.cratesToMoveCount) {
				cratesToMove += list[fromStackIdx]
					.crates
					.pop()
			}
			repeat(cratesToMove.size) {
				list[toStackIdx]
					.crates
					.push(
						cratesToMove.pop()
					)
			}

		}
		return this
	}

	private fun extractStacks(rawInput: String): List<SupplyStack> {
		val lines = rawInput.lines()
		val stacks = extractStackNames(lines.last()).map(::SupplyStack)
		lines.take(lines.lastIndex)
			.reversed()
			.forEach { cratesRow ->
				for ((destStackId, i) in (1..cratesRow.lastIndex step 4).withIndex()) {
					val crate = cratesRow.elementAt(i)
					if (crate.isLetter()) {
						stacks[destStackId].crates.push(crate)
					}
				}
			}
		return stacks
	}

	private fun extractStackNames(stacks: String): List<Int> = Regex("\\d+")
		.findAll(stacks)
		.map { it.value.toInt() }
		.toList()

	private fun extractInstructions(rawInstructions: String): List<Instruction> =
		rawInstructions.lines().map { instruction ->
			with(Regex("\\d+").findAll(instruction).map { it.value.toInt() }) {
				Instruction(
					elementAt(0),
					elementAt(1),
					elementAt(2)
				)
			}
		}

	private data class SupplyStack(val name: Int, val crates: Stack<Char> = Stack())

	private fun List<SupplyStack>.getIndexByStack(name: Int): Int = indexOfFirst { it.name == name }

	data class Instruction(
		val cratesToMoveCount: Int,
		val from: Int,
		val to: Int,
	)
}