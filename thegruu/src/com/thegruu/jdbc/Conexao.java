package com.thegruu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Classe de conexão com o banco de dados
 * 
 */


public class Conexao {
	
	/*
	 * método getConection, que executa a conexão com o banco de dados
	 */
	public static Connection getConnection(){
		Connection con=null;
		
		/*
		 * try/catch para tratamento de eventuais erros de conexão 
		 */
		try { 
			Class.forName("com.mysql.jdbc.Driver");
			
			/*
			 * método getConnection da classe DriverMannager recebe os dados para a conexão com o banco de dados e atribui-os
			 * à variável con
			 */
			con =  DriverManager.getConnection("jdbc:mysql://localhost/thegruu", "root", "geracaotec"); 
			
			System.out.println("Conectado com sucesso!");
			
		} catch (SQLException | ClassNotFoundException e) {
			
			System.out.println("Não pode conectar: "+e.getMessage());
		}
		
		return con;
		
	}

}
