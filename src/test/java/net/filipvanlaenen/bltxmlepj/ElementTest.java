package net.filipvanlaenen.bltxmlepj;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Unit tests on the <code>Element</code> interface.
 */
public class ElementTest {
    /**
     * Test verifying that a simple paragraph with text is exported correctly.
     */
    @Test
    void simplePWithTextIsConvertedCorrectlyToString() {
        Element element = new Element() {
            @Override
            public String asString(String indent) {
                return indent + "foo";
            }
        };
        assertEquals("foo", element.asString());
    }
}
