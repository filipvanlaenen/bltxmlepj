package net.filipvanlaenen.bltxmlepj;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Unit tests on the <code>ElementWithAttributesAndMixedContent</code> class.
 */
public class ElementWithAttributesAndMixedContentTest {
    /**
     * Local subclass of <code>ElementWithAttributesAndMixedContent</code> for testing purposes.
     */
    private class MyElementWithAttributesAndMixedContent extends ElementWithAttributesAndMixedContent {
        @Override
        public String getElementName() {
            return "e";
        }
    }

    /**
     * Tests that an element without attributes or mixed content is exported correctly.
     */
    @Test
    void elementWithoutAttributesOrMixedContentIsExportedCorrectly() {
        MyElementWithAttributesAndMixedContent element = new MyElementWithAttributesAndMixedContent();
        assertEquals("<e/>", element.asString());
    }

    /**
     * Tests that an element with attributes is exported correctly.
     */
    @Test
    void elementWithAttributesIsExportedCorrectly() {
        MyElementWithAttributesAndMixedContent element = new MyElementWithAttributesAndMixedContent();
        element.addStringAttribute("bar", "baz");
        assertEquals("<e bar=\"baz\"/>", element.asString());
    }

    /**
     * Tests that an element with an element is exported correctly.
     */
    @Test
    void elementWithAnElementIsExportedCorrectly() {
        MyElementWithAttributesAndMixedContent element = new MyElementWithAttributesAndMixedContent();
        element.addElement(new MyElementWithAttributesAndMixedContent());
        assertEquals("<e>\n  <e/>\n</e>", element.asString());
    }

    /**
     * Tests that an element with content is exported correctly.
     */
    @Test
    void elementWithContentIsExportedCorrectly() {
        MyElementWithAttributesAndMixedContent element = new MyElementWithAttributesAndMixedContent();
        element.addContent("foo");
        assertEquals("<e>foo</e>", element.asString());
    }

    /**
     * Tests that an element with an element with content is exported correctly.
     */
    @Test
    void elementWithElementWithContentIsExportedCorrectly() {
        MyElementWithAttributesAndMixedContent element = new MyElementWithAttributesAndMixedContent();
        MyElementWithAttributesAndMixedContent subelement = new MyElementWithAttributesAndMixedContent();
        subelement.addContent("foo");
        element.addElement(subelement);
        assertEquals("<e>\n  <e>foo</e>\n</e>", element.asString());
    }

    /**
     * Tests that an element with mixed content is exported correctly.
     */
    @Test
    void elementWithMixedContentIsExportedCorrectly() {
        MyElementWithAttributesAndMixedContent element = new MyElementWithAttributesAndMixedContent();
        element.addContent("foo");
        element.addElement(new MyElementWithAttributesAndMixedContent());
        element.addContent("foo");
        assertEquals("<e>foo<e/>foo</e>", element.asString());
    }

    /**
     * Tests that an element with attributes and elements is exported correctly.
     */
    @Test
    void elementWithAttributesAndElementsIsExportedCorrectly() {
        MyElementWithAttributesAndMixedContent element = new MyElementWithAttributesAndMixedContent();
        element.addStringAttribute("bar", "baz");
        element.addElement(new MyElementWithAttributesAndMixedContent());
        assertEquals("<e bar=\"baz\">\n  <e/>\n</e>", element.asString());
    }
}
