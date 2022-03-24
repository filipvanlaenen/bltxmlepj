package net.filipvanlaenen.bltxmlepj;

/**
 * A class representing a string attribute.
 */
public class StringAttribute implements Attribute {
    /**
     * The value of the attribute.
     */
    private final String string;

    /**
     * Constructs an attribute with a string value.
     *
     * @param string
     *            The string.
     */
    StringAttribute(final String string) {
        this.string = string;
    }

    /**
     * Converts the attribute value to a string.
     *
     * @return A string representing the value.
     */
    @Override
    public String asString() {
        return string;
    }
}
