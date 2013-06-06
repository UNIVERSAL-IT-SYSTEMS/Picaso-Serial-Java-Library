package com.darkprograms.picasoserial.response;

/**
 * Created with IntelliJ IDEA.
 * User: theshadow
 * Date: 6/5/13
 * Time: 7:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class IntegerResponse extends GeneralResponse {

    private int integer;

    public IntegerResponse(boolean acknowledged, int integer) {
        setAcknowledged(acknowledged);
        setInteger(integer);
    }

    public int getInteger() {
        return integer;
    }

    private void setInteger(int integer) {
        this.integer = integer;
    }
}
