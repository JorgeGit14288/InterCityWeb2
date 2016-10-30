                                                                        /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.entitys.Usuarios;
import java.util.List;

/**
 *
 * @author jorge
 */
public interface IUsuariosDao  {
   public List<Usuarios> getAllUsuarios();
    public boolean createUsuarios(Usuarios user);
    public boolean updateUsuarios(Usuarios user);
    public boolean deleteUsuarios(String telefono); 
    public int countUsuarios();
    public Usuarios getUsuario(String user);
    
}
