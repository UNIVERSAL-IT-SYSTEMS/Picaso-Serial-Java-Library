package com.darkprograms.picasoserial.util;

/**
 * Created with IntelliJ IDEA.
 * User: theshadow
 * Date: 5/29/13
 * Time: 6:35 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Constants {

    public static final byte ACK_BYTE = 0x06;

    //gfx_Cls
    public static final int CLEAR_SCREEN = 0xFFCD;

    //txt_MoveCursor
    public static final int MOVE_CURSOR = 0xFFE9;
    //putCH
    public static final int PUT_CHARACTER = 0xFFFE;
    //putStr
    public static final int PUT_STRING = 0x0018;
    //charwidth
    public static final int CHARACTER_WIDTH = 0x001E;
    //charheight
    public static final int CHARACTER_HEIGHT = 0x001D;
    //txt_FGcolour
    public static final int TEXT_FOREGROUND_COLOUR = 0xFFE7;
    //txt_BGcolour
    public static final int TEXT_BACKGROUND_COLOUR = 0xFFE6;
    //txt_FontID
    public static final int TEXT_FONT = 0xFFE5;
    //text_Width
    public static final int TEXT_WIDTH = 0xFFE4;
    //txt_Height
    public static final int TEXT_HEIGHT = 0xFFE3;
    //txt_Xgap
    public static final int TEXT_X_GAP = 0xFFE2;
    //txt_Ygap
    public static final int TEXT_Y_GAP = 0xFFE1;
    //txt_Bold
    public static final int TEXT_BOLD = 0xFFDE;
    //txt_Inverse
    public static final int TEXT_INVERSE = 0xFFDC;
    //txt_Italic
    public static final int TEXT_ITALIC = 0xFFDD;
    //txt_Opacity
    public static final int TEXT_OPACITY = 0xFFDF;
    //txt_Underline
    public static final int TEXT_UNDERLINE = 0xFFDB;
    //txt_Attributes
    public static final int TEXT_ATTRIBUTES = 0xFFDA;

    public static final int BOLD = 16;
    public static final int ITALIC = 32;
    public static final int INVERSE = 64;
    public static final int UNDERLINE = 128;


}
