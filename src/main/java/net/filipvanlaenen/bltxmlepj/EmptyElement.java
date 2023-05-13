package net.filipvanlaenen.bltxmlepj;

/**
 * Abstract class providing common functionality for empty element types.
 *
 * @param <E> The subclass type.
 */
public abstract class EmptyElement<E extends EmptyElement<E>> extends AbstractElement<E> {
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
