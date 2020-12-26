public class Solution {
    public String validIPAddress(String IP) {
        if (IP.isEmpty() || IP.startsWith(".") || IP.startsWith(":") || IP.endsWith(".") || IP.endsWith(":")) {
            return "Neither";
        }
        
        if (IP.contains(".")) {
            String[] ss = IP.split("\\.");
            if (ss.length != 4) {
                return "Neither";
            }
            
            for (int i = 0; i < ss.length; i++) {
                String s = ss[i];
                if (s.length() > 1 && s.charAt(0) == '0') {
                    return "Neither";
                }
                if (s.isEmpty()) {
                    return "Neither";
                }
                
                int n = 0;
                for (int j = 0; j < s.length(); j++) {
                    char ch = s.charAt(j);
                    if (!Character.isDigit(ch)) {
                        return "Neither";
                    }
                    
                    n = n * 10 + ch - '0';
                }
                
                if (n < 0 || n > 255) {
                    return "Neither";
                }
            }
            
            return "IPv4";
        } else if (IP.contains(":")) {
            String[] ss = IP.split(":");
            if (ss.length != 8) {
                return "Neither";
            }
            
            for (int i = 0; i < ss.length; i++) {
                String s = ss[i];
                if (s.length() < 1 || s.length() > 4) {
                    return "Neither";
                }
                if (s.isEmpty()) {
                    return "Neither";
                }
                
                for (int j = 0; j < s.length(); j++) {
                    char ch = s.charAt(j);
                    if (!('0' <= ch && ch <= '9') && !('a' <= ch && ch <= 'f') && !('A' <= ch && ch <= 'F')) {
                        return "Neither";
                    }
                }
            }
            
            return "IPv6";
        }
        
        return "";
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().validIPAddress("172.16.254.1"));
        // System.out.println(new Solution().validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
        System.out.println(new Solution().validIPAddress("12..33.4"));
    }
}
