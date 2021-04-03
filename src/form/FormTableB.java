package form;

import beans.Aula;
import beans.Professor;
import dao.AulaDAO;
import dao.ProfessorDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Padre Fabio de Melo
 */

public class FormTableB extends javax.swing.JFrame {
    
    public FormTableB() {
        initComponents();
        atualizaTabela();
        lblCodProfessor.setVisible(false);
        lblCodProfPrev.setVisible(false);
    }
    
    private void atualizaTabela()
    {
        ProfessorDAO profDAO = new ProfessorDAO();
        List<Professor> listaProfessor = profDAO.getProfessores();
        carregaLista(listaProfessor);
    }
    
    private void carregaLista(List<Professor> listaProf){
        DefaultTableModel tabelaProfs = (DefaultTableModel) tblProf.getModel();
        tabelaProfs.setRowCount(0);//<- .CLEAR da table
        listaProf.stream().map((a) -> new Object[]{
            a.getCOD_PROF(),
            a.getNOME_PROF(),
        }).forEachOrdered((obj) -> {
            tabelaProfs.addRow(obj);//percorre a lista e vai crinado os objetos como row
        });
    }
    
    private void carregaListaAulas(List<Aula> listaAula){
        DefaultTableModel tabelaAulas = (DefaultTableModel) tblAulas.getModel();
        tabelaAulas.setRowCount(0);//<- .CLEAR da table
        listaAula.stream().map((a) -> new Object[]{
            a.getCOD_AULA(),
            a.getNOME_AULA(),
            a.getDESC_AULA()
        }).forEachOrdered((obj) -> {
            tabelaAulas.addRow(obj);//percorre a lista e vai crinado os objetos como row
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProf = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtNomeProfessor = new javax.swing.JTextField();
        btnInserir = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        txtPesquisa = new javax.swing.JTextField();
        cmbTipoPesquisa = new javax.swing.JComboBox<>();
        btnExcluir1 = new javax.swing.JButton();
        btnLimparPesquisa = new javax.swing.JButton();
        lblCodProfPrev = new javax.swing.JLabel();
        lblCodProfessor = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAulas = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lblCodAulaPrev1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));
        setMinimumSize(new java.awt.Dimension(520, 475));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Professores");

        tblProf.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo Professor", "Nome Professor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblProf.setToolTipText("");
        tblProf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                getAulas(evt);
            }
        });
        jScrollPane1.setViewportView(tblProf);

        jLabel3.setText("Nome do Professor:");

        btnInserir.setText("Inserir");
        btnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirProfActionPerformed(evt);
            }
        });

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        cmbTipoPesquisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Codigo", "Nome do Professor" }));

        btnExcluir1.setText("Editar");
        btnExcluir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerfromed(evt);
            }
        });

        btnLimparPesquisa.setText("Limpar Pesquisa");
        btnLimparPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparPesquisaActionPerformed(evt);
            }
        });

        lblCodProfPrev.setText("Cod Professor:");

        lblCodProfessor.setText("0");

        tblAulas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo Aula", "Nome Aula", "Descrição Aula"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblAulas.setToolTipText("");
        jScrollPane2.setViewportView(tblAulas);

        jButton1.setText("Adicionar Aula");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddAula(evt);
            }
        });

        jButton2.setText("Excluir Aula");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExcluirAula(evt);
            }
        });

        lblCodAulaPrev1.setText("Aulas do professor selecionado:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jSeparator1))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnInserir)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel3)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                    .addComponent(lblCodProfPrev)
                                                    .addGap(12, 12, 12)
                                                    .addComponent(lblCodProfessor)))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtNomeProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnPesquisar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cmbTipoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(txtPesquisa)))
                                        .addGap(18, 18, 18)
                                        .addComponent(btnLimparPesquisa)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btnExcluir1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))))
                                .addGap(0, 1, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(187, 187, 187))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblCodAulaPrev1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodProfPrev)
                    .addComponent(lblCodProfessor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNomeProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnInserir)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnPesquisar)
                            .addComponent(cmbTipoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnExcluir1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExcluir))
                            .addComponent(btnLimparPesquisa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCodAulaPrev1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed

        if(!(txtNomeProfessor.getText().equals(""))){
            ProfessorDAO professorDAO = new ProfessorDAO();
            Professor professor = new Professor();
            professor.setNOME_PROF(txtNomeProfessor.getText());
            if(btnInserir.getText().equals("Inserir")){
                professorDAO.inserir(professor);
            } else {
                professor.setCOD_PROF(Integer.parseInt(lblCodProfessor.getText()));
                professorDAO.atualiza(professor);
                
                lblCodProfessor.setVisible(false);
                lblCodProfPrev.setVisible(false);
                btnInserir.setText("Inserir");
            }
            txtNomeProfessor.setText("");
            txtPesquisa.setText("");
            atualizaTabela();
        } else {
            JOptionPane.showMessageDialog(null,"Certifique-se de inserir o nome do professor.","Atenção", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnInserirActionPerformed

    private void btnExcluirProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirProfActionPerformed
        try{
            ProfessorDAO professorDAO = new ProfessorDAO();
            professorDAO.excluir(Integer.parseInt(tblProf.getModel().getValueAt(tblProf.getSelectedRow(), 0).toString()));
            atualizaTabela();
            DefaultTableModel tabelaAulas = (DefaultTableModel) tblAulas.getModel();
            tabelaAulas.setRowCount(0);//<- .CLEAR da table
        }
        catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Erro: " + e.getMessage());
        }
        
    }//GEN-LAST:event_btnExcluirProfActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        if(!(txtPesquisa.getText().equals(""))){
            ProfessorDAO professorDAO = new ProfessorDAO();
            Professor professor = new Professor();
            switch (cmbTipoPesquisa.getSelectedItem().toString()) {
                case "Codigo":
                    try{
                        professor.setCOD_PROF(Integer.parseInt(txtPesquisa.getText()));
                        carregaLista(professorDAO.getProfessor(professor, 0)); 
                    }
                    catch (NumberFormatException e){
                        JOptionPane.showMessageDialog(null,"Erro: " + e.getMessage());
                    }
                    break;
                case "Nome do Professor":
                    try{
                        professor.setNOME_PROF(txtPesquisa.getText());
                        carregaLista(professorDAO.getProfessor(professor, 1)); 
                    }
                    catch (NumberFormatException e){
                        JOptionPane.showMessageDialog(null,"Erro: " + e.getMessage());
                    }
                    break;
            }
            txtNomeProfessor.setText("");
            txtPesquisa.setText("");
        } else {
            JOptionPane.showMessageDialog(null,"Certifique-se de inserir algo para a pesquisa.","Atenção", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnEditarActionPerfromed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerfromed
        ProfessorDAO professorDAO = new ProfessorDAO();
        
        Professor professor = new Professor();
        professor.setCOD_PROF(Integer.parseInt(tblProf.getValueAt(tblProf.getSelectedRow(), 0).toString()));
        
        professor = (professorDAO.getProfessor(professor, 0)).get(0);
        txtNomeProfessor.setText(professor.getNOME_PROF());
        lblCodProfessor.setText(Integer.toString(professor.getCOD_PROF()));
        
        lblCodProfessor.setVisible(true);
        lblCodProfPrev.setVisible(true);
        
        btnInserir.setText("Salvar");
    }//GEN-LAST:event_btnEditarActionPerfromed

    private void btnLimparPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparPesquisaActionPerformed
        atualizaTabela();
    }//GEN-LAST:event_btnLimparPesquisaActionPerformed

    private void getAulas(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_getAulas
        AulaDAO aulaDAO = new AulaDAO();
        String value = tblProf.getValueAt(tblProf.getSelectedRow(), 0).toString();
        List<Aula> listaAulas = aulaDAO.getAulasByProf(Integer.parseInt(value));
        carregaListaAulas(listaAulas);
    }//GEN-LAST:event_getAulas

    private void AddAula(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddAula
        try {
            FormSelectAula f1 = new FormSelectAula(Integer.parseInt(tblProf.getValueAt(tblProf.getSelectedRow(), 0).toString()));
            f1.setVisible(true);
            //getAulas(null); não funfa
            DefaultTableModel tabelaAulas = (DefaultTableModel) tblAulas.getModel();
            tabelaAulas.setRowCount(0);//<- .CLEAR da table
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Certifique-se de selecionar um professor na lista de professores!");
        }
    }//GEN-LAST:event_AddAula

    private void ExcluirAula(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcluirAula
        try {
            Object[] options = { "Sim, desejo excluir.", "Não, cacele a operação." };
            int n = JOptionPane.showOptionDialog(null,
                                    "Tem certeza que deseja excluir a aula " +
                                     tblAulas.getValueAt(tblAulas.getSelectedRow(), 1).toString() +
                                     " do professor " +
                                     tblProf.getValueAt(tblProf.getSelectedRow(), 1).toString()+ "?",
                                    "Exemplo", JOptionPane.YES_NO_OPTION,
                                    JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if(n == 0) {
                AulaDAO aulaDAO = new AulaDAO();
                Aula aula = new Aula();
                aula.setCOD_AULA(Integer.parseInt(tblAulas.getValueAt(tblAulas.getSelectedRow(), 0).toString()));
                aula.setNOME_AULA(tblAulas.getValueAt(tblAulas.getSelectedRow(), 1).toString());
                aula.setDESC_AULA(tblAulas.getValueAt(tblAulas.getSelectedRow(), 2).toString());
                aula.setCOD_PROF(-1);
                aulaDAO.atualiza(aula);
                getAulas(null);
            } else if (n == 1) {
                JOptionPane.showMessageDialog(null, "Operação cancelada.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Certifique-se de selecionar uma aula à ser excluida na lista de aulas do professor. " + e);
        }
        
    }//GEN-LAST:event_ExcluirAula

    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormTableB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormTableB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormTableB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormTableB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FormTableB().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnExcluir1;
    private javax.swing.JButton btnInserir;
    private javax.swing.JButton btnLimparPesquisa;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JComboBox<String> cmbTipoPesquisa;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCodAulaPrev1;
    private javax.swing.JLabel lblCodProfPrev;
    private javax.swing.JLabel lblCodProfessor;
    private javax.swing.JTable tblAulas;
    private javax.swing.JTable tblProf;
    private javax.swing.JTextField txtNomeProfessor;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables

    private void If(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
