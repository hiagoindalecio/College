package dao;

import beans.GeneralObject;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class GeneralDAO {
    private Conexao conexao;
    private Connection conn;
    
    public GeneralDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public List<GeneralObject> getAulasPlusProfs()//pega a lista de tudo
    {
        String sql = "SELECT * FROM aula_table a INNER JOIN prof_table p ON a.COD_PROF = p.COD_PROF";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            List<GeneralObject> listaAll = new ArrayList<>();
            
            while(rs.next()){
                GeneralObject obj = new GeneralObject();
                obj.setCOD_AULA(rs.getInt("COD_AULA"));
                obj.setNOME_AULA(rs.getString("NOME_AULA"));
                obj.setDESC_AULA(rs.getString("DESC_AULA"));
                obj.setCOD_PROF(rs.getInt("COD_PROF"));
                obj.setNOME_PROF(rs.getString("NOME_PROF"));
                listaAll.add(obj);
            }
            
            return listaAll;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao selecionar os aulas: " + e.getMessage());
            return null;
        }
    }
}
