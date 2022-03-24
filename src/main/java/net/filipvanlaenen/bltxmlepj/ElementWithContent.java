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
}
