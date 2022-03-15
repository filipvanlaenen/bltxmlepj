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
        /**
         * Adds an element with elements.
         *
         * @param myElementWithElements The element with elements to be added.
         */
        void addElement(final MyElementWithElements myElementWithElements) {
            super.addElement(myElementWithElements);
        }

        @Override
        public String getElementName() {
            return "e";
        }
    }

    /**
     * Tests that an element without elements is exported correctly.
     */
    @Test
    void elementWithoutElementsIsExportedCorrectly() {
        ElementWithElements element = new MyElementWithElements();
        assertEquals("<e/>", element.asString());
    }

    /**
     * Tests that an element with an element is exported correctly.
     */
    @Test
    void elementWithElementIsExportedCorrectly() {
        MyElementWithElements element = new MyElementWithElements();
        element.addElement(new MyElementWithElements());
        assertEquals("<e>\n  <e/>\n</e>", element.asString());
    }
}
