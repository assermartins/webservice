package br.com.webservice.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.webservice.controller.AtendimentoController;
import br.com.webservice.model.Atendimento;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

@Path("/atendimento")
public class AtendimentoResource {

	@GET
	@Path("/listarTodos")
	@Produces("application/json; charset=UTF-8")
	public List<Atendimento> listarTodos() {
		return new AtendimentoController().listarTodos();
	}

	@POST
	@Path("/inserir")
	@Produces("application/json")
	@Consumes("application/json")
	public String inserir(String listaJson) {

		Gson gson = new Gson();
		Atendimento atendimentoJson = gson.fromJson(listaJson,
				Atendimento.class);
		System.out.println("Latidude: " + atendimentoJson.getLatitude());

		return new AtendimentoController().adiciona(atendimentoJson);

	}

	@POST
	@Path("/inserirLista")
	@Produces("application/json")
	@Consumes("application/json")
	public String inserirLista(String listaAtendimentosJson) {

		Gson gson = new Gson();
		List<Atendimento> atendimentos = new ArrayList<Atendimento>();
		JsonParser parser = new JsonParser();
		JsonArray array = parser.parse(listaAtendimentosJson).getAsJsonArray();

		for (int i = 0; i < array.size(); i++) {
			atendimentos.add(gson.fromJson(array.get(i), Atendimento.class));
		}

		return new AtendimentoController().inserirLista(atendimentos);

	}

}
