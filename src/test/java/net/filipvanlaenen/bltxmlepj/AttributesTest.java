package net.filipvanlaenen.bltxmlepj;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Unit tests on the <code>Attributes</code> interface.
 */
public class AttributesTest {
    /**
     * Verifies that a newly created Attributes instance is empty.
     */
    @Test
    public void newAttributesInstanceShouldBeEmpty() {
        assertTrue(new Attributes().isEmpty());
    }

    /**
     * Verifies that when an attribute is added, the attributes instance isn't empty
     * any more.
     */
    @Test
    public void attributesWithAnAttributeShouldNotBeEmpty() {
        Attributes attributes = new Attributes();
        attributes.addStringAttribute("foo", "bar");
        assertFalse(attributes.isEmpty());
    }

    /**
     * Verifies that a newly created Attributes instance is exported as an empty
     * string.
     */
    @Test
    public void newAttributesInstanceShouldBeExportedAsAnEmptyString() {
        assertEquals("", new Attributes().asString());
    }

    /**
     * Verifies that when an attribute is added, the attributes instance is exported
     * correctly.
     */
    @Test
    public void attributesWithAnAttributeShouldBeExportedCorrectly() {
        Attributes attributes = new Attributes();
        attributes.addStringAttribute("foo", "bar");
        assertEquals(" foo=\"bar\"", attributes.asString());
    }

    /**
     * Verifies that when many attributes are added, the attributes instance is
     * exported correctly.
     */
    @Test
    public void attributesWithManyAttributesShouldBeExportedCorrectly() {
        Attributes attributes = new Attributes();
        attributes.addStringAttribute("foo", "bar");
        attributes.addStringAttribute("boo", "baz");
        attributes.addStringAttribute("shoo", "qux");
        assertEquals(" boo=\"baz\" foo=\"bar\" shoo=\"qux\"", attributes.asString());
    }
}
