package net.filipvanlaenen.bltxmlepj;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Unit tests on the <code>StringAttribute</code> class.
 */
public class StringAttributeTest {
    /**
     * Verifies that a string is exported correctly.
     */
    @Test
    public void shouldExportAStringCorrectly() {
        assertEquals("Foo", new StringAttribute("Foo").asString());
    }
}
