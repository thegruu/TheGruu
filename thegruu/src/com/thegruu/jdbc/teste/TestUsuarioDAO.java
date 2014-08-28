package com.thegruu.jdbc.teste;

import java.util.List;
import java.util.Scanner;

import com.thegruu.entidades.Usuario;
import com.thegruu.jdbc.UsuarioDAO;



public class TestUsuarioDAO {

	public static void main(String[] args) {
		
		Scanner o = new Scanner(System.in);
		System.out.print("\nEscolha uma opção: \n"
				+ "1 - Inserir\n"
				+ "2 - Alterar\n"
				+ "3 - Excluir\n"
				+ "4 - Listar\n"
				+ "5 - Buscar por nome\n"
				+ "6 - Buscar por ID\n"
				+ "7 - Autenticar\n\n"
				+ "Opção: ");
		
		int op = o.nextInt();

		switch(op){
		
		case 1:
			testCadastrar();
			break;
		case 2:
			testAlterar();
			break;
//		case 3:
//			testExcluir();
//			break;
//		case 4:
//			testBuscarTodos();
//			break;
//		case 5:
//			testBuscarPorNome();
//			break;
//		case 6:
//			testBuscarPorId();
//			break;
//		case 7:
//			testAutenticar();
//			break;
		default:
			System.out.println("Opção inválida");
		
		}	

	}

	private static void testCadastrar() {
		
		Scanner k = new Scanner(System.in);
		System.out.println("Digite o nome: ");
		String nome = k.nextLine();
		System.out.println("Digite o Sobrenome: ");
		String sobrenome = k.nextLine();
		System.out.println("Digite o apelido: ");
		String apelido = k.nextLine();
		System.out.println("Digite data de nascimento: ");
		String nascimento = k.nextLine();
		System.out.println("Digite o sexo (M ou F): ");
		String sexo = k.nextLine();
		System.out.println("Digite o email: ");
		String email = k.nextLine();
		System.out.println("Digite a senha: ");
		String senha = k.nextLine();
		System.out.println("Digite a foto: ");
		String foto = k.nextLine();
		System.out.println("Digite a cidade: ");
		int cidade = k.nextInt();
		
		k.close();
		
		Usuario usu = new Usuario();
		usu.setNome(nome);
		usu.setSobrenome(sobrenome);
		usu.setApelido(apelido);
		usu.setNascimento(nascimento);
		usu.setSexo(sexo);
		usu.setEmail(email);
		usu.setSenha(senha);
		usu.setFoto(foto);
		usu.setCidade(cidade);
		
		UsuarioDAO usuDao = new UsuarioDAO();
		usuDao.cadastrar(usu);
	}
	
	private static void testAlterar(){
		
		System.out.println("ALTERAÇÃO DE CADASTRO");
		System.out.println("===========================================\n");
		
		Scanner ka = new Scanner(System.in);
		System.out.print("Digite o código: ");
		int id = ka.nextInt();
	
		Scanner ka2 = new Scanner(System.in);
		System.out.println("Digite o nome: ");
		String nome = ka2.nextLine();
		System.out.println("Digite o Sobrenome: ");
		String sobrenome = ka2.nextLine();
		System.out.println("Digite o apelido: ");
		String apelido = ka2.nextLine();
		System.out.println("Digite data de nascimento: ");
		String nascimento = ka2.nextLine();
		System.out.println("Digite o sexo (M ou F): ");
		String sexo = ka2.nextLine();
		System.out.println("Digite o email: ");
		String email = ka2.nextLine();
		System.out.println("Digite a senha: ");
		String senha = ka2.nextLine();
		System.out.println("Digite a foto: ");
		String foto = ka2.nextLine();
		System.out.println("Digite a cidade: ");
		int cidade = ka2.nextInt();
	
		Usuario usu = new Usuario();
		usu.setId(id);
		usu.setNome(nome);
		usu.setSobrenome(sobrenome);
		usu.setApelido(apelido);
		usu.setNascimento(nascimento);
		usu.setSexo(sexo);
		usu.setEmail(email);
		usu.setSenha(senha);
		usu.setFoto(foto);
		usu.setCidade(cidade);
		
		UsuarioDAO usuDao = new UsuarioDAO();
		usuDao.alterar(usu);
		
		
	}
//	
//	private static void testExcluir(){
//		
//		System.out.println("EXCLUSAO DE CADASTRO");
//		System.out.println("===========================================\n");
//		
//		Scanner ke = new Scanner(System.in);
//		System.out.print("Digite o código: ");
//		int id = ke.nextInt();
//		
//		Usuario usu = new Usuario();
//		usu.setId(id);
//
//		UsuarioDAO usuDao = new UsuarioDAO();
//		usuDao.excluir(usu);
//		
//	}
//	
//	private static void testBuscarTodos(){
//		
//		UsuarioDAO usuDao = new UsuarioDAO();
//		List<Usuario> listaResultado = usuDao.buscarTodos();
//		
//		System.out.println("LISTAGEM DE CADASTROS");
//		System.out.println("======================================================================================\n");
//	
//		for(Usuario u : listaResultado){
//			System.out.println(u.getId() + " - " + u.getNome() + " - " + u.getLogin() + " - " + u.getSenha());
//		}
//		
//
//		
//	}
//	
//	private static void testBuscarPorNome(){
//		
//		System.out.println("LISTAGEM DE CADASTROS POR NOME");
//		System.out.println("======================================================================================\n");
//		
//		Scanner kn = new Scanner(System.in);
//		System.out.print("Digite o nome: ");
//		String nome = kn.nextLine();
//		
//		UsuarioDAO usuDao = new UsuarioDAO();
//		List<Usuario> listaResultado = usuDao.buscaPorNome(nome);
//		
//		for(Usuario u : listaResultado){
//			
//			System.out.println(u.getId() + " - " + u.getNome() + " - " + u.getLogin() + " - " + u.getSenha());
//		}
//		
//
//		
//	}
//	
//	private static void testBuscarPorId(){
//		
//		System.out.println("LISTAGEM DE CADASTROS POR ID");
//		System.out.println("======================================================================================\n");
//		
//		Scanner ki = new Scanner(System.in);
//		System.out.print("Digite o ID: ");
//		Integer id = ki.nextInt();
//		
//		UsuarioDAO usuDao = new UsuarioDAO();
//		Usuario usu = usuDao.buscaPorId(id);
//		if(usu != null){
//			System.out.println(usu.getId() + " - " + usu.getNome() + " - " + usu.getLogin() + " - " + usu.getSenha());
//		}else{
//			System.out.println("Registro não encontrado.");
//		}
//		
//	
//		
//
//		
//	}
//	
//	public static void testAutenticar(){
//		
//		System.out.println("AUTENTICAÇÃO");
//		System.out.println("======================================================================================\n");
//		
//		Scanner ka = new Scanner(System.in);
//		System.out.print("Digite o login: ");
//		String login = ka.nextLine();
//		System.out.print("Digite a senha: ");
//		String senha = ka.nextLine();
//		
//		Usuario usuario = new Usuario();
//		usuario.setLogin(login);
//		usuario.setSenha(senha);
//		
//		UsuarioDAO usuDAO = new UsuarioDAO();
//		System.out.println(usuDAO.autenticar(usuario));
//		
//		
//	}
	


}