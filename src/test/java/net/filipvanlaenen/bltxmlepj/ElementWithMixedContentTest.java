package net.filipvanlaenen.bltxmlepj;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Unit tests on the <code>ElementWithMixedContent</code> class.
 */
public class ElementWithMixedContentTest {
    /**
     * Local subclass of <code>ElementWithMixedContent</code> for testing purposes.
     */
    private class MyElementWithMixedContent extends ElementWithMixedContent {
        @Override
        public String getElementName() {
            return "e";
        }
    }

    /**
     * Tests that an element without mixed content is exported correctly.
     */
    @Test
    void elementWithoutMixedContentIsExportedCorrectly() {
        MyElementWithMixedContent element = new MyElementWithMixedContent();
        assertEquals("<e/>", element.asString());
    }

    /**
     * Tests that an element with an element is exported correctly.
     */
    @Test
    void elementWithAnElementIsExportedCorrectly() {
        MyElementWithMixedContent element = new MyElementWithMixedContent();
        element.addElement(new MyElementWithMixedContent());
        assertEquals("<e>\n  <e/>\n</e>", element.asString());
    }

    /**
     * Tests that an element with content is exported correctly.
     */
    @Test
    void elementWithContentIsExportedCorrectly() {
        MyElementWithMixedContent element = new MyElementWithMixedContent();
        element.addContent("foo");
        assertEquals("<e>foo</e>", element.asString());
    }

    /**
     * Tests that an element with an element with content is exported correctly.
     */
    @Test
    void elementWithElementWithContentIsExportedCorrectly() {
        MyElementWithMixedContent element = new MyElementWithMixedContent();
        MyElementWithMixedContent subelement = new MyElementWithMixedContent();
        subelement.addContent("foo");
        element.addElement(subelement);
        assertEquals("<e>\n  <e>foo</e>\n</e>", element.asString());
    }

    /**
     * Tests that an element with mixed content is exported correctly.
     */
    @Test
    void elementWithMixedContentIsExportedCorrectly() {
        MyElementWithMixedContent element = new MyElementWithMixedContent();
        element.addContent("foo");
        element.addElement(new MyElementWithMixedContent());
        element.addContent("foo");
        assertEquals("<e>foo<e/>foo</e>", element.asString());
    }
}
