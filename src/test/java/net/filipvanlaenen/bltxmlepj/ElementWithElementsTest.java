package net.filipvanlaenen.bltxmlepj;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Unit tests on the <code>ElementWithElements</code> class.
 */
public class ElementWithElementsTest {
    /**
     * Local subclass of <code>ElementWithElements</code> for testing purposes.
     */
    private class MyElementWithElements extends ElementWithElements {
        @Override
        public String getElementName() {
            return "e";
        }
    }

    /**
     * Tests that an element without attributes or elements is exported correctly.
     */
    @Test
    void elementWithoutAttributesOrElementsIsExportedCorrectly() {
        MyElementWithElements element = new MyElementWithElements();
        assertEquals("<e/>", element.asString());
    }

    /**
     * Tests that an element with attributes is exported correctly.
     */
    @Test
    void elementWithAttributesIsExportedCorrectly() {
        MyElementWithElements element = new MyElementWithElements();
        element.addStringAttribute("bar", "baz");
        assertEquals("<e bar=\"baz\"/>", element.asString());
    }

    /**
     * Tests that an element with elements is exported correctly.
     */
    @Test
    void elementWithElementsIsExportedCorrectly() {
        MyElementWithElements element = new MyElementWithElements();
        element.addElement(new MyElementWithElements());
        assertEquals("<e>\n  <e/>\n</e>", element.asString());
    }

    /**
     * Tests that an element with attributes and elements is exported correctly.
     */
    @Test
    void elementWithAttributesAndElementsIsExportedCorrectly() {
        MyElementWithElements element = new MyElementWithElements();
        element.addStringAttribute("bar", "baz");
        element.addElement(new MyElementWithElements());
        assertEquals("<e bar=\"baz\">\n  <e/>\n</e>", element.asString());
    }
}
