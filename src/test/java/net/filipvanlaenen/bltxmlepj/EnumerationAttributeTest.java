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
    private enum MyEnumeration implements CamelCaseAttributeValueEnumeration {
        /**
         * Simple value.
         */
        FOO
    }

    /**
     * Verifies that an enumeration value is exported correctly.
     */
    @Test
    public void shouldExportAnEnumerationValueCorrectly() {
        assertEquals("foo", new EnumerationAttribute<MyEnumeration>(MyEnumeration.FOO).asString());
    }
}
