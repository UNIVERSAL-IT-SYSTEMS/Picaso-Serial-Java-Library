package com.darkprograms.picasoserial.response;

/**
 * Created with IntelliJ IDEA.
 * User: theshadow
 * Date: 6/5/13
 * Time: 7:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class TextAttributeResponse extends IntegerResponse {

    private boolean underlined;
    private boolean bold;
    private boolean italic;
    private boolean inverse;

    public TextAttributeResponse(boolean acknowledged, int integer) {
        super(acknowledged, integer);
        System.out.println(getInteger());

        if (((((integer & 0xff00) >> 8) >> 6) & 0xff) != 0) {
            // The bit was set
            System.out.println("Bold " + ((((integer & 0xff00) >> 8) >> 4) & 0xff));
            return;
        }
        System.out.println("Not Bold " + ((((integer & 0xff00) >> 8) >> 4) & 0xff));

    }
}
