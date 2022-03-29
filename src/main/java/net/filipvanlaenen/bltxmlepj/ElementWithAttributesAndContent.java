package net.filipvanlaenen.bltxmlepj;

/**
 * Abstract class providing common functionality for element types with
 * attributes and content.
 */

public abstract class ElementWithAttributesAndContent extends AbstractElementWithAttributes implements Element {
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

    @Override
    public final String asString(final String indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(indent);
        sb.append("<");
        sb.append(getElementName());
        sb.append(getAttributesAsString());
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
