package form;

import beans.Aula;
import dao.AulaDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Padre Fabio de Melo
 */

public class FormTableA extends javax.swing.JFrame {
    
    public FormTableA() {
        initComponents();
        atualizaTabela();
        lblCodAula.setVisible(false);
        lblCodAulaPrev.setVisible(false);
    }
    
    private void atualizaTabela()
    {
        AulaDAO aulaDAO = new AulaDAO();
        List<Aula> listaAulas = aulaDAO.getAulas();
        carregaLista(listaAulas);
        //Carregalista foi separado só pra evitar o retrabalho na pesquisa, envia uma lista e a lista carrega na jtable
    }
    
    private void carregaLista(List<Aula> listaAulas){
        DefaultTableModel tabelaAulas = (DefaultTableModel) tblAulas.getModel();
        tabelaAulas.setRowCount(0);//<- .CLEAR da table
        listaAulas.stream().map((a) -> new Object[]{
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
        tblAulas = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtNomeAula = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnInserir = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        txtPesquisa = new javax.swing.JTextField();
        cmbTipoPesquisa = new javax.swing.JComboBox<>();
        btnExcluir1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescAula = new javax.swing.JTextPane();
        btnLimparPesquisa = new javax.swing.JButton();
        lblCodAulaPrev = new javax.swing.JLabel();
        lblCodAula = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));
        setMaximumSize(new java.awt.Dimension(577, 497));
        setMinimumSize(new java.awt.Dimension(577, 497));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Aulas");

        tblAulas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nome Aula", "Descrição Matéria"
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
        jScrollPane1.setViewportView(tblAulas);

        jLabel3.setText("Nome da Aula:");

        jLabel4.setText("Descrição Materia geral:");

        btnInserir.setText("Inserir");
        btnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        cmbTipoPesquisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Codigo", "Nome da Aula", "Descrição" }));

        btnExcluir1.setText("Editar");
        btnExcluir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditar1ActionPerformed(evt);
            }
        });

        txtDescAula.setMaximumSize(new java.awt.Dimension(7, 23));
        txtDescAula.setName(""); // NOI18N
        jScrollPane2.setViewportView(txtDescAula);

        btnLimparPesquisa.setText("Limpar Pesquisa");
        btnLimparPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparPesquisaActionPerformed(evt);
            }
        });

        lblCodAulaPrev.setText("Cod Aula:");

        lblCodAula.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnPesquisar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbTipoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 385, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnLimparPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnExcluir1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(9, 9, 9))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lblCodAulaPrev)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblCodAula)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNomeAula, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(59, 59, 59)
                                        .addComponent(jLabel1)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                                .addGap(82, 82, 82))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnInserir)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblCodAulaPrev)
                                    .addComponent(lblCodAula)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 47, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNomeAula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(btnInserir)
                        .addGap(39, 39, 39)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnPesquisar)
                            .addComponent(cmbTipoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnLimparPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnExcluir1)
                            .addGap(0, 0, 0)
                            .addComponent(btnExcluir))))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed

        if(!(txtNomeAula.getText().equals("") || txtNomeAula.getText().equals(""))){
            AulaDAO aulaDAO = new AulaDAO();
            Aula aula = new Aula();
            if(btnInserir.getText().equals("Inserir")) {
                aula.setNOME_AULA(txtNomeAula.getText());
                aula.setDESC_AULA(txtDescAula.getText());
                aulaDAO.inserir(aula);
            } else {
                aula.setCOD_AULA(Integer.parseInt(lblCodAula.getText()));
                aula = aulaDAO.getAula(aula, 1).get(0);
                aula.setNOME_AULA(txtNomeAula.getText());
                aula.setDESC_AULA(txtDescAula.getText());
                aulaDAO.atualiza(aula);
                
                lblCodAula.setVisible(false);
                lblCodAulaPrev.setVisible(false);
                btnInserir.setText("Inserir");
            }
                
            txtDescAula.setText("");
            txtNomeAula.setText("");
            txtPesquisa.setText("");
                    
            atualizaTabela();
        } else {
            JOptionPane.showMessageDialog(null,"Certifique-se de inserir descrição e nome da aula.","Atenção", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnInserirActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed

        try {
            AulaDAO aulaDAO = new AulaDAO();
            int column = 0;
            int row = tblAulas.getSelectedRow();
            String value = tblAulas.getModel().getValueAt(row, column).toString();

            aulaDAO.excluir(Integer.parseInt(value));
            atualizaTabela();
        }
        catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Erro: " + e.getMessage());
        }
        
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        if(!(txtPesquisa.getText().equals(""))){
            AulaDAO aulaDAO = new AulaDAO();
            Aula aula = new Aula();
            switch (cmbTipoPesquisa.getSelectedItem().toString()) {
                case "Codigo":
                    try{
                        int codPesquisa = Integer.parseInt(txtPesquisa.getText());
                        aula.setCOD_AULA(codPesquisa);
                        carregaLista(aulaDAO.getAula(aula, 1)); 
                    }
                    catch (NumberFormatException e){
                        JOptionPane.showMessageDialog(null,"Erro: " + e.getMessage());
                    }
                    break;
                case "Nome da Aula":
                    aula.setNOME_AULA(txtPesquisa.getText());
                    carregaLista(aulaDAO.getAula(aula, 2)); 
                    break;
                default:
                    aula.setDESC_AULA(txtPesquisa.getText());
                    carregaLista(aulaDAO.getAula(aula, 3));
                    break;
            }
            txtDescAula.setText("");
            txtNomeAula.setText("");
            txtPesquisa.setText("");
            
        } else {
            JOptionPane.showMessageDialog(null,"Certifique-se de inserir algo para a pesquisa.","Atenção", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnEditar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditar1ActionPerformed
        AulaDAO aulaDAO = new AulaDAO();
        int column = 0;
        int row = tblAulas.getSelectedRow();
        String value = tblAulas.getModel().getValueAt(row, column).toString();
        
        Aula aula = new Aula();
        aula.setCOD_AULA(Integer.parseInt(value));
        
        aula = (aulaDAO.getAula(aula, 1)).get(0);
        txtNomeAula.setText(aula.getNOME_AULA());
        txtDescAula.setText(aula.getDESC_AULA());
        lblCodAula.setText(Integer.toString(aula.getCOD_AULA()));
        
        lblCodAula.setVisible(true);
        lblCodAulaPrev.setVisible(true);
        
        btnInserir.setText("Salvar");
    }//GEN-LAST:event_btnEditar1ActionPerformed

    private void btnLimparPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparPesquisaActionPerformed
        atualizaTabela();
    }//GEN-LAST:event_btnLimparPesquisaActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormTableA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormTableA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormTableA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormTableA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FormTableA().setVisible(true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCodAula;
    private javax.swing.JLabel lblCodAulaPrev;
    private javax.swing.JTable tblAulas;
    private javax.swing.JTextPane txtDescAula;
    private javax.swing.JTextField txtNomeAula;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables

    private void If(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
