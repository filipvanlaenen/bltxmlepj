package net.filipvanlaenen.bltxmlepj;

public class EnumerationAttribute<E extends AttributeValueEnumeration> implements Attribute {
    /**
     * The value of the attribute.
     */
    private final E value;

    /**
     * Constructs an attribute with an attribute value enumeration value.
     *
     * @param value
     *            The value of the attribute.
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
        String valueString = value.toString().toLowerCase();
        while (valueString.contains("_")) {
            int underscoreIndex = valueString.indexOf("_");
            String lowerCaseLetter = valueString.substring(underscoreIndex + 1, underscoreIndex + 2);
            String upperCaseLetter = lowerCaseLetter.toUpperCase();
            valueString = valueString.replaceAll("_" + lowerCaseLetter, upperCaseLetter);
        }
        return valueString;
    }
}
