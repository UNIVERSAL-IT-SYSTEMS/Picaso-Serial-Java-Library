package com.darkprograms.picasoserial;

import com.darkprograms.picasoserial.screengraphics.Graphics;
import com.darkprograms.picasoserial.screengraphics.TextAndString;
import jssc.SerialPort;
import jssc.SerialPortException;

/**
 * Created with IntelliJ IDEA.
 * User: theshadow
 * Date: 5/29/13
 * Time: 6:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class LCD {

    protected SerialPort serialPort;

    public LCD(String serialPortLocation){
        setSerialPort(new SerialPort(serialPortLocation));
        try {
            System.out.println("Port opened: " + getSerialPort().openPort());
            System.out.println("Params set: " + getSerialPort().setParams(9600, 8, 1, 0));
        }
        catch (SerialPortException ex){
            System.out.println(ex);
        }
        serialPort.isOpened();
    }

    protected LCD(){

    }

    public Graphics graphics(){
        return new Graphics(getSerialPort());
    }

    public TextAndString textAndString(){
        return new TextAndString(getSerialPort());
    }

    protected SerialPort getSerialPort() {
        return serialPort;
    }

    private void setSerialPort(SerialPort serialPort) {
        this.serialPort = serialPort;
    }
}
