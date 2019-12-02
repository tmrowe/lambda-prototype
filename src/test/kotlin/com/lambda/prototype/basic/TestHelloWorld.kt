package com.lambda.prototype.basic

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.LambdaLogger
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class TestHelloWorld {

    private val helloWorld = HelloWorld()

    private val mockContext = mock<Context>()
    private val mockLambdaLogger = mock<LambdaLogger>()

    @Before
    fun init() {
        whenever(mockContext.logger)
            .thenReturn(mockLambdaLogger)
    }

    @Test
    fun `HelloWorld#handleRequest should return the expected response when given a String input`() {
        val input = "some input"
        val result = helloWorld.handleRequest(input, mockContext)

        val expected = "Hello, $input!"
        assertEquals("The result should matched the expected.", expected, result)

        verify(mockLambdaLogger).log("Input: $input")
    }

    @Test
    fun `HelloWorld#handleRequest should return the expected response when given a non String input`() {
        val input = 0
        val result = helloWorld.handleRequest(input, mockContext)

        val expected = "Hello, $input!"
        assertEquals("The result should matched the expected.", expected, result)

        verify(mockLambdaLogger).log("Input: $input")
    }

}
