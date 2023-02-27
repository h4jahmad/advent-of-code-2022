package org.example.aoc2022

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Day2KtTest {

	@Test
	fun runDay2() {
		assertEquals(15, runDay2("Day2InputTest"))
	}

	@Test
	fun runDay2Part2() {
		assertEquals(12, runDay2Part2("Day2InputTest"))
	}
}