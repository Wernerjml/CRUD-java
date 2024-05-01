package com.umg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.umg.connection.MariaDBConnection;

public class Delete {

	public static void main(String[] args) {
		
	}
		//Metodo para eliminar un registro de estudiante
	    public static boolean estudiante (int idestudiante) {

	        Connection conn = MariaDBConnection.getConnection();

	        if (conn != null) {

	            try {

	                String consulta = "DELETE FROM estudiantes WHERE idestudiante = ?";

	                PreparedStatement statement = conn.prepareStatement(consulta);

	                statement.setInt (1, idestudiante);

	                int filasEliminadas = statement.executeUpdate();

	                statement.close();

	                conn.close();

	                return filasEliminadas > 0;

	            } catch (SQLException e) {

	                System.out.println("Error al eliminar cliente: " + e.getMessage());

	                return false;

	            }

	        } else {

	            System.out.println("No se pudo establecer la conexión.");

	            return false;

	        }

	    }

	}
