package com.darkprograms.picasoserial.util;

import jssc.SerialPort;
import jssc.SerialPortException;
import jssc.SerialPortTimeoutException;

import java.nio.ByteBuffer;

/**
 * Created with IntelliJ IDEA.
 * User: theshadow
 * Date: 6/5/13
 * Time: 6:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class BasicSerial {

    protected BasicSerial() {

    }

    protected void writeWord(int word, SerialPort serialPort) throws SerialPortException {
        serialPort.writeByte((byte) ((word & 0xff00) >> 8)); //MSB
        serialPort.writeByte((byte) (word & 0xff)); //LSB
    }

    protected void writeInt(int integer, SerialPort serialPort) throws SerialPortException {
        serialPort.writeInt(integer);
    }

    protected void writeString(String string, SerialPort serialPort) throws SerialPortException {
        serialPort.writeString(string);
    }

    protected void writeByte(byte data, SerialPort serialPort) throws SerialPortException {
        serialPort.writeByte(data);
    }

    protected byte[] readWord(SerialPort serialPort) throws SerialPortException, SerialPortTimeoutException {
        return serialPort.readBytes(2, 1500);
    }

    protected short wordToShort(byte[] word) {
        ByteBuffer wrapped = ByteBuffer.wrap(word);
        return wrapped.getShort();
    }

    protected boolean isAcknowledged(SerialPort serialPort) throws SerialPortException, SerialPortTimeoutException {
        return serialPort.readBytes(1, 1500)[0] == Constants.ACK_BYTE;
    }

    protected boolean intToBoolean(int integer) {
        return integer == 1;
    }

}
