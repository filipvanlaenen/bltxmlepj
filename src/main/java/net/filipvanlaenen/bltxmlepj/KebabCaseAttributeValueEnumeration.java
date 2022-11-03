package net.filipvanlaenen.bltxmlepj;

/**
 * Interface for enumerations defining a list of values for to be used as an attribute with a string representation
 * using kebab case.
 */
public interface KebabCaseAttributeValueEnumeration extends AttributeValueEnumeration {
    /**
     * Converts the attribute value to a string.
     *
     * @return A string representing the value.
     */
    default String asString() {
        return toString().toLowerCase().replaceAll("_", "-");
    }
}
