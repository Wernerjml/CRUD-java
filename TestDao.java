package com.umg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.umg.connection.MariaDBConnection;

public class TestDao {

	 // Método para crear un nuevo estudiante

    public static boolean estudiante( String primernombre, String segundonombre, 
    		String primerapellido,String segundoapellido, String genero, String fecha_nacimiento, String telefono, String dpi, String colegiatura, String usuario_creacion) {

        Connection conn = MariaDBConnection.getConnection();

        if (conn != null) {

            try {

                String consulta = "INSERT INTO estudiantes (primernombre, segundonombre, primerapellido, segundoapellido, genero, fecha_nacimiento, telefono, dpi, colegiatura, usuario_creacion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

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

                int filasInsertadas = statement.executeUpdate();
                
                System.out.println("Registro creado: " + filasInsertadas);

                statement.close();

                conn.close();

                return filasInsertadas > 0;

            } catch (SQLException e) {

                System.out.println("Error al crear estudiante: " + e.getMessage());

                return false;

            }

        } else {

            System.out.println("No se pudo establecer la conexión.");

            return false;

        }
        
    }
   
}
