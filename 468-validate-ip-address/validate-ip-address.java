class Solution {
    public String validIPAddress(String ip) {

        if (ip.contains(".")) {

         String[] parts = ip.split("\\.", -1);

            if (parts.length != 4)
                return "Neither";

            for (String s : parts) {

                if (s.isEmpty())
                    return "Neither";

                if (s.length() > 1 && s.charAt(0) == '0')
                    return "Neither";

                if (s.length() > 3)
                    return "Neither";

                for (char c : s.toCharArray()) {
                    if (!Character.isDigit(c))
                        return "Neither";
                }

                if (Integer.parseInt(s) > 255)
                    return "Neither";
            }

            return "IPv4";
        }

        if (ip.contains(":")) {

            String[] parts = ip.split(":", -1);

            if (parts.length != 8)
                return "Neither";

            for (String s : parts) {

                if (s.length() < 1 || s.length() > 4)
                    return "Neither";

                for (char c : s.toCharArray()) {
                    if (!Character.isDigit(c) &&
                        !(c >= 'a' && c <= 'f') &&
                        !(c >= 'A' && c <= 'F'))
                        return "Neither";
                }
            }

            return "IPv6";
        }

        return "Neither";
    }
}