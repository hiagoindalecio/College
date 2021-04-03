package dao;

import beans.Aula;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class AulaDAO {
    private Conexao conexao;
    private Connection conn;
    
    public AulaDAO (){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public void inserir(Aula aula){
        String sql = "INSERT INTO aula_table(nome_aula, desc_aula, cod_prof) VALUES "
                   + "(?, ?, -1)";
                //+ "(?, ?, ?)";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, aula.getNOME_AULA());
            stmt.setString(2, aula.getDESC_AULA());
            stmt.execute();
            JOptionPane.showMessageDialog(null,"Inserção realizada com sucesso!","Atenção", JOptionPane.INFORMATION_MESSAGE);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir aula: " + e.getMessage());
        }
    }
    
    public void excluir(int COD_AULA){
        try {
            String sql;
            sql = "DELETE FROM aula_table WHERE COD_AULA = ?";
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1,String.valueOf(COD_AULA));
            stmt.execute();
            JOptionPane.showMessageDialog(null,"Exclusão realizada com sucesso!","Atenção", JOptionPane.INFORMATION_MESSAGE);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar aula: " + e.getMessage());
        }
    }
    
    public void atualiza(Aula aula){
        try {
            String sql;
            sql = "UPDATE aula_table SET nome_aula = ?, desc_aula = ?, cod_prof = ? WHERE COD_AULA = ?";
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, aula.getNOME_AULA());
            stmt.setString(2, aula.getDESC_AULA());
            stmt.setString(3, Integer.toString(aula.getCOD_PROF()));
            stmt.setString(4,Integer.toString(aula.getCOD_AULA()));
            stmt.execute();
            JOptionPane.showMessageDialog(null,"Update realizado com sucesso!","Atenção", JOptionPane.INFORMATION_MESSAGE);
        } catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar aula: " + e.getMessage());
        }
    }
    
    public List<Aula> getAula(Aula aula, int opcao){ //pega um por com filtro
        String sql;
        switch (opcao) {
            case 1:
              sql = "SELECT * FROM aula_table WHERE COD_AULA = ?";
              break;
            case 2:
              sql = "SELECT * FROM aula_table WHERE nome_aula like ?";
              break;
            case 3:
              sql = "SELECT * FROM aula_table WHERE desc_aula like ?";
              break;
            default:
              sql = "SELECT * FROM aula_table";
              break;
        }
        
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            switch (opcao) {
            case 1:
              stmt.setInt(1, aula.getCOD_AULA());
              break;
            case 2:
              stmt.setString(1,"%" + aula.getNOME_AULA() + "%");
              break;
            case 3:
              stmt.setString(1,"%" + aula.getDESC_AULA() + "%");
              break;
            default:
              //nada lulz
              break;
            }    
            
            ResultSet rs = stmt.executeQuery();
            List<Aula> listaAulas = new ArrayList<>();
            
            while(rs.next()){
                Aula aulinha = new Aula();
                aulinha.setCOD_AULA(rs.getInt("COD_AULA"));
                aulinha.setNOME_AULA(rs.getString("NOME_AULA"));
                aulinha.setDESC_AULA(rs.getString("DESC_AULA"));
                aulinha.setCOD_PROF(rs.getInt("COD_PROF"));
                listaAulas.add(aulinha);
            }
            
            return listaAulas;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao selecionar aula: " + e.getMessage());
            return null;
        }
    }
    
    public List<Aula> getAulasByProf(int profCod){ //pega pelo prof
        String sql = "SELECT * FROM aula_table WHERE COD_PROF = ?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, profCod);  
            
            ResultSet rs = stmt.executeQuery();
            List<Aula> listaAulas = new ArrayList<>();
            
            while(rs.next()){
                Aula aulinha = new Aula();
                aulinha.setCOD_AULA(rs.getInt("COD_AULA"));
                aulinha.setNOME_AULA(rs.getString("NOME_AULA"));
                aulinha.setDESC_AULA(rs.getString("DESC_AULA"));
                listaAulas.add(aulinha);
            }
            
            return listaAulas;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao selecionar aulas: " + e.getMessage());
            return null;
        }
    }
    
    public List<Aula> getFreeAulas(){ //pega todas sem prof
        String sql = "SELECT * FROM aula_table WHERE COD_PROF = ?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, "-1");
            ResultSet rs = stmt.executeQuery();
            List<Aula> listaAulas = new ArrayList<>();
            
            while(rs.next()){
                Aula aulinha = new Aula();
                aulinha.setCOD_AULA(rs.getInt("COD_AULA"));
                aulinha.setNOME_AULA(rs.getString("NOME_AULA"));
                aulinha.setDESC_AULA(rs.getString("DESC_AULA"));
                listaAulas.add(aulinha);
            }
            
            return listaAulas;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao selecionar aulas: " + e.getMessage());
            return null;
        }
    }
    
    public List<Aula> getAulas()//pega a lista de tudo
    {
        String sql = "SELECT * FROM aula_table";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            List<Aula> listaAulas = new ArrayList<>();
            
            while(rs.next()){
                Aula aula = new Aula();
                aula.setCOD_AULA(rs.getInt("COD_AULA"));
                aula.setNOME_AULA(rs.getString("NOME_AULA"));
                aula.setDESC_AULA(rs.getString("DESC_AULA"));
                listaAulas.add(aula);
            }
            
            return listaAulas;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao selecionar os aulas: " + e.getMessage());
            return null;
        }
    }
}
