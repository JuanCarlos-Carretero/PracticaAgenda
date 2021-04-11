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
    void deleteContacto(String nombre){
        String sql= ("DELETE FROM contacto where nombre=?;");
        try (PreparedStatement preparedStatement  = connection.prepareStatement(sql)){
            preparedStatement.setString(1, nombre);
            preparedStatement.executeUpdate();
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
    public void updateContactoN(String ViejoN,String NuevoN) {
        String sql = "UPDATE contacto SET nombre = ? WHERE nombre = ?;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, NuevoN);
            preparedStatement.setString(2, ViejoN);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void updateContactoA1(String ViejoA1,String NuevoA1) {
        String sql = "UPDATE contacto SET apellido1 = ? WHERE nombre = ?;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, NuevoA1);
            preparedStatement.setString(2, ViejoA1);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void updateContactoA2(String ViejoA2, String NuevoA2) {
        String sql = "UPDATE contacto SET apellido2 = ? WHERE nombre = ?;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, NuevoA2);
            preparedStatement.setString(2, ViejoA2);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void updateContactoG(String ViejoG, String NuevoG) {
        String sql = "UPDATE contacto SET grupo = ? WHERE nombre = ?;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, NuevoG);
            preparedStatement.setString(2, ViejoG);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void updateContactonT(String ViejonT, String NuevonT) {
        String sql = "UPDATE contacto SET nTelefono = ? WHERE nombre = ?;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, NuevonT);
            preparedStatement.setString(2, ViejonT);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void updateContactoE(String ViejoE, String NuevoE) {
        String sql = "UPDATE contacto SET eMail = ? WHERE nombre = ?;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, NuevoE);
            preparedStatement.setString(2, ViejoE);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void updateContactoD(String ViejaD, String NuevaD) {
        String sql = "UPDATE contacto SET direccion = ? WHERE nombre = ?;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, NuevaD);
            preparedStatement.setString(2,ViejaD);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void updateContactoF(String ViejaF, String NuevaF) {
        String sql = "" +
                "UPDATE contacto SET fechaCumpleanyos = ? WHERE nombre = ?;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, NuevaF);
            preparedStatement.setString(2, ViejaF);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
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
        String sql = "SELECT * FROM contacto order by nombre";

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