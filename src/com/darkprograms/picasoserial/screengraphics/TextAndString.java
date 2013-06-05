package com.darkprograms.picasoserial.screengraphics;

import com.darkprograms.picasoserial.LCD;
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
public class TextAndString {

    private SerialPort serialPort;

    public TextAndString(SerialPort serialPort){
        setSerialPort(serialPort);
    }

    private TextAndString(){

    }

    public boolean putString(String text) throws SerialPortException, SerialPortTimeoutException {
        getSerialPort().writeByte((byte) ((Constants.PUT_STRING & 0xff00) >> 8)); //MSB
        getSerialPort().writeByte((byte) (Constants.PUT_STRING & 0xff)); //LSB
        getSerialPort().writeString(text);
        getSerialPort().writeByte((byte) 0);
        return (getSerialPort().readBytes(1, 1500)[0] == Constants.ACK_BYTE);
    }


    private SerialPort getSerialPort() {
        return serialPort;
    }

    private void setSerialPort(SerialPort serialPort) {
        this.serialPort = serialPort;
    }

}
