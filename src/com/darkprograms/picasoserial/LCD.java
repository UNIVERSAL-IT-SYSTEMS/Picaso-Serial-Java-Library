package com.darkprograms.picasoserial;

import com.darkprograms.picasoserial.screengraphics.ImageControl;
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

    private SerialPort serialPort;

    public LCD(String serialPortLocation){
        setSerialPort(new SerialPort(serialPortLocation));
        try {
            System.out.println("Port opened: " + serialPort.openPort());
            System.out.println("Params setted: " + serialPort.setParams(9600, 8, 1, 0));
        }
        catch (SerialPortException ex){
            System.out.println(ex);
        }
    }

    public ImageControl imageControl(){
        return new ImageControl();
    }

    protected LCD(){

    }

    protected SerialPort getSerialPort() {
        return serialPort;
    }

    private void setSerialPort(SerialPort serialPort) {
        this.serialPort = serialPort;
    }
}
