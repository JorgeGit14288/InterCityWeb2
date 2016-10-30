/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author jorge
 */
public class Cifrar {

    public Cifrar() {

    }

    public String Encriptar(String cadena) {
       String textoSinEncriptar = cadena;
            String textoEncriptadoConSHA = DigestUtils.sha1Hex(textoSinEncriptar);
        return textoEncriptadoConSHA;
        
    }
      
}
