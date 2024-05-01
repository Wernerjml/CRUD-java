package com.umg.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.umg.connection.MariaDBConnection;

public class Select {

	public static void main(String[] args) {
		// Metodo para consultar la tabla estudiantes de la DB colegio
		leerSelect();
	}
	    public static void leerSelect() {
	        Connection conn = MariaDBConnection.getConnection();
	        if (conn != null) {
	            try {
	                String consulta = "SELECT * FROM estudiantes";
	                PreparedStatement statement = conn.prepareStatement(consulta);
	                ResultSet resultSet = statement.executeQuery();
	                while (resultSet.next()) {
	                    int idEstudiante = resultSet.getInt("idestudiante");
	                    String primerNombre = resultSet.getString("primernombre");
	                    String segundoNombre = resultSet.getString("segundonombre");
	                    String primerApellido = resultSet.getString("primerapellido");
	                    String segundoApellido = resultSet.getString("segundoapellido");
	                    String genero = resultSet.getString("genero");
	                    String fechaNacimiento = resultSet.getString("fecha_nacimiento");
	                    String telefono = resultSet.getString("telefono");
	                    String dpi = resultSet.getString("dpi");
	                    String colegiatura = resultSet.getString("colegiatura");
	                    String fechaCreacion = resultSet.getString("fecha_creacion");
	                    String usuarioCreacion = resultSet.getString("usuario_creacion");
	                    System.out.println("ID: " + idEstudiante + ",  Primer Nombre: " + primerNombre + ", Segundo Nombre: " + segundoNombre + ", Primer Apellido: " + primerApellido + ", Segundo Apellido: " + segundoApellido + ", Genero: " + genero + ", Fecha de Nacimiento: " + fechaNacimiento + ", Tel: " +  telefono + ", DPI: " + dpi + ", Colegiatura: " + colegiatura + ", Fecha de Creacion: " + fechaCreacion + ", Usuario Creacion: " + usuarioCreacion);
	                }
	                resultSet.close();
	                statement.close();
	                conn.close();
	            } catch (SQLException e) {
	                System.out.println("Error al leer clientes: " + e.getMessage());
	            }
	        } else {
	            System.out.println("No se pudo establecer la conexión.");
	        }
	    }
}

