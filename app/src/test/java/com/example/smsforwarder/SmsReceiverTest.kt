package com.example.smsforwarder

import org.junit.Test
import org.junit.Assert.*

class SmsReceiverTest {
    @Test
    fun testForwardFormat() {
        val sender = "+981234"
        val msg = "سلام"
        val expected = "From: $sender\n$msg"
        assertEquals(expected, "From: +981234\nسلام")
    }
}