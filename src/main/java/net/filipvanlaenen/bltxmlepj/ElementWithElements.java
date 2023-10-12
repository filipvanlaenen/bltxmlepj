package net.filipvanlaenen.bltxmlepj;

import net.filipvanlaenen.kolektoj.ModifiableOrderedCollection;

/**
 * Abstract class providing common functionality for element types with elements.
 *
 * @param <E> The subclass type.
 */
public abstract class ElementWithElements<E extends ElementWithElements<E>> extends AbstractElement<E> {
    /**
     * A list with the elements.
     */
    private final ModifiableOrderedCollection<Element> elements = ModifiableOrderedCollection.empty();

    /**
     * Adds an element to the list of elements.
     *
     * @param element The element to be added.
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
        sb.append(getAttributesAsString());
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
