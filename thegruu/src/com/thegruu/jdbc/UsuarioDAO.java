package com.thegruu.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.thegruu.entidades.Usuario;

/*
 * Classe que contem os métodos de interação com o banco de dados (INSERT, UPDATE, DELETE E SEECT) 
 */

public class UsuarioDAO {
	
	//cria a conexao com o banco de dados
	private Connection con = Conexao.getConnection();
	
	//método que cadastra o usuário no banco de dados
	public void cadastrar(Usuario usuario){
		
		//string sql recebe o comando INSERT, com os campos da tabela e os valores como variáveis, que serão atribuídas pelo java
		String sql = "INSERT INTO TB_USUARIOS (nm_primeiro_nome, nm_sobrenome, nm_apelido, dt_nascimento, tp_sexo, cidade_id, ds_email, ds_senha, im_foto) "
				+ "values (?, ?, ?, ?, ?, ?, ?, md5(?), ?)";
		
		//constroi preparestatment com sql
		
		/*
		 * try/catch para tratamento de eventuais erros de inserção no banco
		 */
		try {
			//método prepareStatement de con recebe todos os parametros da busca sql e atibui-os à variável preparador
			PreparedStatement preparador = con.prepareStatement(sql);
			
			//método setString de preparador "seta" nas variáveis ? do código INSERT sql com os dados obtidos pelos metodos GET 
			//do objeto usuario recebido como parâmetro no método cadastrar
			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getSobrenome());
			preparador.setString(3, usuario.getApelido());
			preparador.setString(4, usuario.getNascimento());
			preparador.setString(5, usuario.getSexo());
			preparador.setInt(6, usuario.getCidade());
			preparador.setString(7, usuario.getEmail());
			preparador.setString(8, usuario.getSenha());
			preparador.setString(9, usuario.getFoto());
			
			//executa o preparador
			preparador.execute();
			
			//fecha o preparador
			preparador.close();
			
			System.out.println("Cadastrado com sucesso!");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	public void alterar(Usuario usuario){
		//monta sql
		String sql = "UPDATE TB_USUARIOS SET nm_primeiro_nome=?, nm_sobrenome=?, nm_apelido=?, dt_nascimento=?, "
				+ "tp_sexo=?, cidade_id=?, ds_email=?, ds_senha=md5(?), im_foto=? WHERE id_usuario=?";
		//constroi preparestatment com sql
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			
			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getSobrenome());
			preparador.setString(3, usuario.getApelido());
			preparador.setString(4, usuario.getNascimento());
			preparador.setString(5, usuario.getSexo());
			preparador.setInt(6, usuario.getCidade());
			preparador.setString(7, usuario.getEmail());
			preparador.setString(8, usuario.getSenha());
			preparador.setString(9, usuario.getFoto());
			preparador.setInt(10, usuario.getId());
			
			preparador.execute();
			preparador.close();
			
			System.out.println("Usuario Aletrado com Sucesso!");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

//	
//	public void excluir(Usuario usuario){
//		//monta sql
//		String sql = "DELETE FROM USUARIOS WHERE id=?";
//		//constroi preparestatment com sql
//		try {
//			PreparedStatement preparador = con.prepareStatement(sql);
//			preparador.setInt(1, usuario.getId());
//			
//			preparador.execute();
//			preparador.close();
//			
//			System.out.println("Excluído!");
//			
//		} catch (SQLException e) {
//			
//			e.printStackTrace();
//		}
//	}
//	
	public List<Usuario> buscarTodos(){
		//monta sql
		String sql = "SELECT * FROM TB_USUARIOS";
		//constroi preparestatment com sql
		List<Usuario> lista = new ArrayList<Usuario>();
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			
			ResultSet resultado = preparador.executeQuery();
			
			while(resultado.next()){
				
				Usuario usu = new Usuario();
				
				usu.setId(resultado.getInt("id_usuario")); //valor da coluna id
				usu.setNome(resultado.getString("nm_primeiro_nome")); //valor da coluna nome
				usu.setSobrenome(resultado.getString("nm_sobrenome")); //valor da coluna login
				usu.setApelido(resultado.getString("nm_apelido")); //valor da coluna senha
				usu.setNascimento(resultado.getString("dt_nascimento"));
				usu.setSexo(resultado.getString("tp_sexo"));
				usu.setCidade(resultado.getInt("cidade_id"));
				usu.setEmail(resultado.getString("ds_email"));
				usu.setSenha(resultado.getString("ds_senha"));
				usu.setFoto(resultado.getString("im_foto"));
				
				lista.add(usu);
			}
			
			preparador.close();
			
			System.out.println("Lista de Usuários");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return lista;
	}
//	
//	public Usuario buscaPorId(Integer id){
//		/*
//		 * 1º CRIAR MÉTODO QUE RECEBE O ID
//		 * 2º MONTAR UM SQL E JOGAR O ID DENTRO DELE (PREPAREDSTATEMENT)
//		 * 3º EXECUTAR O SQL NO BANCO (RESULTSET)
//		 * 4º PEGAR O RESULTADO E COLOCAR NUM OBJETO DO TIPO USUÁRIO
//		 * 5º RETORNAR O USUÁRIO
//		 */
//		
//		
//		//QUERY DE BUSCA SQL
//		String sql = "SELECT * FROM Usuarios WHERE ID=?";
//		
//		//OBJETO DO TIPO USUARIO QUE RECEBERA O RESULTADO DA BUSCA
//		Usuario usu = null;
//		try {
//			
//			//VARIAVEL QUE RECEBERA O RESULTADO DA BUSCA 
//			PreparedStatement preparador = con.prepareStatement(sql);
//			
//			//PREPARADOR ATRIBUI O VALOR DO PARAMETRO id NA SINTAXE SQL ACIMA
//			preparador.setInt(1, id);
//			
//			//RESUTSET QUE RECEBERÁ O RESULTADO DA BUSCA SQL 
//			ResultSet resultado = preparador.executeQuery();
//			
//			/*
//			 * O resultado.next() nos colocará no primeiro daquele resulatdo.
//			 * Ele retorna true ou false.
//			 * Nesse caso, ele lê o primeiro registro e executa o bloco do if, depois tenta
//			 * ler o próximo registro (next) e , se não encontrar outro registro, retorna false
//			 * e sai do bloco if.
//			*/
//			if(resultado.next()){
//				
//				//CRIAÇÃO DO OBJETO DO TIPO USUARIO
//				usu = new Usuario();
//				
//				//SETANDO NO OBJETO USU CADA UM DOS DADOS CONTIDOS NO RESULTADO
//				usu.setId(resultado.getInt("id")); //valor da coluna id
//				usu.setNome(resultado.getString("nome")); //valor da coluna nome
//				usu.setLogin(resultado.getString("login")); //valor da coluna login
//				usu.setSenha(resultado.getString("senha")); //valor da coluna senha
//				
//			}
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			System.out.println("REgistro não encontrado!");
//			e.printStackTrace();
//		}
//		return usu;
//		
//	}
//	
//	public List<Usuario> buscaPorNome(String nome){
//
//		String sql = "SELECT * FROM Usuarios WHERE nome like ?";
//		
//		List<Usuario> lista = new ArrayList<Usuario>();
//		try {
//			
//			PreparedStatement preparador = con.prepareStatement(sql);
//			
//			preparador.setString(1, "%" + nome + "%");
//			 
//			ResultSet resultado = preparador.executeQuery();
//
//			while(resultado.next()){
//				
//				Usuario usu = new Usuario();
//				usu.setId(resultado.getInt("id")); //valor da coluna id
//				usu.setNome(resultado.getString("nome")); //valor da coluna nome
//				usu.setLogin(resultado.getString("login")); //valor da coluna login
//				usu.setSenha(resultado.getString("senha")); //valor da coluna senha
//				lista.add(usu);
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return lista;
//		
//	}
//	
//	public Usuario autenticar(Usuario usuario){
//
//		String sql = "SELECT * FROM Usuarios WHERE login = ? and senha = md5(?)";
//
//		Usuario usuRetorno = null;
//		try {
//			PreparedStatement preparador = con.prepareStatement(sql);
//			preparador.setString(1, usuario.getLogin());
//			preparador.setString(2, usuario.getSenha());
//			ResultSet resultado = preparador.executeQuery();
//
//			if(resultado.next()){
//				
//				usuRetorno = new Usuario();
//				usuRetorno.setId(resultado.getInt("id")); //valor da coluna id
//				usuRetorno.setNome(resultado.getString("nome")); //valor da coluna nome
//				usuRetorno.setLogin(resultado.getString("login")); //valor da coluna login
//				usuRetorno.setSenha(resultado.getString("senha")); //valor da coluna senha
//				
//			}
//			
//		} catch (SQLException e) {
//			System.out.println("REgistro não encontrado!");
//			e.printStackTrace();
//		}
//		return usuRetorno;
//		
//	}
//	
//	public Boolean verificaUsuario(Usuario usuario){
//
//		String sql = "SELECT * FROM Usuarios WHERE login = ?";
//		
//		boolean tem = false;
//		
//		try {
//			PreparedStatement preparador = con.prepareStatement(sql);
//
//			preparador.setString(1, usuario.getLogin());
//			 
//			ResultSet resultado = preparador.executeQuery();
//
//			tem = resultado.next();
//			
//		} catch (SQLException e) {
//			System.out.println("REgistro não encontrado!");
//			e.printStackTrace();
//		}
//		return tem;
//		
//	}

}
