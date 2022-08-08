package net.filipvanlaenen.bltxmlepj;

/**
 * A class representing an enumeration attribute.
 *
 * @param <E> The enumeration type.
 */
public class EnumerationAttribute<E extends AttributeValueEnumeration> implements Attribute {
    /**
     * The value of the attribute.
     */
    private final E value;

    /**
     * Constructs an attribute with an attribute value enumeration value.
     *
     * @param value The value of the attribute.
     */
    public EnumerationAttribute(final E value) {
        this.value = value;
    }

    /**
     * Converts the attribute value to a string.
     *
     * @return A string representing the value.
     */
    @Override
    public String asString() {
        return value.asString();
    }
}
