package dev.manolovn.validateipaddress;

/**
 * Validate an IP address (IPv4)
 * -----------------------------
 * An address is valid if and only if it is in the form "X.X.X.X", where each X is a number from 0 to 255.
 */
public class ValidateIpAddress {

    /**
     * Space complexity O(n)
     * Time complexity O(n)
     */
    static boolean validateIP(String ip) {
        String[] parts = ip.split("\\.");
        if (parts.length > 4) return false;

        for (String part : parts) {
            int c;
            try {
                c = Integer.parseInt(part);
            } catch (Exception e) {
                return false;
            }
            if (c > 255) return false;
        }

        return true;
    }
}
