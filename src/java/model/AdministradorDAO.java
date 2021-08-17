package model;

import aplicacao.Administradores;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "AdministradorDAO", urlPatterns = {"/AdministradorDAO"})
public class AdministradorDAO extends HttpServlet {

  private Connection conexao;
    public AdministradorDAO() {
        try {
            // Cria a conexão com o banco de dados
            conexao = Conexao.criaConexao();
        }
        catch( Exception e ) {
            System.out.println("Erro criação de conexao DAO");
            System.out.println(e);
        }
    }
    
    public boolean login(String login, String senha){
        try {
            Administradores Administrador = new Administradores();
            String sql = "SELECT * FROM administradores WHERE cpf = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, login);
            
            ResultSet rs = ps.executeQuery();
            
            if ( rs.next() ) {
                Administrador.setId(rs.getInt("id"));
                Administrador.setCpf( rs.getString("cpf") );
                Administrador.setSenha( rs.getString("senha") );
                Boolean senhaIgual = Administrador.getSenha().equals(senha);
                if(senhaIgual)
                    return true;
            }
        }
        catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return false;
    }
    
    public ArrayList<Administradores> getLista() {
        ArrayList<Administradores> resultado = new ArrayList<>();
        try {            
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery("select * from administradores");
            while( rs.next() ) {
                Administradores administrador = new Administradores();
                
                administrador.setId(rs.getInt("id") );
                administrador.setNome( rs.getString("nome") );
                administrador.setCpf( rs.getString("cpf") );

                resultado.add(administrador);
            }
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        
        return resultado;
    }
    
    public Administradores getAdministradorPorID( int codigo ) {
        Administradores administrador = new Administradores();
        try {
            String sql = "SELECT * FROM administradores WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, codigo);
            
            ResultSet rs = ps.executeQuery();
            
            if ( rs.next() ) {
                administrador.setId(rs.getInt("id"));
                administrador.setNome( rs.getString("nome") );
                administrador.setCpf( rs.getString("cpf") );
            }
            
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return administrador;
    }
    
    public boolean gravar( Administradores administrador ) {
        try {
            String sql;
            if ( administrador.getId() == 0 ) {
                sql = "INSERT INTO administradores (nome, cpf, senha) VALUES (?,?,?)";
            } else {
                sql = "UPDATE administradores SET nome=?, cpf=?, senha=? WHERE id=?";
            }
            
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, administrador.getNome());
            ps.setString(2, administrador.getCpf());            
            ps.setString(3, administrador.getSenha());
            if ( administrador.getId()> 0 )
                ps.setInt(4, administrador.getId());
            
            ps.execute();
            
            return true;
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return false;
        }
    }
    
    public boolean excluir( int id ) {
        try {
            String sql = "DELETE FROM administradores WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return false;
        }
    }
}
