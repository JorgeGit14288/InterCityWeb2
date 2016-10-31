/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.entitys.Usuarios;
import java.util.List;
import com.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author jorge
 */
public class UsuariosDao implements IUsuariosDao {

    private Session sesion;
    private Transaction tx;

    private void iniciaOperacion() throws HibernateException {
        sesion = HibernateUtil.getSessionFactory().openSession();
        tx = sesion.beginTransaction();
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he);
    }

    public List<Usuarios> getAllUsuarios() throws HibernateException {
        List<Usuarios> listaUsuarioss = null;

        try {
            iniciaOperacion();
            listaUsuarioss = sesion.createQuery("from Usuarios").list();
           // System.out.println("Se ha devuelto la lista de usuaros");
        } catch (Exception e) {
            System.out.println("NO pudo realizarse la consulta de la lista");

        } finally {
            sesion.close();
           // System.out.println("SE HA CERRADO LA CONEXION");
        }

        return listaUsuarioss;
    }

    public Usuarios getUsuario(String id) throws HibernateException {
        Usuarios user = null;
        try {
            iniciaOperacion();
            String queryString = "from Usuarios where idUsuario = :id";
            Query query = sesion.createQuery(queryString);
            query.setString("id", id);
            user = (Usuarios) query.uniqueResult();
            System.out.println("El usuario existe" + user.getNombres());
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            sesion.close();

        }

        return user;
    }

    public Usuarios getUsuario22(String idUsuarios) throws HibernateException {
        Usuarios user = null;
        try {
            iniciaOperacion();
            user = (Usuarios) sesion.get(Usuarios.class, idUsuarios);
        } finally {
            sesion.close();
        }

        return user;
    }

    public boolean deleteUsuarios(Usuarios user) throws HibernateException {
        boolean resultado = false;
        try {
            iniciaOperacion();
            sesion.delete(user);
            tx.commit();
            resultado = true;
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
        return resultado;
    }

    public boolean updateUsuarios(Usuarios user) throws HibernateException {
        boolean resultado = false;
        try {
            iniciaOperacion();
            sesion.update(user);
            tx.commit();
            resultado = true;
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
        return resultado;
    }

    public boolean createUsuarios(Usuarios user) throws HibernateException {
        boolean resultado = false;

        try {
            iniciaOperacion();
            sesion.save(user);
            tx.commit();
            resultado = true;
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }

        return resultado;
    }

    @Override
    public boolean deleteUsuarios(String telefono) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int countUsuarios() {
        int cantidad = 0;
        cantidad = this.getAllUsuarios().size() + 1;
        System.out.println("el numero de registro es " + cantidad);
        return cantidad;

    }

}
