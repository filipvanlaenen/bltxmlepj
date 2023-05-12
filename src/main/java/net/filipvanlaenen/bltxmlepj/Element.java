package net.filipvanlaenen.bltxmlepj;

/**
 * Top interface for all element types.
 */
public interface Element {
    /**
     * Returns a string representation of the element.
     *
     * @return A string representation of the element.
     */
    default String asString() {
        return asString("");
    }

    /**
     * Returns a string representation of the element with the provided indentation.
     *
     * @param indent The indentation.
     * @return A string representation of the element with the provided indentation.
     */
    String asString(String indent);

    /**
     * Returns the name of the element.
     *
     * @return The name of the element.
     */
    String getElementName();
}
