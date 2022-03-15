package net.filipvanlaenen.bltxmlepj;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Unit tests on the <code>Element</code> interface.
 */
public class ElementTest {
    /**
     * Tests that <code>asString</code> uses no indent.
     */
    @Test
    void asStringUsesNoIndent() {
        Element element = new Element() {
            @Override
            public String asString(final String indent) {
                return indent + "foo";
            }

            @Override
            public String getElementName() {
                return null;
            }
        };
        assertEquals("foo", element.asString());
    }
}
