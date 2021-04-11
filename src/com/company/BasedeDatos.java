package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BasedeDatos {
    static final String url = "jdbc:sqlite:database.db";

    static BasedeDatos instance;
    static Connection connection;

    public static BasedeDatos get(){
        if(instance == null){
            instance = new BasedeDatos();
            try {
                connection = DriverManager.getConnection(url);
                createTables();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }
        return instance;
    }
    void deleteContacto(Contacto borrarContacto){
        try (Statement statement = connection.createStatement()){
            statement.execute("Delete contacto from contacto where nombre like '?'");
        }catch(Exception e){
            Mensaje mensaje = new Mensaje();
            mensaje.mostrarWarn("Este contacto no existe");
        }
    }
    void deleteTables(){
        try (Statement statement = connection.createStatement()) {
            statement.execute("DROP TABLE IF EXISTS contacto");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    static void createTables(){
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS contacto (nombre text not null, apellido1 text not null, apellido2 text, grupo text, nTelefono integer not null, eMail text, direccion text, fechaCumpleanyos date)");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertContacto(String nombre, String apellido1, String apellido2, String grupo, String nTelefono, String eMail, String direccion, String fechaCumpleanyos) {
        String sql = "INSERT INTO contacto(nombre,apellido1,apellido2,grupo,nTelefono,eMail,direccion,fechaCumpleanyos) VALUES(?,?,?,?,?,?,?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, apellido1);
            preparedStatement.setString(3, apellido2);
            preparedStatement.setString(4, grupo);
            preparedStatement.setString(5, nTelefono);
            preparedStatement.setString(6, eMail);
            preparedStatement.setString(7, direccion);
            preparedStatement.setString(8, fechaCumpleanyos);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void updateContactoN(String nombre) {
        String sql = "UPDATE TABLE contacto(nombre) VALUES(?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, nombre);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void updateContactoA1(String apellido1) {
        String sql = "UPDATE TABLE contacto(apellido1) VALUES(?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(2, apellido1);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void updateContactoA2(String apellido2) {
        String sql = "UPDATE TABLE contacto(apellido2) VALUES(?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(3, apellido2);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void updateContactoG(String grupo) {
        String sql = "UPDATE TABLE contacto(grupo) VALUES(?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(4, grupo);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void updateContactonT(String nTelefono) {
        String sql = "UPDATE TABLE contacto(nTelefono) VALUES(?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(5, nTelefono);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void updateContactoE(String eMail) {
        String sql = "UPDATE TABLE contacto(eMail) VALUES(?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(6, eMail);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void updateContactoD(String direccion) {
        String sql = "UPDATE TABLE contacto(direccion) VALUES(?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(7, direccion);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void updateContactoF(String fechaCumpleanyos) {
        String sql = "UPDATE TABLE contacto(fechaCumpleanyos) VALUES(?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(8, fechaCumpleanyos);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Contacto> BuscaContacto(String nombre){
        String sql = "SELECT * FROM contacto WHERE nombre = '?'";

        List<Contacto> listaContacto = new ArrayList<>();
        try (PreparedStatement preparedStatement  = connection.prepareStatement(sql)){

            ResultSet resultSet  = preparedStatement.executeQuery();
            while (resultSet.next()) {
                resultSet.getString("nombre");
                listaContacto.add(new Contacto(nombre, null, null, null, null, null, null, null));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return listaContacto;
    }

    public boolean existeContacto(String comanda) {
        // convertir comanda a nombre + apellido1
        boolean ape=false;
        String nombre="";
        String apellido1="";
        for (int i = 0; i < comanda.length(); i++) {
            if (!ape){
                if (comanda.charAt(i)==' '){
                    ape=true;
                }else{
                    nombre=nombre+comanda.charAt(i);
                }
            }else{
                apellido1=apellido1+comanda.charAt(i);
            }
        }

        String sql = "SELECT nombre, apellido1 FROM contacto WHERE nombre like ? and apellido1 like ?";

        try (PreparedStatement preparedStatement  = connection.prepareStatement(sql)){
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2,apellido1);
            ResultSet resultSet  = preparedStatement.executeQuery();
            String nombre1 = resultSet.getString("nombre");
            String apellido_1 = resultSet.getString("apellido1");


        } catch (SQLException e) {
            Mensaje mensaje = new Mensaje();
            mensaje.mostrarError("¡Este contacto no existe!");
            return false;
        }
        return true;

    }


    public List<Contacto> ContactoEncontrado(String nombre){
        String sql = "SELECT * FROM contacto WHERE nombre=?";

        List<Contacto> listaContacto = new ArrayList<>();
        try (PreparedStatement preparedStatement  = connection.prepareStatement(sql)){
            preparedStatement.setString(1,nombre);

            ResultSet resultSet  = preparedStatement.executeQuery();
            while (resultSet.next()) {
                resultSet.getString("nombre");
                String apellido1 = resultSet.getString("apellido1");
                String apellido2 = resultSet.getString("apellido2");
                String grupo = resultSet.getString("grupo");
                String nTelefono = resultSet.getString("nTelefono");
                String eMail = resultSet.getString("eMail");
                String direccion = resultSet.getString("direccion");
                String fechaCumpleanyos = resultSet.getString("fechaCumpleanyos");

                listaContacto.add(new Contacto(nombre, apellido1, apellido2, grupo, nTelefono, eMail, direccion, fechaCumpleanyos));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return listaContacto;
    }
    public List<Contacto> listaContacto(){
        String sql = "SELECT * FROM contacto";

        List<Contacto> listaContactos = new ArrayList<>();
        try (PreparedStatement preparedStatement  = connection.prepareStatement(sql)){

            ResultSet resultSet  = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                String apellido1 = resultSet.getString("apellido1");
                String apellido2 = resultSet.getString("apellido2");
                String grupo = resultSet.getString("grupo");
                String nTelefono = resultSet.getString("nTelefono");
                String eMail = resultSet.getString("eMail");
                String direccion = resultSet.getString("direccion");
                String fechaCumpleanyos = resultSet.getString("fechaCumpleanyos");

                listaContactos.add(new Contacto(nombre, apellido1, apellido2, grupo, nTelefono, eMail, direccion, fechaCumpleanyos));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return listaContactos;
    }
}