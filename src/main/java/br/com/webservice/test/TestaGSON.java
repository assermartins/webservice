package br.com.webservice.test;

import java.util.ArrayList;
import java.util.List;

import br.com.webservice.model.Atendimento;

import com.google.gson.Gson;

public class TestaGSON {
	
	public static void main(String[] args) {
		Atendimento a1 = new Atendimento();
		
		a1.setId(1);
		a1.setLatitude("123");
		a1.setLongitude("321");
		a1.setPontoReferencia("Proximo ao Proximo");
		a1.setResolvido(false);
		a1.setSinistro("Dengue");
		
		Atendimento a2 = new Atendimento();
		
		a2.setId(1);
		a2.setLatitude("123");
		a2.setLongitude("321");
		a2.setPontoReferencia("Proximo ao Proximo");
		a2.setResolvido(false);
		a2.setSinistro("Dengue");
		
		List<Atendimento> atendimentos = new ArrayList<Atendimento>();
		atendimentos.add(a1);
		atendimentos.add(a2);
		
		Gson gson = new Gson();
		
		String json = gson.toJson(atendimentos);
		System.out.println(json);
	}

}
