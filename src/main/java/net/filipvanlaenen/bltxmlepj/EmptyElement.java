package net.filipvanlaenen.bltxmlepj;

/**
 * Abstract class providing common functionality for empty element types.
 */
public abstract class EmptyElement extends AbstractElement {
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
