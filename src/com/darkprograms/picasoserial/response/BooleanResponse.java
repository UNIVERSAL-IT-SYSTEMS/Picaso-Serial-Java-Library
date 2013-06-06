package com.darkprograms.picasoserial.response;

/**
 * Created with IntelliJ IDEA.
 * User: theshadow
 * Date: 6/5/13
 * Time: 7:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class BooleanResponse extends GeneralResponse {

    private boolean bool;

    public BooleanResponse(boolean acknowledged, boolean bool) {
        setAcknowledged(acknowledged);
        setBoolean(bool);
    }

    public boolean getBoolean() {
        return bool;
    }

    private void setBoolean(boolean bool) {
        this.bool = bool;
    }
}
