package org.example.aoc2022

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class Day6KtTest {

	@Test
	fun runDay6Part1() {
		val inputList = getFileRawValue("Day6InputTest").lines()
		assertEquals(7, Day6.runDay6(inputList[0], 4))
		assertEquals(5, Day6.runDay6(inputList[1], 4))
		assertEquals(6, Day6.runDay6(inputList[2], 4))
		assertEquals(10, Day6.runDay6(inputList[3], 4))
		assertEquals(11, Day6.runDay6(inputList[4], 4))
	}

	@Test
	fun runDay6Part2() {
		val inputList = getFileRawValue("Day6InputTest").lines()
		assertEquals(19, Day6.runDay6(inputList[0], 14))
		assertEquals(23, Day6.runDay6(inputList[1], 14))
		assertEquals(23, Day6.runDay6(inputList[2], 14))
		assertEquals(29, Day6.runDay6(inputList[3], 14))
		assertEquals(26, Day6.runDay6(inputList[4], 14))
	}

}
