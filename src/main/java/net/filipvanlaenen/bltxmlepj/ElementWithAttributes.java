package net.filipvanlaenen.bltxmlepj;

/**
 * Abstract class providing common functionality for element types with
 * attributes.
 */

public abstract class ElementWithAttributes extends AbstractElementWithAttributes implements Element {
    @Override
    public final String asString(final String indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(indent);
        sb.append("<");
        sb.append(getElementName());
        sb.append(getAttributesAsString());
        sb.append("/>");
        return sb.toString();
    }
}
