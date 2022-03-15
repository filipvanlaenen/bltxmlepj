package net.filipvanlaenen.bltxmlepj;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class providing common functionality for element types containing other elements.
 */
public abstract class ElementWithElements implements Element {
    /**
     * A list with the elements.
     */
    private final List<Element> elements = new ArrayList<Element>();

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
        if (elements.isEmpty()) {
            return indent + "<" + getElementName() + "/>";
        } else {
            List<String> elementStrings = new ArrayList<String>();
            String nextIndent = "  " + indent;
            for (Element element : elements) {
                elementStrings.add(element.asString(nextIndent));
            }
            return indent + "<" + getElementName() + ">\n" + String.join("\n", elementStrings) + "\n" + "</"
                    + getElementName() + ">";
        }
    }
}
