package net.filipvanlaenen.bltxmlepj;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Unit tests on the <code>ElementWithAttributes</code> class.
 */
public class EmptyElementTest {
    /**
     * Local subclass of <code>ElementWithAttributes</code> for testing purposes.
     */
    private static final class MyElementWithAttributes extends EmptyElement {
        @Override
        public String getElementName() {
            return "e";
        }
    }

    /**
     * Tests that an element with an attribute but without content is exported
     * correctly.
     */
    @Test
    void elementWithAnAttributeButWithoutContentIsExportedCorrectly() {
        MyElementWithAttributes element = new MyElementWithAttributes();
        element.addStringAttribute("bar", "baz");
        assertEquals("<e bar=\"baz\"/>", element.asString());
    }

    /**
     * Tests that an element without content is exported correctly.
     */
    @Test
    void elementWithoutContentIsExportedCorrectly() {
        MyElementWithAttributes element = new MyElementWithAttributes();
        assertEquals("<e/>", element.asString());
    }
}
