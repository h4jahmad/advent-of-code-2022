package org.example.aoc2022

import java.util.*

fun main() {
	println(Day5.runDay5Part1("Day5Input"))
}

/**
 * List<Stack>: - Stack -> Name: Int
 * 				 			 					 Crates: List<Char>
 *
 * List<Instruction>: - Instruction ->  1- Number of crates to move: Int
 * 							 												2- Name of the source crate: Int
 * 							 												3- Name of the destination crate: Int
 * */

object Day5 {
	data class SupplyStack(val name: Int, val crates: Stack<Char> = Stack())

	private fun List<SupplyStack>.getIndexByStackName(name: Int): Int = indexOfFirst { it.name == name }

	data class Instruction(
		val cratesToMove: Int,
		val from: Int,
		val to: Int,
	)

	fun runDay5Part1(fileName: String): String {
		val rawInput = getFileRawValue(fileName).split("\r\n\r\n")
		val stacks = extractStacks(rawInput[0])
		val instructions = extractInstructions(rawInput[1])

		return getCratesOnTop(stacks, instructions)
	}

	private fun getCratesOnTop(stacks: List<SupplyStack>, instructions: List<Instruction>): String {
		val mutStacks = stacks.toMutableList()
		instructions.forEach { instruction ->
			val fromStackIndex = mutStacks.getIndexByStackName(instruction.from)
			val toStackIndex = mutStacks.getIndexByStackName(instruction.to)
			repeat(instruction.cratesToMove) {
				mutStacks[toStackIndex].crates.push(mutStacks[fromStackIndex].crates.pop())
			}
		}

		return mutStacks.map {
			it.crates.peek()
		}.joinToString("")
	}

	private fun extractStacks(rawInput: String): List<SupplyStack> {
		val lines = rawInput.lines()
		val stacks = extractStackNames(lines.last()).map { SupplyStack(it) }
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


	fun runDay5Part2(fileName: String): String {
		return ""
	}

}