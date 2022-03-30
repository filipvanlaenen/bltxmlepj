package net.filipvanlaenen.bltxmlepj;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Unit tests on the <code>EnumerationAttribute</code> class.
 */
public class EnumerationAttributeTest {
    /**
     * Local enumeration for testing purposes.
     */
    private enum MyEnumeration implements AttributeValueEnumeration {
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
        assertEquals("foo", new EnumerationAttribute<MyEnumeration>(MyEnumeration.FOO).asString());
    }

    /**
     * Verifies that a composed enumeration value is exported correctly.
     */
    @Test
    public void shouldExportAComposedEnumerationValueCorrectly() {
        assertEquals("fooBar", new EnumerationAttribute<MyEnumeration>(MyEnumeration.FOO_BAR).asString());
    }
}
