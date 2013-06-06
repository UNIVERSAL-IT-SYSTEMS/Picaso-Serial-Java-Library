package com.darkprograms.picasoserial.response;

/**
 * Created with IntelliJ IDEA.
 * User: theshadow
 * Date: 6/5/13
 * Time: 7:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class GeneralResponse {

    private boolean acknowledged;

    public boolean isAcknowledged() {
        return acknowledged;
    }

    public void setAcknowledged(boolean acknowledged) {
        this.acknowledged = acknowledged;
    }
}
