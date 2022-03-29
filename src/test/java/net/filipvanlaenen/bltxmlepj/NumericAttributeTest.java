package net.filipvanlaenen.bltxmlepj;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Unit tests on the <code>NumericAttribute</code> class.
 */
public class NumericAttributeTest {
    /**
     * Magic floating point number 1.1.
     */
    private static final float FLOAT_1_1 = 1.1F;
    /**
     * Magic floating point number 1.123456789.
     */
    private static final float FLOAT_1_123456789 = 1.123456789F;

    /**
     * Verifies that an integer number is exported correctly.
     */
    @Test
    public void shouldExportAnIntegerNumberCorrectly() {
        assertEquals("1", new NumericAttribute(1).asString());
    }

    /**
     * Verifies that a floating point number with one digit behind the point is
     * exported correctly.
     */
    @Test
    public void shouldExportAFloatWithOneDigitBehindThePointCorrectly() {
        assertEquals("1.1", new NumericAttribute(FLOAT_1_1).asString());
    }

    /**
     * Verifies that a floating point number with many digits behind the point is
     * exported correctly.
     */
    @Test
    public void shouldExportAFloatWithManyDigitsBehindThePointCorrectly() {
        assertEquals("1.123457", new NumericAttribute(FLOAT_1_123456789).asString());
    }
}
