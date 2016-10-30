/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;

import com.dao.UsuariosDao;
import com.entitys.Usuarios;
import java.util.List;

/**
 *
 * @author jorge
 */
public class testmain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     Usuarios user = new Usuarios();
        UsuariosDao dao = new UsuariosDao();
        
        user.setNombre("Carlos");
        //user.setTelefono("4569321");
        user.setPais("Guatemala");
       // user.setPassword("amor");
        //user.setCodigoArea(502);
        user.setStatus("Activo");
        
      // String resultado= dao.guardaUsuarios(user);
       //System.out.print(resultado);
       
      //Usuarios user2 = dao.getUsuario("41109321");
       //user2.setNombre("Jorge Roberto fuentes");
     //  dao.updateUsuarios(user2);
       
       //eliminamos un usuario
//       dao.deleteUsuarios(user);
      //  dao.createUsuarios(user);
        
     //  List<Usuarios> listaUsuarioss = dao.getAllUsuarios();  
    //    System.out.println("Hay " + listaUsuarioss.size() + "contactos en la base de datos");  

    ///    for(Usuarios c : listaUsuarioss) 
    //    { 
    //        System.out.println("-> " + c.getNombre()); 
    //    } 
    }
    
}
