package net.filipvanlaenen.bltxmlepj;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Unit tests on the <code>AbstractElementWithAttributes</code> interface.
 */
public class AbstractElementTest {
    /**
     * Local subclass of <code>AbstractElementWithAttributes</code> for testing purposes.
     */
    private static final class MyAbstractElementWithAttributes extends AbstractElement {
        @Override
        public String asString(final String indent) {
            return null;
        }

        @Override
        public String getElementName() {
            return null;
        }
    }

    /**
     * Verifies that a newly created Attributes instance is exported as an empty string.
     */
    @Test
    public void newAttributesInstanceShouldBeExportedAsAnEmptyString() {
        assertEquals("", new MyAbstractElementWithAttributes().getAttributesAsString());
    }

    /**
     * Verifies that when an attribute is added, the attributes instance is exported correctly.
     */
    @Test
    public void attributesWithAnAttributeShouldBeExportedCorrectly() {
        AbstractElement element = new MyAbstractElementWithAttributes();
        element.addStringAttribute("foo", "bar");
        assertEquals(" foo=\"bar\"", element.getAttributesAsString());
    }

    /**
     * Verifies that when many attributes are added, the attributes instance is exported correctly.
     */
    @Test
    public void attributesWithManyAttributesShouldBeExportedCorrectly() {
        AbstractElement element = new MyAbstractElementWithAttributes();
        element.addStringAttribute("foo", "bar");
        element.addStringAttribute("boo", "baz");
        element.addStringAttribute("shoo", "qux");
        assertEquals(" boo=\"baz\" foo=\"bar\" shoo=\"qux\"", element.getAttributesAsString());
    }

    /**
     * Tests that <code>xmlEscape</code> escapes correctly.
     */
    @Test
    void xmlEscapeEscapesCorrectly() {
        AbstractElement element = new MyAbstractElementWithAttributes();
        assertEquals("&amp;&lt;&gt;", element.xmlEscape("&<>"));
    }
}
