/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.UsuariosDao;
import com.entitys.Account;
import com.entitys.Telefonos;
import com.util.GetAccount;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author jorge
 */
@Controller

public class PerfilController {

    HttpSession sesion;
    String sesionUser;

    @RequestMapping("perfil.htm")
    public ModelAndView getPerfil(HttpServletRequest request) {
        sesion = request.getSession();
        ModelAndView mav = new ModelAndView();
        String mensaje = null;

        if (sesion.getAttribute("usuario") == null) {
             
            //GetAccount accountHelper = new GetAccount();
           // Account account = accountHelper.getAccountObject(sesUser);
           // mav.addObject("account", account);
           mav.setViewName("usuarios/login");
          
        } else {
            sesionUser = sesion.getAttribute("usuario").toString();
             mav.setViewName("panel/perfil");
        }
        //mav.addObject("mensaje", mensaje);
        
        return mav;
    }

    @ModelAttribute("account")
    public Account listaUsuarios(HttpServletRequest request) {
        sesion = request.getSession();
        //Data referencing for web framework checkboxes
        Account account = new Account();
        ModelAndView mav = new ModelAndView();
         if (sesion.getAttribute("usuario") == null) {
            
        } else {
            String sesUser = sesion.getAttribute("usuario").toString();
            GetAccount accountHelper = new GetAccount();
             account = accountHelper.getAccountObject(sesUser);
             System.out.println("Regrese con datos para la vista "+account.getFirst_name()+account.getLanguaje_id());
            mav.addObject("account", account);
        }

        return account;

    }
}
