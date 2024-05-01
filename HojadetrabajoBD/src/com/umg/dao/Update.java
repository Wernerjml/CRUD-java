package com.umg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.umg.connection.MariaDBConnection;

public class Update {

	public static void main(String[] args) {
		// Metodo para actualizar un registro

	}	
		public static boolean estudiante (int idEstudiante, String primernombre, String segundonombre, String primerapellido, String segundoapellido, String genero, String fecha_nacimiento, String telefono, String dpi, String colegiatura, String usuario_creacion) {
		
		Connection conn = MariaDBConnection.getConnection();

        if (conn != null) {

            try {

                String consulta = "UPDATE estudiantes SET primernombre = ?, segundonombre = ?, primerapellido = ?, segundoapellido = ?, genero = ?, fecha_nacimiento = ?, telefono = ?, dpi = ?, colegiatura = ?, usuario_creacion = ? WHERE idestudiante ="+idEstudiante;

                PreparedStatement statement = conn.prepareStatement(consulta);
                               
                
                statement.setString(1, primernombre);
                statement.setString(2, segundonombre);
                statement.setString(3, primerapellido );
                statement.setString(4, segundoapellido );
                statement.setString(5, genero);
                statement.setString(6, fecha_nacimiento );
                statement.setString(7, telefono);
                statement.setString(8, dpi);
                statement.setString(9, colegiatura);
                statement.setString(10, usuario_creacion);
                

                int filasActualizadas = statement.executeUpdate();

                statement.close();

                conn.close();

                return filasActualizadas > 0;

            } catch (SQLException e) {

                System.out.println("Error al actualizar estudiante: " + e.getMessage());

                return false;

            }

        } else {

            System.out.println("No se pudo establecer la conexión.");

            return false;

        }

    }
}