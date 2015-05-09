package br.com.webservice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.webservice.jdbc.ConnectionFactory;

import br.com.webservice.model.Atendimento;

public class AtendimentoDAO {

	private Connection connection;
	private int sucesso;
	private static AtendimentoDAO instance;

	public static AtendimentoDAO getInstance() {

		if (instance == null)
			instance = new AtendimentoDAO(ConnectionFactory.getConnection());
		return instance;

	}

	public AtendimentoDAO(Connection connection) {
		this.connection = connection;

	}

	public int adiciona(Atendimento atendimento) {

		try {
			String sql = "insert into Atendimento (latitude, longitude, ponto_referencia, sinistro, resolvido)"
					+ " values (?, ?, ?, ?, ?)";
			PreparedStatement ps = this.connection.prepareStatement(sql);
			ps.setString(1, atendimento.getLatitude());
			ps.setString(2, atendimento.getLongitude());
			ps.setString(3, atendimento.getPontoReferencia());
			ps.setString(4, atendimento.getSinistro());
			ps.setBoolean(5, atendimento.isResolvido());

			sucesso = ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return sucesso;
	}

	public List<Atendimento> lista() {
		try {
			PreparedStatement ps = this.connection
					.prepareStatement("select * from Atendimento");
			ResultSet rs = ps.executeQuery();

			List<Atendimento> atendimentos = new ArrayList<Atendimento>();
			while (rs.next()) {
				Atendimento atendimento = new Atendimento();
				atendimento.setId(rs.getInt("id"));
				atendimento.setLatitude(rs.getString("latitude"));
				atendimento.setLongitude(rs.getString("longitude"));
				atendimento
						.setPontoReferencia(rs.getString("ponto_referencia"));
				atendimento.setSinistro(rs.getString("sinistro"));
				atendimento.setResolvido(rs.getBoolean("resolvido"));

				atendimentos.add(atendimento);
			}
			rs.close();
			return atendimentos;

		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

}
