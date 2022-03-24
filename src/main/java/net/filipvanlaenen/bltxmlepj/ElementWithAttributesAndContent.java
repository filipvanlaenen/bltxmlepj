package net.filipvanlaenen.bltxmlepj;

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
        if (content == null || content.isEmpty()) {
            return indent + "<" + getElementName() + attributes.asString() + "/>";
        } else {
            return indent + "<" + getElementName() + attributes.asString() + ">" + xmlEscape(content) + "</"
                    + getElementName() + ">";
        }
    }

    /**
     * Escape special XML characters in a string. The special XML characters that
     * will be escaped are <code>&lt;</code>, <code>&gt;</code> and
     * <code>&amp;</code>.
     *
     * @param string
     *            The original text.
     * @return The text with special XML characters escaped.
     */
    private String xmlEscape(final String string) {
        return string.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;");
    }
}
