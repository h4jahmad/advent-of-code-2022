package org.example.aoc2022

fun main() {
	println(Day4.runDay4Part1("Day4Input"))
}

object Day4 {
	internal fun runDay4Part1(inputFileName: String): Int {
		val rawInput = getFileRawValue(inputFileName)

		val pairs = rawInput.lines().map { it.asRange() }

		return pairs.count { (firstAssignments, secondAssignments) ->
			firstAssignments in secondAssignments || secondAssignments in firstAssignments
		}
	}

	internal fun runDay4Part2(inputFileName: String): Int {
		val rawInput = getFileRawValue(inputFileName)

		val pairs = rawInput.lines().map { it.asRange() }
		return pairs.count { (firstAssignments, secondAssignments) ->
			firstAssignments partiallyOverlaps secondAssignments || secondAssignments partiallyOverlaps firstAssignments
		}
	}

	private fun String.asRange(): Pair<IntRange, IntRange> =
		substringBefore(',').asIntRange() to substringAfter(',').asIntRange()

	private fun String.asIntRange(): IntRange =
		substringBefore('-').toInt()..substringAfter('-').toInt()

	private infix fun IntRange.fullyOverlaps(other: IntRange): Boolean =
		(this.first >= other.first && this.last <= other.last)

	operator fun IntRange.contains(other: IntRange) : Boolean = (this.first >= other.first && this.last <= other.last)

	private infix fun IntRange.partiallyOverlaps(other: IntRange): Boolean =
		(this.first >= other.first && this.first <= other.last) || (other.first <= this.last && other.last >= this.last)


}