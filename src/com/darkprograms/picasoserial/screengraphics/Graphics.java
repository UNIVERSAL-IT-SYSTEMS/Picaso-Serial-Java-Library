package com.darkprograms.picasoserial.screengraphics;

import com.darkprograms.picasoserial.LCD;
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
public class Graphics {

    private SerialPort serialPort;

    public Graphics(SerialPort serialPort){
       setSerialPort(serialPort);
    }

    private Graphics(){

    }

    public boolean clearScreen() throws SerialPortException, SerialPortTimeoutException{
        System.out.println(serialPort.isOpened());
         getSerialPort().writeByte((byte) ((Constants.CLEAR_SCREEN & 0xff00) >> 8)); //MSB
         getSerialPort().writeByte((byte) (Constants.CLEAR_SCREEN & 0xff)); //LSB
         return (getSerialPort().readBytes(1, 1500)[0] == Constants.ACK_BYTE);
     }

    private SerialPort getSerialPort() {
        return serialPort;
    }

    private void setSerialPort(SerialPort serialPort) {
        this.serialPort = serialPort;
    }
}
