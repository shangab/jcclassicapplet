/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kushite.classic;

import javacard.framework.*;

/**
 *
 * @author shang
 */
public class JCClassicApplet extends Applet {

    /**
     * Installs this applet.
     * 
     * @param bArray
     *            the array containing installation parameters
     * @param bOffset
     *            the starting offset in bArray
     * @param bLength
     *            the length in bytes of the parameter data in bArray
     */
    public static void install(byte[] bArray, short bOffset, byte bLength) {
        new JCClassicApplet();
    }

    /**
     * Only this class's install method should create the applet object.
     */
    protected JCClassicApplet() {
        register();
    }

    /**
     * Processes an incoming APDU.
     * 
     * @see APDU
     * @param apdu
     *            the incoming APDU
     */
    public void process(APDU apdu) {
        //Insert your code here
    }
}
