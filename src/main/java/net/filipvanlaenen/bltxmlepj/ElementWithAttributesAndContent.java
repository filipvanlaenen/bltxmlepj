package net.filipvanlaenen.bltxmlepj;

/**
 * Abstract class providing common functionality for element types with
 * attributes and content.
 */

public abstract class ElementWithAttributesAndContent implements Element {
    /**
     * The attributes.
     */
    private final Attributes attributes = new Attributes();
    /**
     * The content.
     */
    private final String content;

    /**
     * Constructs an element with a string as its content.
     *
     * @param content
     *            A string.
     */
    protected ElementWithAttributesAndContent(final String content) {
        this.content = content;
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
        if (content == null || content.isEmpty()) {
            sb.append("/>");
        } else {
            sb.append(">");
            sb.append(xmlEscape(content));
            sb.append("</");
            sb.append(getElementName());
            sb.append(">");
        }
        return sb.toString();
    }
}
