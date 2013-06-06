package com.darkprograms.picasoserial.screengraphics;

import com.darkprograms.picasoserial.util.BasicSerial;
import com.darkprograms.picasoserial.util.Constants;
import jssc.SerialPort;
import jssc.SerialPortException;
import jssc.SerialPortTimeoutException;

/**
 * Created with IntelliJ IDEA.
 * User: theshadow
 * Date: 5/29/13
 * Time: 6:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class Graphics extends BasicSerial {

    private SerialPort serialPort;

    public Graphics(SerialPort serialPort) {
        setSerialPort(serialPort);
    }

    private Graphics() {

    }

    public boolean clearScreen() throws SerialPortException, SerialPortTimeoutException {
        writeWord(Constants.CLEAR_SCREEN, getSerialPort());
        return isAcknowledged(getSerialPort());
    }

    private SerialPort getSerialPort() {
        return serialPort;
    }

    private void setSerialPort(SerialPort serialPort) {
        this.serialPort = serialPort;
    }
}
