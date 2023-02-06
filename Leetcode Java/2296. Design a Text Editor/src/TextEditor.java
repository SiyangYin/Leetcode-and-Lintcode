class TextEditor {
    private StringBuilder sb;
    private int cur;
    public TextEditor() {
        sb = new StringBuilder();
        cur = 0;
    }

    public void addText(String text) {
        sb.insert(cur, text);
        cur += text.length();
    }

    public int deleteText(int k) {
        sb.delete(Math.max(0, cur - k), cur);
        int res = Math.min(k, cur);
        cur = Math.max(cur - k, 0);
        return res;
    }

    public String cursorLeft(int k) {
        cur = Math.max(cur - k, 0);
        return sb.substring(Math.max(0, cur - 10), cur);
    }

    public String cursorRight(int k) {
        cur = Math.min(cur + k, sb.length());
        return sb.substring(Math.max(0, cur - 10), cur);
    }

    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();
        textEditor.addText("leetcode");
        System.out.println(textEditor.deleteText(4));
        textEditor.addText("practice");
        System.out.println(textEditor.cursorRight(3));
        System.out.println(textEditor.cursorLeft(8));
        System.out.println(textEditor.deleteText(10));
        System.out.println(textEditor.cursorLeft(2));
        System.out.println(textEditor.cursorRight(6));
    }
}