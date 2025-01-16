package org.example

import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class SampleTest {
        @Test
        fun testSum() {
            val sample = Sample()
            assertEquals(3, sample.sum(1, 2))
        }
 }