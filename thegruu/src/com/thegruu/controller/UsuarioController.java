package com.thegruu.controller;

import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thegruu.entidades.Usuario;
import com.thegruu.jdbc.UsuarioDAO;

@WebServlet("/usucontroller.do")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UsuarioController() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Chamando método GET");
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Chamando método POST");
		
		//recebe dados da tela
		String nome = request.getParameter("txtnome");
		String sobrenome = request.getParameter("txtsobrenome");
		String apelido = request.getParameter("txtapelido");
		String nascimento = request.getParameter("dtnascimento");
		String sexo = request.getParameter("txtsexo");
		int cidade = Integer.parseInt(request.getParameter("intcidade"));
		String email = request.getParameter("txtemail");
		String senha = request.getParameter("passenha");
		String foto = request.getParameter("txtfoto");
		
		//cria o objeto ususario e seta os valores vindo da tela
		Usuario usuario = new Usuario();
		
		usuario.setNome(nome);
		usuario.setSobrenome(sobrenome);
		usuario.setApelido(apelido);
		usuario.setNascimento(nascimento);
		usuario.setSexo(sexo);
		usuario.setCidade(cidade);
		usuario.setEmail(email);
		usuario.setSenha(senha);
		usuario.setFoto(foto);
		
		//pede para o usuarioDAO cadastrar no banco de dados.
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.cadastrar(usuario);
		
		//saida no browser
		PrintWriter saida = response.getWriter();
		saida.print("Cadastrado com sucesso!");
	}

}
