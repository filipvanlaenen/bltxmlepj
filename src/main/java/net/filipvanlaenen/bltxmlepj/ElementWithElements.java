package net.filipvanlaenen.bltxmlepj;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class providing common functionality for element types with elements.
 */
public abstract class ElementWithElements extends AbstractElement {
    /**
     * A list with the elements.
     */
    private final List<AbstractElement> elements = new ArrayList<AbstractElement>();

    /**
     * Adds an element to the list of elements.
     *
     * @param element The element to be added.
     */
    protected final void addElement(final AbstractElement element) {
        elements.add(element);
    }

    @Override
    public final String asString(final String indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(indent);
        sb.append("<");
        sb.append(getElementName());
        sb.append(getAttributesAsString());
        if (elements.isEmpty()) {
            sb.append("/>");
        } else {
            sb.append(">\n");
            String nextIndent = "  " + indent;
            for (AbstractElement element : elements) {
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
