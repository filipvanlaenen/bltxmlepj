package net.filipvanlaenen.bltxmlepj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * A class helping to export attributes from XML elements to a string.
 */
class Attributes {
    /**
     * A map with all the attributes.
     */
    private final Map<String, Attribute> attributes = new HashMap<String, Attribute>();

    /**
     * Adds a string attribute to the set of attributes.
     *
     * @param name
     *            The name of the attribute.
     * @param string
     *            The string value of the attribute.
     */
    void addStringAttribute(final String name, final String string) {
        attributes.put(name, new StringAttribute(string));
    }

    /**
     * Converts the set of attributes into a string.
     *
     * @return A string representing all the attributes.
     */
    String asString() {
        if (isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Set<String> attributeNameSet = new HashSet<String>();
        attributeNameSet.addAll(attributes.keySet());
        List<String> attributeNameList = new ArrayList<String>(attributeNameSet);
        Collections.sort(attributeNameList);
        for (String attributeName : attributeNameList) {
            sb.append(" ");
            sb.append(attributeName);
            sb.append("=\"");
            sb.append(xmlEscape(attributes.get(attributeName).asString()));
            sb.append("\"");
        }
        return sb.toString();
    }

    /**
     * Returns whether the set of attributes is empty.
     *
     * @return True if the set of attributes is empty, false otherwise.
     */
    boolean isEmpty() {
        return attributes.isEmpty();
    }

    private String xmlEscape(final String string) {
        return string.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\"",
                "&quot;");
    }
}
