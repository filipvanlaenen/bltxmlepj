package net.filipvanlaenen.bltxmlepj;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Unit tests on the <code>KebabCaseAttributeValueEnumeration</code> class.
 */
public class KebabCaseAttributeValueEnumerationTest {
    /**
     * Local enumeration for testing purposes.
     */
    private enum MyEnumeration implements KebabCaseAttributeValueEnumeration {
        /**
         * Simple value.
         */
        FOO,
        /**
         * Composed value.
         */
        FOO_BAR
    }

    /**
     * Verifies that an enumeration value is exported correctly.
     */
    @Test
    public void shouldExportAnEnumerationValueCorrectly() {
        assertEquals("foo", MyEnumeration.FOO.asString());
    }

    /**
     * Verifies that a composed enumeration value is exported correctly.
     */
    @Test
    public void shouldExportAComposedEnumerationValueCorrectly() {
        assertEquals("foo-bar", MyEnumeration.FOO_BAR.asString());
    }
}
