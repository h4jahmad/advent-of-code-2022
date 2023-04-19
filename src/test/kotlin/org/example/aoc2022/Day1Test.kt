package org.example.aoc2022

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day1Test {

	@Test
	fun runDay1() {
		assertEquals(24000, Day1.partOne("Day1InputTest"))
	}
	@Test
	fun runDay1Part2(){
		assertEquals(45000, Day1.partTwo("Day1InputTest"))
	}
}