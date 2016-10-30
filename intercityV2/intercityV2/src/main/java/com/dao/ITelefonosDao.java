/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.entitys.Telefonos;
import java.util.List;

/**
 *
 * @author jorge
 */
public interface ITelefonosDao {
    public List<Telefonos> getAllTelefonos();
    public boolean createTelefono(Telefonos tel);
    public boolean updateTelefono(Telefonos tel);
    public boolean deleteTelefono(String telefono); 
    public int countTelefonos();
    public Telefonos getTelefono(String tel);


    
} 
