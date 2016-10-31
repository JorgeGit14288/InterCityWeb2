/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.entitys.Telefonos;
import com.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author jorge
 */
public class TelefonosDao implements ITelefonosDao {

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

    public List<Telefonos> getAllTelefonos() throws HibernateException {
        List<Telefonos> listaTelefonoss = null;

        try {
            iniciaOperacion();
            listaTelefonoss = sesion.createQuery("from Telefonos").list();
            System.out.println("se ha devuelto una lista del servidor");
        } finally {
            sesion.close();
             System.out.println("Error al devolver lista");
        }
        

        return listaTelefonoss;
    }
    public List<Telefonos> getAllTelUser(String telefono) throws HibernateException {
        List<Telefonos> listaTelefonoss = null;

        try {
            iniciaOperacion();
            listaTelefonoss = sesion.createQuery("from Telefonos where telefono_area="+telefono+"").list();
            System.out.println("se devolvio la lista de telefonos de un usuario");
        } finally {
            sesion.close();
             System.out.println("Error al devolver lista de telefonos de el usuario");
        }
        

        return listaTelefonoss;
    }
    
    

    public Telefonos getTelefono(String telefono) throws HibernateException {
        Telefonos tel = null;
        try {
            iniciaOperacion();
            String queryString = "from Telefonos where telefono_area = :telefono";
            Query query = sesion.createQuery(queryString);
            query.setString("telefono", telefono);
            tel = (Telefonos) query.uniqueResult();
            System.out.println("obteniendo los telefonos de un usuario" + tel.getTelefonoArea());
        } catch (Exception e) {
             System.out.println("No se ha encontrado el registro telefonico");
            e.printStackTrace();

        } finally {
            sesion.close();

        }

        return tel;
    }

    public Telefonos getTelefono2(String idTelefonos) throws HibernateException {
        Telefonos tel = null;
        try {
            iniciaOperacion();
            tel = (Telefonos) sesion.get(Telefonos.class, idTelefonos);
        } finally {
            sesion.close();
        }

        return tel;
    }

    public boolean deleteTelefonos(Telefonos tel) throws HibernateException {
        boolean resultado = false;
        try {
            iniciaOperacion();
            sesion.delete(tel);
            tx.commit();
            resultado = true;
             System.out.println("Se ha eliminado un registro telefonicon "+tel.getCodigoArea());
        } catch (HibernateException he) {
            manejaExcepcion(he);
            System.out.println("NO Se ha eliminado un registro telefonicon "+tel.getTelefonoArea());
            throw he;
        } finally {
            sesion.close();
        }
        return resultado;
    }

    public boolean updateTelefono(Telefonos tel) throws HibernateException {
        boolean resultado = false;
        try {
            iniciaOperacion();
            sesion.update(tel);
            tx.commit();
            resultado = true;
            System.out.println("Se ha actualizado un telefono "+tel.getTelefonoArea());
        } catch (HibernateException he) {
            System.out.println("NO Se ha actualizado un telefono "+tel.getTelefonoArea());
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
        return resultado;
    }

    public boolean createTelefono(Telefonos tel) throws HibernateException {
        boolean resultado = false;

        try {
            iniciaOperacion();
            sesion.save(tel);
            tx.commit();
            resultado = true;
             System.out.println("Se ha CREADO un telefono "+tel.getTelefonoArea());
        } catch (HibernateException he) {
            manejaExcepcion(he);
             System.out.println("NO Se ha CREADO un telefono "+tel.getTelefonoArea());
            throw he;
        } finally {
            sesion.close();
        }

        return resultado;
    }

    public boolean deleteTelefono(String telefono) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int countTelefonos() {

        int cantidad = 0;
        cantidad = this.getAllTelefonos().size()+1;
        System.out.println("el numero de registro es "+cantidad);
        
        return cantidad;

    }

}
