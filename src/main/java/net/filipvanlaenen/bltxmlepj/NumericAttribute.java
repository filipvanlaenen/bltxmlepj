package net.filipvanlaenen.bltxmlepj;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * A class representing a numeric attribute.
 */
public class NumericAttribute implements Attribute {
    /**
     * The decimal format.
     */
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.######",
            DecimalFormatSymbols.getInstance(Locale.US));
    /**
     * The value of the attribute.
     */
    private final Number number;

    /**
     * Constructs an attribute with a numeric value.
     *
     * @param number
     *            The number.
     */
    NumericAttribute(final Number number) {
        this.number = number;
    }

    /**
     * Converts the attribute value to a string.
     *
     * @return A string representing the value.
     */
    @Override
    public String asString() {
        return DECIMAL_FORMAT.format(number);
    }
}
