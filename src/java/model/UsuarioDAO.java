package model;

import aplicacao.Usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "UsuarioDAO", urlPatterns = {"/UsuarioDAO"})
public class UsuarioDAO extends HttpServlet {

    private Connection conexao;

    public UsuarioDAO() {
        try {
            // Cria a conexão com o banco de dados
            conexao = Conexao.criaConexao();
        } catch (Exception e) {
            System.out.println("Erro criação de conexao DAO");
            System.out.println(e);
        }
    }

    public ArrayList<Usuarios> getLista() {
        ArrayList<Usuarios> resultado = new ArrayList<>();
        try {
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery("select * from usuarios");
            while (rs.next()) {
                Usuarios usuario = new Usuarios();

                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setCpf(rs.getString("cpf"));
                usuario.setSuspenso(rs.getString("suspenso"));

                resultado.add(usuario);
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }

        return resultado;
    }

    public Usuarios getUsuarioPorID(int codigo) {
        Usuarios usuario = new Usuarios();
        try {
            String sql = "SELECT * FROM usuarios WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, codigo);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setCpf(rs.getString("cpf"));
                usuario.setSenha(rs.getString("senha"));

                usuario.setSuspenso(rs.getString("suspenso"));
            }

        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return usuario;
    }

    public boolean gravar(Usuarios usuario) {
        try {
            String sql;
            if (usuario.getId() == 0) {
                sql = "INSERT INTO usuarios (nome, cpf, senha, suspenso) VALUES (?,?,?,?)";
            } else {
                sql = "UPDATE usuarios SET nome=?, cpf=?, senha=?, suspenso=? WHERE id=?";
            }

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getCpf());
            ps.setString(3, usuario.getSenha());
            ps.setString(4, usuario.getSuspenso());
            if (usuario.getId() > 0) {
                ps.setInt(5, usuario.getId());
            }

            ps.execute();

            return true;
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return false;
        }
    }

    public boolean alterarSituacao(int id, boolean ativar) {
        try {
            String sql = "UPDATE usuarios SET suspenso = ? WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            if (ativar) {
                ps.setString(1, "N");
            } else {
                ps.setString(1, "S");
            }
            ps.setInt(2, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return false;
        }
    }

    public boolean excluir(int id) {
        try {
            String sql = "DELETE FROM usuarios WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return false;
        }
    }
}
