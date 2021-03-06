package net.filipvanlaenen.bltxmlepj;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class providing common functionality for element types containing
 * other elements.
 */
public abstract class ElementWithElements implements Element {
    /**
     * A list with the elements.
     */
    private final List<Element> elements = new ArrayList<Element>();

    /**
     * Adds an element to the list of elements.
     *
     * @param element
     *            The element to be added.
     */
    protected final void addElement(final Element element) {
        elements.add(element);
    }

    @Override
    public final String asString(final String indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(indent);
        sb.append("<");
        sb.append(getElementName());
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
