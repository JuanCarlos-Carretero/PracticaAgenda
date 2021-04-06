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
            createTables();
            try {
                connection = DriverManager.getConnection(url);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }
        return instance;
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
            statement.execute("CREATE TABLE IF NOT EXISTS contacto (nombre text, apellido1 text, apellido2 text, grupo text, nTelefono integer, eMail text, direccion text, fechaCumpleanyos date)");
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

    public List<Contacto> selectContacto(){
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
                String fechaCumpleanyos = resultSet.getString("fechaCumpleaños");

                listaContactos.add(new Contacto(nombre, apellido1, apellido2, grupo, nTelefono, eMail, direccion, fechaCumpleanyos));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return listaContactos;
    }
}