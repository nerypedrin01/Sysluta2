package br.com.pedro.sysluta.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.pedro.sysluta.domain.Professor;
import br.com.pedro.sysluta.persistence.ConnectionFactory;

public class ProfessorDao {

	private static Connection conn = ConnectionFactory.getConexaoMySQL();

	public static void insere(Professor professor) throws SQLException {

			String inserir = "INSERT INTO professor (nome, cpf, dataNascimento) values(?,?,?)";
			PreparedStatement pst = conn.prepareStatement(inserir);

			pst.setString(1, professor.getNome());
			pst.setString(2, professor.getCpf());
			pst.setString(3, professor.getDataNascimento());

			pst.executeUpdate();

	}

	public static void atualizaprofessor(Professor professor) throws SQLException {

			String inserir = "UPDATE professor SET nome = ?, dataNascimento = ? , cpf = ? WHERE id_professor = ?";
			PreparedStatement pst = conn.prepareStatement(inserir);

			pst.setString(1, professor.getNome());
			pst.setString(2, professor.getDataNascimento());
			pst.setString(3, professor.getCpf());
			pst.setInt(4, professor.getIdProfessor());

			pst.executeUpdate();

	}

	public static void romoveProfessor(Professor professor) throws SQLException {

			String inserir = "DELETE FROM professor WHERE id_professor = ?";
			PreparedStatement pst = conn.prepareStatement(inserir);
			pst.setInt(1, professor.getIdProfessor());
			pst.executeUpdate();
	}

}
