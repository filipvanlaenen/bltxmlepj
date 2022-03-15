package net.filipvanlaenen.bltxmlepj;

/**
 * Abstract class providing common functionality for element types with content.
 */
public abstract class ElementWithContent implements Element {
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
    protected ElementWithContent(final String content) {
        this.content = content;
    }

    @Override
    public final String asString(final String indent) {
        if (content == null || content.isEmpty()) {
            return indent + "<" + getElementName() + "/>";
        } else {
            return indent + "<" + getElementName() + ">" + xmlEscape(content) + "</" + getElementName() + ">";
        }
    }

    /**
     * Returns the name of the element.
     *
     * @return The name of the element.
     */
    protected abstract String getElementName();

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
