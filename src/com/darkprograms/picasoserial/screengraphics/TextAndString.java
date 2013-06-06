package com.darkprograms.picasoserial.screengraphics;

import com.darkprograms.picasoserial.response.BooleanResponse;
import com.darkprograms.picasoserial.response.IntegerResponse;
import com.darkprograms.picasoserial.response.TextAttributeResponse;
import com.darkprograms.picasoserial.util.BasicSerial;
import com.darkprograms.picasoserial.util.Constants;
import jssc.SerialPort;
import jssc.SerialPortException;
import jssc.SerialPortTimeoutException;

/**
 * Created with IntelliJ IDEA.
 * User: theshadow
 * Date: 5/31/13
 * Time: 8:09 AM
 * To change this template use File | Settings | File Templates.
 */
public class TextAndString extends BasicSerial {

    private SerialPort serialPort;

    public TextAndString(SerialPort serialPort) {
        setSerialPort(serialPort);
    }

    private TextAndString() {

    }

    public boolean moveCursor(int line, int column) throws SerialPortException, SerialPortTimeoutException {
        writeWord(Constants.MOVE_CURSOR, getSerialPort());
        writeWord(line, getSerialPort());
        writeWord(column, getSerialPort());
        return isAcknowledged(getSerialPort());
    }

    public boolean putCharacter(char character) throws SerialPortException, SerialPortTimeoutException {
        writeWord(Constants.PUT_CHARACTER, getSerialPort());
        writeWord((int) character, getSerialPort());
        return isAcknowledged(getSerialPort());
    }

    /**
     * Puts string on display
     *
     * @param text String to display
     * @return Returns IntegerResponse with boolean ACK, and length of String displayed in the integer
     * @throws SerialPortException
     * @throws SerialPortTimeoutException
     */
    public IntegerResponse putString(String text) throws SerialPortException, SerialPortTimeoutException {
        writeWord(Constants.PUT_STRING, getSerialPort());
        writeString(text, getSerialPort());
        writeByte((byte) 0, getSerialPort());

        boolean acknowledged = isAcknowledged(getSerialPort());
        int length = wordToShort(readWord(getSerialPort()));
        return new IntegerResponse(acknowledged, length);
    }

    public IntegerResponse getCharacterWidth(char character) throws SerialPortException, SerialPortTimeoutException {
        writeWord(Constants.CHARACTER_WIDTH, getSerialPort());
        writeWord((int) character, getSerialPort());

        boolean acknowledged = isAcknowledged(getSerialPort());
        int width = wordToShort(readWord(getSerialPort()));
        return new IntegerResponse(acknowledged, width);
    }

    public IntegerResponse getCharacterHeight(char character) throws SerialPortException, SerialPortTimeoutException {
        writeWord(Constants.CHARACTER_HEIGHT, getSerialPort());
        writeWord((int) character, getSerialPort());

        boolean acknowledged = isAcknowledged(getSerialPort());
        int height = wordToShort(readWord(getSerialPort()));
        return new IntegerResponse(acknowledged, height);
    }

    public IntegerResponse setTextForegroundColour(int colour) throws SerialPortException, SerialPortTimeoutException {
        writeWord(Constants.TEXT_FOREGROUND_COLOUR, getSerialPort());
        writeWord(colour, getSerialPort());

        boolean acknowledged = isAcknowledged(getSerialPort());
        int prevColour = wordToShort(readWord(getSerialPort()));
        return new IntegerResponse(acknowledged, prevColour);
    }

    public IntegerResponse setTextBackgroundColour(int colour) throws SerialPortException, SerialPortTimeoutException {
        writeWord(Constants.TEXT_BACKGROUND_COLOUR, getSerialPort());
        writeWord(colour, getSerialPort());

        boolean acknowledged = isAcknowledged(getSerialPort());
        int prevColour = wordToShort(readWord(getSerialPort()));
        return new IntegerResponse(acknowledged, prevColour);
    }

    public IntegerResponse setTextFont(int fontId) throws SerialPortException, SerialPortTimeoutException {
        writeWord(Constants.TEXT_FONT, getSerialPort());
        writeWord(fontId, getSerialPort());

        boolean acknowledged = isAcknowledged(getSerialPort());
        int prevFontId = wordToShort(readWord(getSerialPort()));
        return new IntegerResponse(acknowledged, prevFontId);
    }

    public IntegerResponse setTextWidth(int multiplier) throws SerialPortException, SerialPortTimeoutException {
        writeWord(Constants.TEXT_WIDTH, getSerialPort());
        writeWord(multiplier, getSerialPort());

        boolean acknowledged = isAcknowledged(getSerialPort());
        int prevMultiplier = wordToShort(readWord(getSerialPort()));
        return new IntegerResponse(acknowledged, prevMultiplier);
    }

    public IntegerResponse setTextHeight(int multiplier) throws SerialPortException, SerialPortTimeoutException {
        writeWord(Constants.TEXT_HEIGHT, getSerialPort());
        writeWord(multiplier, getSerialPort());

        boolean acknowledged = isAcknowledged(getSerialPort());
        int prevMultiplier = wordToShort(readWord(getSerialPort()));
        return new IntegerResponse(acknowledged, prevMultiplier);
    }

    public IntegerResponse setTextXGap(int pixelCountGap) throws SerialPortException, SerialPortTimeoutException {
        writeWord(Constants.TEXT_X_GAP, getSerialPort());
        writeWord(pixelCountGap, getSerialPort());

        boolean acknowledged = isAcknowledged(getSerialPort());
        int prevPixelCountGap = wordToShort(readWord(getSerialPort()));
        return new IntegerResponse(acknowledged, prevPixelCountGap);
    }

    public IntegerResponse setTextYGap(int pixelCountGap) throws SerialPortException, SerialPortTimeoutException {
        writeWord(Constants.TEXT_Y_GAP, getSerialPort());
        writeWord(pixelCountGap, getSerialPort());

        boolean acknowledged = isAcknowledged(getSerialPort());
        int prevPixelCountGap = wordToShort(readWord(getSerialPort()));
        return new IntegerResponse(acknowledged, prevPixelCountGap);
    }

    public BooleanResponse setTextBold(boolean bold) throws SerialPortException, SerialPortTimeoutException {
        writeWord(Constants.TEXT_BOLD, getSerialPort());
        writeWord(bold ? 1 : 0, getSerialPort());

        boolean acknowledged = isAcknowledged(getSerialPort());
        int prevBold = wordToShort(readWord(getSerialPort()));
        return new BooleanResponse(acknowledged, intToBoolean(prevBold));
    }

    public BooleanResponse setTextInverse(boolean inverse) throws SerialPortException, SerialPortTimeoutException {
        writeWord(Constants.TEXT_INVERSE, getSerialPort());
        writeWord(inverse ? 1 : 0, getSerialPort());

        boolean acknowledged = isAcknowledged(getSerialPort());
        int prevInverse = wordToShort(readWord(getSerialPort()));
        return new BooleanResponse(acknowledged, intToBoolean(prevInverse));
    }

    public BooleanResponse setTextItalic(boolean italic) throws SerialPortException, SerialPortTimeoutException {
        writeWord(Constants.TEXT_ITALIC, getSerialPort());
        writeWord(italic ? 1 : 0, getSerialPort());

        boolean acknowledged = isAcknowledged(getSerialPort());
        int prevItalic = wordToShort(readWord(getSerialPort()));
        return new BooleanResponse(acknowledged, intToBoolean(prevItalic));
    }

    public BooleanResponse setTextOpacity(boolean opacity) throws SerialPortException, SerialPortTimeoutException {
        writeWord(Constants.TEXT_OPACITY, getSerialPort());
        writeWord(opacity ? 1 : 0, getSerialPort());

        boolean acknowledged = isAcknowledged(getSerialPort());
        int prevOpacity = wordToShort(readWord(getSerialPort()));
        return new BooleanResponse(acknowledged, intToBoolean(prevOpacity));
    }

    /**
     * Set whether to underline new text
     * NOTE: Requires TextY Gap (setTextYGap) to be at least 2
     *
     * @param underline True to underline text, false to not underline text
     * @return BooleanResponse, Whether ACK Byte received, and boolean value of previous underline state
     * @throws SerialPortException
     * @throws SerialPortTimeoutException
     */
    public BooleanResponse setTextUnderline(boolean underline) throws SerialPortException, SerialPortTimeoutException {
        writeWord(Constants.TEXT_UNDERLINE, getSerialPort());
        writeWord(underline ? 1 : 0, getSerialPort());

        boolean acknowledged = isAcknowledged(getSerialPort());
        int prevUnderline = wordToShort(readWord(getSerialPort()));
        return new BooleanResponse(acknowledged, intToBoolean(prevUnderline));
    }

    public TextAttributeResponse setTextAttributes(boolean bold, boolean italic, boolean inverse, boolean underline) throws SerialPortException, SerialPortTimeoutException {
        writeWord(Constants.TEXT_ATTRIBUTES, getSerialPort());
        int value = 0;
        if (bold)
            value += Constants.BOLD;
        if (italic)
            value += Constants.ITALIC;
        if (inverse)
            value += Constants.INVERSE;
        if (underline)
            value += Constants.UNDERLINE;

        writeWord(value, serialPort);

        boolean acknowledged = isAcknowledged(getSerialPort());
        int prevAttributes = wordToShort(readWord(getSerialPort()));
        return new TextAttributeResponse(acknowledged, prevAttributes);
    }


    private SerialPort getSerialPort() {
        return serialPort;
    }

    private void setSerialPort(SerialPort serialPort) {
        this.serialPort = serialPort;
    }

}
