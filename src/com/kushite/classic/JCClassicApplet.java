/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kushite.classic;

import javacard.framework.*;

public class JCClassicApplet extends Applet {

    final static byte Wallet_CLA = (byte) 0xB0;
    final static byte VERIFY = (byte) 0x20;
    final static byte CREDIT = (byte) 0x30;
    final static byte DEBIT = (byte) 0x40;
    final static byte GET_BALANCE = (byte) 0x50;
    final static short MAX_BALANCE = 0x7FFF;
    final static byte MAX_TRANSACTION_AMOUNT = 127;
    final static byte PIN_TRY_LIMIT = (byte) 0x03;
    final static byte MAX_PIN_SIZE = (byte) 0x08;
    final static short SW_VERIFICATION_FAILED = 0x6300;
    final static short SW_PIN_VERIFICATION_REQUIRED = 0x6301;
    final static short sw_invalid_transaction_amount = 0x6a83;
    final static short sw_exceed_maximum_balance = 0x6a84;
    final static short sw_negative_balance = 0x6a85;

    OwnerPIN pin;
    short balance;

    /**
     * Installs this applet.
     *
     * @param bArray the array containing installation parameters
     * @param bOffset the starting offset in bArray
     * @param bLength the length in bytes of the parameter data in bArray
     */
    public static void install(byte[] bArray, short bOffset, byte bLength) {
        new JCClassicApplet(bArray, bOffset, bLength);
    }

    /**
     * Only this class's install method should create the applet object.
     */
    protected JCClassicApplet(byte[] bArray, short bOffset, byte bLength) {

        // It is good programming practice to allocate
        // all the memory that an applet needs during
        // its lifetime inside the constructor
        pin = new OwnerPIN(PIN_TRY_LIMIT, MAX_PIN_SIZE);

        // The installation parameters contain the PIN
        // initialization value
        pin.update(bArray, bOffset, bLength);
        register();
    }

    public boolean select() {
        if (pin.getTriesRemaining() == 0) {
            return false;
        }
        return true;
    }

    public void deselect() {
        pin.reset();
    }

    public void process(APDU apdu) {
    }
}
