import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class ValidatorTest {
    @ParameterizedTest(name = "when equation is \"{0}\", result should be \"{1}\"")
    @MethodSource("testValues")
    fun `Properly validates equation`(equationString: String, expectedResult: String) {
        val result = validate(equationString)
        assertEquals(expectedResult, result)
    }

    companion object {
        @JvmStatic
        fun testValues(): List<Arguments> {
            return listOf(
                Arguments.of("1 + 2 = 3", "valid"),
                Arguments.of("2 + 1 = 3", "valid"),
                Arguments.of("1+2=3", "valid"),
                Arguments.of("1 + 2 = 5", "invalid"),
                Arguments.of("2 + 1 = 5", "invalid"),
                Arguments.of("1+2=5", "invalid"),
                Arguments.of("not an equation", "syntax error"),
                Arguments.of("", "syntax error"),
                Arguments.of("1 + 2 + 3 = 6", "syntax error"),
                Arguments.of("1 - 2 = 3", "syntax error"),
                Arguments.of("2 - 1 = 1", "syntax error"),
                Arguments.of("2-1=1", "syntax error"),
                Arguments.of("a + b = c", "syntax error"),
                Arguments.of("a+b=c", "syntax error"),
            )
        }
    }
}
