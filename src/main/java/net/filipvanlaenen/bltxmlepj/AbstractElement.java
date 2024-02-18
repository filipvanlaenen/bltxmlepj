package net.filipvanlaenen.bltxmlepj;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.ModifiableMap;
import net.filipvanlaenen.kolektoj.OrderedCollection;
import net.filipvanlaenen.kolektoj.sortedtree.SortedTreeCollection;

/**
 * Abstract base class for all element classes.
 *
 * @param <E> The subclass type.
 */
abstract class AbstractElement<E extends AbstractElement<E>> implements Element {
    /**
     * A map with all the attributes.
     */
    private final ModifiableMap<String, Attribute> attributes = ModifiableMap.empty();

    /**
     * Adds an attribute to the set of attributes.
     *
     * @param name      The name of the attribute.
     * @param attribute The the attribute.
     */
    protected void addAttribute(final String name, final Attribute attribute) {
        attributes.put(name, attribute);
    }

    /**
     * Adds an enumeration attribute to the set of attributes.
     *
     * @param name  The name of the attribute.
     * @param value The enumeration value of the attribute.
     * @param <AVE> The enumeration type.
     */
    protected <AVE extends AttributeValueEnumeration> void addEnumerationAttribute(final String name, final AVE value) {
        attributes.put(name, new EnumerationAttribute<AVE>(value));
    }

    /**
     * Adds a numeric attribute to the set of attributes.
     *
     * @param name   The name of the attribute.
     * @param number The number value of the attribute.
     */
    protected void addNumericAttribute(final String name, final Number number) {
        attributes.put(name, new NumericAttribute(number));
    }

    /**
     * Adds a string attribute to the set of attributes.
     *
     * @param name   The name of the attribute.
     * @param string The string value of the attribute.
     */
    protected void addStringAttribute(final String name, final String string) {
        attributes.put(name, new StringAttribute(string));
    }

    /**
     * Returns the attributes as a string.
     *
     * @return A string representation of the attributes.
     */
    protected String getAttributesAsString() {
        if (attributes.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        OrderedCollection<String> attributeNames =
                new SortedTreeCollection<String>(Comparator.naturalOrder(), attributes.getKeys());
        for (String attributeName : attributeNames) {
            sb.append(" ");
            sb.append(attributeName);
            sb.append("=\"");
            sb.append(xmlEscape(attributes.get(attributeName).asString()));
            sb.append("\"");
        }
        return sb.toString();
    }

    /**
     * Sets the ID.
     *
     * @param id The ID.
     * @return The instance called.
     */
    public E id(final String id) {
        addStringAttribute("id", id);
        return (E) this;
    }

    /**
     * Escape special XML characters in a string. The special XML characters that will be escaped are <code>&lt;</code>,
     * <code>&gt;</code> and <code>&amp;</code>.
     *
     * @param string The original text.
     * @return The text with special XML characters escaped.
     */
    protected String xmlEscape(final String string) {
        return string.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;");
    }
}
