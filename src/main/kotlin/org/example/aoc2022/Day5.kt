package org.example.aoc2022


fun main() {

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
	data class Stack(val name: Int, val crates: MutableList<String> = mutableListOf())
	data class Instruction(
		val cratesToMove: Int,
		val srcCrateName: Int,
		val destCrateName: Int,
	)

	fun runDay5Part1(fileName: String): String {
		val rawInput = getFileRawValue(fileName).split("\r\n\r\n")
		val stacks = extractStacks(rawInput[0])
		val instructions = extractInstructions(rawInput[1])

		return getCratesOnTop(stacks, instructions)
	}

	private fun getCratesOnTop(stacks: List<Stack>, instructions: List<Instruction>): String {
		val mutStacks = stacks.toMutableList()
		instructions.forEach { instruction ->
			repeat(instruction.cratesToMove) {
				mutStacks.
			}
		}

	}

	private fun extractStacks(rawInput: String): List<Stack> {
		val stacks = mutableListOf<Stack>()
		val lines = rawInput.lines().toMutableList()
		extractStackNames(lines).forEach { stacks += Stack(it) }
		lines.removeLast()
		val cratesList = lines.map {
			StringBuilder(it)
				.replace(Regex("   "), EMPTY_TAG)
				.split(' ')
				.map { crate -> crate.removeSurrounding("[", "]") }
		}
		cratesList.forEach { crates ->
			var step = 0
			crates.forEach { crate ->
				stacks[step].crates += crate
				step++
			}
		}
		return stacks
	}

	private fun extractStackNames(rawList: List<String>): List<Int> {
		val stackNames = Regex("\\d+").findAll(rawList.last()).map { it.value }.toList()
		return stackNames.map(String::toInt)
	}

	private fun extractInstructions(rawInstructions: String): List<Instruction> =
		rawInstructions.lines().map { instruction ->
			val instructionList = Regex("\\d+").findAll(instruction).map { it.value.toInt() }
			Instruction(
				instructionList.elementAt(0),
				instructionList.elementAt(1),
				instructionList.elementAt(2)
			)
		}


	fun runDay5Part2(fileName: String): String {
		return ""
	}

	const val EMPTY_TAG = "EMP"
}