/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;

import java.util.Random;

/**
 *
 * @author jorge
 */
public class GeneradorCodigos {
    
    public GeneradorCodigos()
    {
        
    }
    
    
    public String getCodigo()
    {
         Random r = new Random();
        //System.out.println(r.nextInt());
        int limite = 6;
        int numero =(r.nextInt(limite + 99999));
        String resultado = null;
        
        if (numero<0)
        {
            numero= numero*-1;
            resultado = String.valueOf(numero);
        }
        else 
        {
            //numero = numero;
            resultado = String.valueOf(numero);
        }
       // System.out.println(numero);
        return resultado;
        
       
    }
    
}
