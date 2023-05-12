package net.filipvanlaenen.bltxmlepj;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Unit tests on the <code>EmptyElement</code> class.
 */
public class EmptyElementTest {
    /**
     * Local subclass of <code>EmptyElement</code> for testing purposes.
     */
    private static final class MyEmptyElement extends EmptyElement {
        @Override
        public String getElementName() {
            return "e";
        }
    }

    /**
     * Tests that an element with an attribute but without content is exported correctly.
     */
    @Test
    void elementWithAnAttributeButWithoutContentIsExportedCorrectly() {
        MyEmptyElement element = new MyEmptyElement();
        element.addStringAttribute("bar", "baz");
        assertEquals("<e bar=\"baz\"/>", element.asString());
    }

    /**
     * Tests that an element without content is exported correctly.
     */
    @Test
    void elementWithoutContentIsExportedCorrectly() {
        MyEmptyElement element = new MyEmptyElement();
        assertEquals("<e/>", element.asString());
    }
}
