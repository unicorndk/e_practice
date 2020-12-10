package org.unicorndk;

public class Buffer {
    private static String textBuffer = "NONE";

    public static String getTextBuffer() {
        return textBuffer;
    }

    public static void setTextBuffer(String _textBuffer) {
        textBuffer = _textBuffer;
    }
}
