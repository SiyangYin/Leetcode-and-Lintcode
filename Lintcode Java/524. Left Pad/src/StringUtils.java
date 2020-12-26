public class StringUtils {
    /**
     * @param originalStr: the string we want to append to with spaces
     * @param size: the target length of the string
     * @return: A string
     */
    static public String leftPad(String originalStr, int size) {
        // Write your code here
        if (originalStr == null || originalStr.isEmpty() || originalStr.length() >= size) {
            return originalStr;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size - originalStr.length(); i++) {
            sb.append(' ');
        }
        
        return sb.append(originalStr).toString();
    }
    
    /*
     * @param originalStr: the string we want to append to
     * @param size: the target length of the string
     * @param padChar: the character to pad to the left side of the string
     * @return: A string
     */
    static public String leftPad(String originalStr, int size, char padChar) {
        // write your code here
        if (originalStr == null || originalStr.isEmpty() || originalStr.length() >= size) {
            return originalStr;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size - originalStr.length(); i++) {
            sb.append(padChar);
        }
        
        return sb.append(originalStr).toString();
    }
    
    public static void main(String[] args) {
        System.out.println(StringUtils.leftPad("foo", 5));
        System.out.println(StringUtils.leftPad("1", 2,'0'));
    }
}
