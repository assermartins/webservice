package br.com.webservice.controller;

import java.sql.Connection;
import java.util.List;

import br.com.webservice.jdbc.ConnectionFactory;

import br.com.webservice.dao.AtendimentoDAO;
import br.com.webservice.model.Atendimento;

public class AtendimentoController {
	
	private Connection connection = null;

	public List<Atendimento> listarTodos(){
		return AtendimentoDAO.getInstance().lista();
	}
	
	public String adiciona(Atendimento atendimento){
		int adicionados = AtendimentoDAO.getInstance().adiciona(atendimento);	
		
		
		
		if( adicionados  > 0){
			return String.valueOf(adicionados)+" atendimento adicionado com sucesso";
		} else {
			return "Falha ao inserir o Atendimento no banco";
		}
		
	}
	
	 public String inserirLista(List<Atendimento> listaAtendimentos) {
		 connection  = ConnectionFactory.getConnection();
	     AtendimentoDAO dao = new AtendimentoDAO(connection);
	     String retorno = "";
	     
	     for (int i = 0; i < listaAtendimentos.size(); i++) {
	         if(dao.adiciona(listaAtendimentos.get(i)) < 1){
	             retorno += "Erro ao inserir o atendimento"+"\n";
	         }
	     }
	     if(retorno.length() == 0){
	         retorno = "Lista de atendimentos inserida no banco com sucesso!";
	     }
	     return retorno;
	    }

}
