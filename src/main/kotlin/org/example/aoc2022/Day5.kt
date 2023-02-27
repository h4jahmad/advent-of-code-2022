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
	data class Stack(val name: Int, val crates: MutableList<Char> = mutableListOf())
	data class Instruction(
		val cratesToMove: Int,
		val srcCrateName: Int,
		val destCrateName: Int,
	)

	fun runDay5Part1(fileName: String): String {
		val rawInput = getFileRawValue(fileName).split("\r\n\r\n")
		println(rawInput.size)
		println(rawInput[0])
		println(rawInput[1])
//		val stacksRowCount = rawInput.indexOfFirst { it == " 1" } + 1
//		val stacks = Array<Array<Char>>(stacksRowCount) {}



		return ""
	}

	fun runDay5Part2(fileName: String): String {
		return ""
	}

}