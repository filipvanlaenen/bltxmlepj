package net.filipvanlaenen.bltxmlepj;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Unit tests on the <code>ElementWithAttributesAndContent</code> class.
 */
public class ElementWithAttributesAndContentTest {
    /**
     * Local subclass of <code>ElementWithAttributesAndContent</code> for testing
     * purposes.
     */
    private static final class MyElementWithAttributesAndContent extends ElementWithAttributesAndContent {
        /**
         * Constructs an element with a string as its content.
         *
         * @param content
         *            A string.
         */
        private MyElementWithAttributesAndContent(final String content) {
            super(content);
        }

        @Override
        public String getElementName() {
            return "e";
        }
    }

    /**
     * Tests that an element with an attribute and content is exported correctly.
     */
    @Test
    void elementWithAnAttributeAndContentIsExportedCorrectly() {
        ElementWithAttributesAndContent element = new MyElementWithAttributesAndContent("foo");
        element.addStringAttribute("bar", "baz");
        assertEquals("<e bar=\"baz\">foo</e>", element.asString());
    }

    /**
     * Tests that an element with an attribute but without content is exported correctly.
     */
    @Test
    void elementWithAnAttributeButWithoutContentIsExportedCorrectly() {
        ElementWithAttributesAndContent element = new MyElementWithAttributesAndContent(null);
        element.addStringAttribute("bar", "baz");
        assertEquals("<e bar=\"baz\"/>", element.asString());
    }

    /**
     * Tests that an element with content is exported correctly.
     */
    @Test
    void elementWithContentIsExportedCorrectly() {
        ElementWithAttributesAndContent element = new MyElementWithAttributesAndContent("foo");
        assertEquals("<e>foo</e>", element.asString());
    }

    /**
     * Tests that an element without content is exported correctly.
     */
    @Test
    void elementWithoutContentIsExportedCorrectly() {
        ElementWithAttributesAndContent element = new MyElementWithAttributesAndContent(null);
        assertEquals("<e/>", element.asString());
    }
}
