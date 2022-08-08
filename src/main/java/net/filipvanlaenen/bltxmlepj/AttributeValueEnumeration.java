package net.filipvanlaenen.bltxmlepj;

/**
 * Marker interface for enumerations defining a list of values for to be used as an attribute.
 */
public interface AttributeValueEnumeration {
    /**
     * Converts the attribute value to a string.
     *
     * @return A string representing the value.
     */
    default String asString() {
        String valueString = toString().toLowerCase();
        while (valueString.contains("_")) {
            int underscoreIndex = valueString.indexOf("_");
            String lowerCaseLetter = valueString.substring(underscoreIndex + 1, underscoreIndex + 2);
            String upperCaseLetter = lowerCaseLetter.toUpperCase();
            valueString = valueString.replaceAll("_" + lowerCaseLetter, upperCaseLetter);
        }
        return valueString;
    }
}
