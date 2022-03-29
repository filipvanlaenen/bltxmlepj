package net.filipvanlaenen.bltxmlepj;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class providing common functionality for element types with
 * attributes and elements.
 */

public abstract class ElementWithAttributesAndElements implements Element {
    /**
     * The attributes.
     */
    private final Attributes attributes = new Attributes();
    /**
     * A list with the elements.
     */
    private final List<Element> elements = new ArrayList<Element>();

    /**
     * Adds an attribute to the set of attributes.
     *
     * @param name
     *            The name of the attribute.
     * @param attribute
     *            The the attribute.
     */
    protected void addAttribute(final String name, final Attribute attribute) {
        attributes.addAttribute(name, attribute);
    }

    /**
     * Adds an element to the list of elements.
     *
     * @param element
     *            The element to be added.
     */
    protected final void addElement(final Element element) {
        elements.add(element);
    }

    /**
     * Adds an enumeration attribute to the set of attributes.
     *
     * @param name
     *            The name of the attribute.
     * @param value
     *            The enumeration value of the attribute.
     */
    protected <E extends AttributeValueEnumeration> void addEnumerationAttribute(final String name, final E value) {
        attributes.addEnumerationAttribute(name, value);
    }

    /**
     * Adds a numeric attribute to the set of attributes.
     *
     * @param name
     *            The name of the attribute.
     * @param number
     *            The number value of the attribute.
     */
    protected void addNumericAttribute(final String name, final Number number) {
        attributes.addNumericAttribute(name, number);
    }

    /**
     * Adds a string attribute to the set of attributes.
     *
     * @param name
     *            The name of the attribute.
     * @param string
     *            The string value of the attribute.
     */
    protected void addStringAttribute(final String name, final String string) {
        attributes.addStringAttribute(name, string);
    }

    @Override
    public final String asString(final String indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(indent);
        sb.append("<");
        sb.append(getElementName());
        sb.append(attributes.asString());
        if (elements.isEmpty()) {
            sb.append("/>");
        } else {
            sb.append(">\n");
            String nextIndent = "  " + indent;
            for (Element element : elements) {
                sb.append(element.asString(nextIndent));
                sb.append("\n");
            }
            sb.append(indent);
            sb.append("</");
            sb.append(getElementName());
            sb.append(">");
        }
        return sb.toString();
    }
}
