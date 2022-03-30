package net.filipvanlaenen.bltxmlepj;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Unit tests on the <code>ElementWithAttributesAndElements</code> class.
 */
public class ElementWithAttributesAndElementsTest {
    /**
     * Local subclass of <code>ElementWithAttributesAndElements</code> for testing
     * purposes.
     */
    private class MyElementWithAttributesAndElements extends ElementWithAttributesAndElements {
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
        MyElementWithAttributesAndElements element = new MyElementWithAttributesAndElements();
        assertEquals("<e/>", element.asString());
    }

    /**
     * Tests that an element with attributes is exported correctly.
     */
    @Test
    void elementWithAttributesIsExportedCorrectly() {
        MyElementWithAttributesAndElements element = new MyElementWithAttributesAndElements();
        element.addStringAttribute("bar", "baz");
        assertEquals("<e bar=\"baz\"/>", element.asString());
    }

    /**
     * Tests that an element with elements is exported correctly.
     */
    @Test
    void elementWithElementsIsExportedCorrectly() {
        MyElementWithAttributesAndElements element = new MyElementWithAttributesAndElements();
        element.addElement(new MyElementWithAttributesAndElements());
        assertEquals("<e>\n  <e/>\n</e>", element.asString());
    }

    /**
     * Tests that an element with attributes and elements is exported correctly.
     */
    @Test
    void elementWithAttributesAndElementsIsExportedCorrectly() {
        MyElementWithAttributesAndElements element = new MyElementWithAttributesAndElements();
        element.addStringAttribute("bar", "baz");
        element.addElement(new MyElementWithAttributesAndElements());
        assertEquals("<e bar=\"baz\">\n  <e/>\n</e>", element.asString());
    }
}
