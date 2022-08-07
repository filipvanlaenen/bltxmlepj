package net.filipvanlaenen.bltxmlepj;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class providing common functionality for element types with attributes and mixed content.
 */
public abstract class ElementWithAttributesAndMixedContent extends AbstractElementWithAttributes implements Element {
    /**
     * A flag indicating whether the parts contain elements only.
     */
    private boolean containsElementsOnly = true;
    /**
     * A list with the parts.
     */
    private final List<Object> parts = new ArrayList<Object>();

    /**
     * Adds an element to the list of parts.
     *
     * @param element The element to be added.
     */
    protected final void addElement(final Element element) {
        parts.add(element);
    }

    /**
     * Adds string content to the list of parts.
     *
     * @param content The string content.
     */
    protected final void addContent(final String content) {
        parts.add(content);
        containsElementsOnly = false;
    }

    @Override
    public final String asString(final String indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(indent);
        sb.append("<");
        sb.append(getElementName());
        sb.append(getAttributesAsString());
        if (parts.isEmpty()) {
            sb.append("/>");
        } else {
            sb.append(">");
            if (containsElementsOnly) {
                sb.append("\n");
            }
            String nextIndent = containsElementsOnly ? "  " + indent : "";
            for (Object part : parts) {
                if (part instanceof String) {
                    sb.append(xmlEscape((String) part));
                } else {
                    sb.append(((Element) part).asString(nextIndent));
                    if (containsElementsOnly) {
                        sb.append("\n");
                    }
                }
            }
            sb.append(indent);
            sb.append("</");
            sb.append(getElementName());
            sb.append(">");
        }
        return sb.toString();
    }
}
