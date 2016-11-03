/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;
import com.dao.TelefonosDao;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.entitys.Telefonos;
import com.dao.UsuariosDao;
import com.entitys.Usuarios;
import com.util.Cifrar;
import com.util.GeneradorCodigos;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author jorge
 */
@Controller
public class RecuperarController {
    
    HttpSession sesion;
    String codigo;
    int contador = 0;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public HttpSession getSesion() {
        return sesion;
    }

    public void setSesion(HttpSession sesion) {
        this.sesion = sesion;
    }

    @RequestMapping("recuperar.htm")
    public ModelAndView Recuperar() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("recuperar/recuperar");
        return mav;
    }

    @RequestMapping(value = "validarRecuperar.htm", method = RequestMethod.POST)
    public ModelAndView ValidarRecuperar(HttpServletRequest request) {
        String mensaje = null;
        sesion = request.getSession();
        ModelAndView mav = new ModelAndView();
        Telefonos telefono = new Telefonos();
        TelefonosDao telDao = new TelefonosDao();
        UsuariosDao userDao = new UsuariosDao();
        try {
            //cargamos los datos en un objeto usuario
            telefono.setCodigoArea(request.getParameter("codigo"));
            telefono.setTelefono(request.getParameter("telefono"));
            telefono.setTelefonoArea(telefono.getCodigoArea() + "-" + telefono.getTelefono());
            telefono.setStatus(request.getParameter("status"));
            Cifrar varCifrar = new Cifrar();
            String pass = varCifrar.Encriptar(request.getParameter("password"));
            //telefono.setPassword(pass);

            Usuarios usuario = new Usuarios();
            int idi = userDao.countUsuarios();
            String id = "icu0" + idi;
            usuario.setIdUsuario(id);
            usuario.setPassword(pass);
                    
            if (userDao.createUsuarios(usuario)) {
                telefono.setIdUsuario(usuario.getIdUsuario());

                //verificamos si se crea el usuario
                if (telDao.createTelefono(telefono) == true) {
                    mensaje = null;
                    String sesUser = telefono.getTelefonoArea();
                    sesion.setAttribute("usuario", sesUser);;
                    mensaje = "Bienvenido";
                    this.createCodigo();
                    mav.setViewName("telefonos/confirmPhone");
                    System.out.print("se ha creado un usuario");
                } else {
                    mensaje = null;
                    mensaje = "NO SE PUDO REGISTRAR EL TELEFONO";
                    mav.setViewName("telefonos/registrar");
                    System.out.print("NO SE ha creado un usuario");
                }
            } else {
                mensaje = null;
                mensaje = "NO SE PUDO CREAR EL USUARIO";
                mav.setViewName("telefonos/registrar");
            }
        } catch (Exception e) {
            mensaje = null;
            e.printStackTrace();
            mensaje = "se duplicaron llaves ";
            mav.setViewName("telefonos/registrar");
        }
        mav.addObject("mensaje", mensaje);

        return mav;
    }

   

    @RequestMapping("recuperarPhone.htm")
    public ModelAndView getConfirm() {

        ModelAndView mav = new ModelAndView();
        String mensaje = null;
        mensaje = "Ingrese el codigo que recibio en su telefono " + this.getCodigo();
        mav.addObject("mensaje", mensaje);
        mav.setViewName("telefonos/confirmPhone");
        return mav;
    }

    @RequestMapping(value = "validarRecuperarPhone.htm", method = RequestMethod.POST)
    public ModelAndView ValidarPhone(HttpServletRequest request) {
        String mensaje = null;
        sesion = request.getSession();
        ModelAndView mav = new ModelAndView();
        String codigo2 = request.getParameter("codigo");
        try {
            if (sesion.getAttribute("usuario") == null) {
                mav.setViewName("login/login");

            } else {
                if (this.getCodigo().compareTo(codigo2) == 0) {

                    Telefonos telefono = new Telefonos();
                    TelefonosDao telDao = new TelefonosDao();
                    String idtel = (sesion.getAttribute("usuario")).toString();
                    System.out.print("el telefono a buscar para ingresar el codigo es " + idtel);
                    telefono = telDao.getTelefono(idtel);
                    telefono.setCodigoConfirm(this.getCodigo());
                    if (telDao.updateTelefono(telefono)) {
                        mav.setViewName("panel/panel");
                        //this.setCodigo(null);
                    } else {
                        mensaje = "El codigo es correcto, pero no se ha podido cargar a su cuenta";
                        mav.addObject("mensaje", mensaje);
                        mav.setViewName("usuarios/confirmPhone");
                    }
                } else {

                    mensaje = "El codigo ingreado no es correcto, por favor intente de nuevo";
                    mav.addObject("mensaje", mensaje);
                    mav.setViewName("telefonos/confirmPhone");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mav;
    }
    
    @RequestMapping("recuperarPassword.htm")
    public ModelAndView RecuperarPassword() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("recuperar/recuperarPassword");
        return mav;
    }
    @RequestMapping("validarNewPassword")
    public ModelAndView validarNewPassword() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login/login");
        return mav;
    }
    
    

    @ModelAttribute("codigo")
    public String obtenerCodigo() {

        if (this.getCodigo() == null) {
            this.setCodigo(this.createCodigo());
            return this.getCodigo();

        } else {
            return this.getCodigo();
            // return this.createCodigo();
        }
    }
     public String createCodigo() {
        GeneradorCodigos codigosHelper = new GeneradorCodigos();
        String varCod = codigosHelper.getCodigo();
        //System.out.print(varCod);
        return varCod;
    }

    
    
}
