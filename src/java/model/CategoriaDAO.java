package model;

import aplicacao.Categorias;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "CategoriaDAO", urlPatterns = {"/CategoriaDAO"})
public class CategoriaDAO extends HttpServlet {

  private Connection conexao;
    public CategoriaDAO() {
        try {
            // Cria a conexão com o banco de dados
            conexao = Conexao.criaConexao();
        }
        catch( Exception e ) {
            System.out.println("Erro criação de conexao DAO");
            System.out.println(e);
        }
    }
    
    public ArrayList<Categorias> getLista() {
        ArrayList<Categorias> resultado = new ArrayList<>();
        try {            
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery("select * from categoria");
            while( rs.next() ) {
                Categorias Categoria = new Categorias();
                
                Categoria.setId(rs.getInt("id") );
                Categoria.setDescricao( rs.getString("descricao") );

                resultado.add(Categoria);
              
            }
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        
       
        return resultado;
    }
    
    public Categorias getCategoriaPorID( int codigo ) {
        Categorias Categoria = new Categorias();
        try {
            String sql = "SELECT * FROM categorias WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, codigo);
            
            ResultSet rs = ps.executeQuery();
            
            if ( rs.next() ) {
                Categoria.setId(rs.getInt("id"));
                Categoria.setDescricao( rs.getString("descricao") );
                
            }
            
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }

        return Categoria;
    }
    
    public boolean gravar( Categorias Categoria ) {
        try {
            String sql;
            if ( Categoria.getId() == 0 ) {
                sql = "INSERT INTO categorias (descricao) VALUES (?,?,?)";
            } else {
                sql = "UPDATE categorias SET descricao=? WHERE id=?";
            }
            
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, Categoria.getDescricao());
          
            if ( Categoria.getId()> 0 )
                ps.setInt(4, Categoria.getId());
            
            ps.execute();
            
            return true;
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return false;
        }
    }
    
    public boolean excluir( int id ) {
        try {
            String sql = "DELETE FROM categorias WHERE id = ?";
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
