package net.filipvanlaenen.bltxmlepj;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Unit tests on the <code>ElementWithContent</code> class.
 */
public class ElementWithContentTest {
    /**
     * Local subclass of <code>ElementWithContent</code> for testing purposes.
     */
    private static final class MyElementWithContent extends ElementWithContent {
        /**
         * Constructs an element with a string as its content.
         *
         * @param content A string.
         */
        private MyElementWithContent(final String content) {
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
        ElementWithContent element = new MyElementWithContent("foo");
        element.addStringAttribute("bar", "baz");
        assertEquals("<e bar=\"baz\">foo</e>", element.asString());
    }

    /**
     * Tests that an element with an attribute but without content is exported correctly.
     */
    @Test
    void elementWithAnAttributeButWithoutContentIsExportedCorrectly() {
        ElementWithContent element = new MyElementWithContent(null);
        element.addStringAttribute("bar", "baz");
        assertEquals("<e bar=\"baz\"/>", element.asString());
    }

    /**
     * Tests that an element with content is exported correctly.
     */
    @Test
    void elementWithContentIsExportedCorrectly() {
        ElementWithContent element = new MyElementWithContent("foo");
        assertEquals("<e>foo</e>", element.asString());
    }

    /**
     * Tests that an element without content is exported correctly.
     */
    @Test
    void elementWithoutContentIsExportedCorrectly() {
        ElementWithContent element = new MyElementWithContent(null);
        assertEquals("<e/>", element.asString());
    }
}
