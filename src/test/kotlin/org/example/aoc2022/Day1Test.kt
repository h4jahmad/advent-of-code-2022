package org.example.aoc2022

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Day1Test {

	@Test
	fun runDay1() {
		assertEquals(24000, runDay1("Day1InputTest"))
	}
	@Test
	fun runDay1Part2(){
		assertEquals(45000, runDay1("Day1InputTest"))
	}
}