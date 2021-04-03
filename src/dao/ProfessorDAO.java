package dao;

import beans.Professor;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ProfessorDAO {
    private Conexao conexao;
    private Connection conn;
    
    public ProfessorDAO (){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public void inserir(Professor prof){
        String sql = "INSERT INTO prof_table(nome_prof) VALUES "
                   + "(?)";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, prof.getNOME_PROF());
            stmt.execute();
            JOptionPane.showMessageDialog(null,"Inserção realizada com sucesso!","Atenção", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir curso:" + e.getMessage());
        }
    }
    
    public void excluir(int cod_prof){
        try {
            String sql;
            PreparedStatement stmt;
            sql = "UPDATE aula_table SET COD_PROF = -1 WHERE COD_PROF = ?";
            stmt = this.conn.prepareStatement(sql);
            stmt.setString(1,String.valueOf(cod_prof));
            stmt.execute();
            sql = "DELETE FROM prof_table WHERE COD_PROF = ?";
            stmt = this.conn.prepareStatement(sql);
            stmt.setString(1,String.valueOf(cod_prof));
            stmt.execute();
            JOptionPane.showMessageDialog(null,"Exclusão realizada com sucesso!","Atenção", JOptionPane.INFORMATION_MESSAGE);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar aula: " + e.getMessage());
        }
    }
    
    public void atualiza(Professor professor){
        try {
            String sql;
            sql = "UPDATE prof_table SET nome_prof = ? WHERE COD_PROF = ?";
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, professor.getNOME_PROF());
            stmt.setInt(2, professor.getCOD_PROF());
            stmt.execute();
            JOptionPane.showMessageDialog(null,"Update realizado com sucesso!","Atenção", JOptionPane.INFORMATION_MESSAGE);
        } catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar professor: " + e.getMessage());
        }
    }
    
    public List<Professor> getProfessor(Professor prof, int opcao){ //pega um por com filtro
        String sql;
        switch (opcao) {
            case 0:
              sql = "SELECT * FROM prof_table WHERE COD_PROF = ?";
              break;
            case 1:
              sql = "SELECT * FROM prof_table WHERE nome_prof like ?";
              break;
            default:
              sql = "SELECT * FROM prof_table";
              break;
        }
        
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            switch (opcao) {
            case 0:
              stmt.setInt(1, prof.getCOD_PROF());
              break;
            case 1:
              stmt.setString(1,"%" + prof.getNOME_PROF() + "%");
              break;
            default:
              //nada 
              break;
            }    
            
            ResultSet rs = stmt.executeQuery();
            List<Professor> listaProfessores = new ArrayList<>();
            
            while(rs.next()){
                Professor profzinho = new Professor();
                profzinho.setCOD_PROF(rs.getInt("COD_PROF"));
                profzinho.setNOME_PROF(rs.getString("NOME_PROF"));
                listaProfessores.add(profzinho);
            }
            
            return listaProfessores;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao selecionar professor: " + e.getMessage());
            return null;
        }
    }
    
    public List<Professor> getProfessores()//pega a lista de tudo
    {
        String sql = "SELECT * FROM prof_table";
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            List<Professor> listaProf = new ArrayList<>();
            
            while(rs.next()){
                Professor prof = new Professor();
                prof.setCOD_PROF(rs.getInt("COD_PROF"));
                prof.setNOME_PROF(rs.getString("NOME_PROF"));
                listaProf.add(prof);
            }
            
            return listaProf;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro ao selecionar os professores: " + e.getMessage());
            return null;
        }
    }
}
