package dev.manolovn.validateipaddress;

/**
 * source: https://leetcode.com/problems/validate-ip-address/
 * difficulty: MEDIUM
 * topics: STRINGS + ARRAYS
 */
public class ValidIPAddress {

    /**
     * Time:  O(n)
     * Space: O(1)
     */
    public String validIPAddress(String IP) {
        if (isIPv4(IP)) {
            return "IPv4";
        }
        if (isIPv6(IP)) {
            return "IPv6";
        }
        return "Neither";
    }

    private boolean isIPv4(String IP) {
        String[] parts = IP.split("\\.", -1);
        if (parts.length != 4) return false;
        for (String part : parts) {
            if (part.length() == 0 || part.length() > 3) return false;
            if (part.charAt(0) == '0' && part.length() != 1) return false;
            for (char c : part.toCharArray()) {
                if (!Character.isDigit(c)) return false;
            }
            if (Integer.parseInt(part) > 255) return false;
        }
        return true;
    }

    private boolean isIPv6(String IP) {
        String[] parts = IP.split(":", -1);
        if (parts.length != 8) return false;
        String hex = "0123456789abcdefABCDEF";
        for (String part : parts) {
            if (part.length() == 0 || part.length() > 4) return false;
            for (char c : part.toCharArray()) {
                if (hex.indexOf(c) == -1) return false;
            }
        }
        return true;
    }
}
