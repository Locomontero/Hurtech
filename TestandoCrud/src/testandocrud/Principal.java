package testandocrud;

import Connection.ClienteDAO;
import Connection.ProdutoDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import bean.Cliente;
import bean.Produto;

//import static java.lang.Thread.sleep;
//import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
/**
 *
 * @author Patrick Monteiro RA 1031910016
 */
public final class Principal extends javax.swing.JFrame {  
    String modo;
    
    public Principal() {
        initComponents();
        setLocationRelativeTo(null);//Faz a tela ficar no centro
        DefaultTableModel modelo = (DefaultTableModel)tbl_cliente.getModel();
        tbl_cliente.setRowSorter(new TableRowSorter(modelo));
        
        
        //Controller();
        modo = "Navegar";
        lerTabela();
        lerTabelaProduto();
    }
    
    public void lerTabela(){
       DefaultTableModel modelo = (DefaultTableModel)tbl_cliente.getModel();
       modelo.setNumRows(0);//os dados nao duplicam
       ClienteDAO cdao = new ClienteDAO();
       
        try {
            cdao.ler().stream().forEach((c) -> {   //Percorre a tabela
                
                modelo.addRow(new Object[]{
                    c.getCodigo(),
                    c.getNome(),
                    c.getCpf(),
                    c.getEndereco(),
                    c.getTelefone(),   
                });
            }); 
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    public void lerTabelaNome(String nome){
       DefaultTableModel modelo = (DefaultTableModel)tbl_cliente.getModel();
       modelo.setNumRows(0);
       ClienteDAO cdao = new ClienteDAO();
       
        try {
            cdao.pesquisar(nome).stream().forEach((c) -> {   //Percorre a tabela e acha o nome
                
                modelo.addRow(new Object[]{
                    c.getCodigo(),
                    c.getNome(),
                    c.getCpf(),
                    c.getEndereco(),
                    c.getTelefone(),
                    
                    
                });
            }); 
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    
    public void lerTabelaProduto(){
        DefaultTableModel modeloP = (DefaultTableModel)tbl_produto.getModel();
        modeloP.setNumRows(0);
        ProdutoDAO pdao = new ProdutoDAO();
        
        try {
            pdao.lerProduto().stream().forEach((p)->{
                
                modeloP.addRow(new Object[]{
                    p.getCliente().getCodigo(),
                    p.getCliente().getNome(),
                    p.getCliente().getCpf(),
                    p.getModelo(),
                    p.getCor(),
                    p.getPrazo(),
                    p.getCodigoP(),
                });
            });
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void lerTabelaCP(String nome){
        DefaultTableModel modeloP = (DefaultTableModel)tbl_produto.getModel();
        modeloP.setNumRows(0);
        ProdutoDAO pdao = new ProdutoDAO();
        
        
        try {
            pdao.pesquisarProduto(nome).stream().forEach((p)->{
                
                modeloP.addRow(new Object[]{
                    p.getCliente().getCodigo(),
                    p.getCliente().getNome(),
                    p.getCliente().getCpf(),
                    p.getModelo(),
                    p.getCor(),
                    p.getPrazo(),
                    p.getCodigoP(),
                });
            });
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    /*public void Controller() {
        switch (modo) {
            case "Navegar":
                btn_salvar.setEnabled(false);
                btn_excluir.setEnabled(true);
                btn_pesquisar.setEnabled(true);
                btn_inserir.setEnabled(true);
                c_nome.setEnabled(true);
                c_cpf.setEnabled(true);
                c_endereco.setEnabled(true);
                c_telefone.setEnabled(true);
                break;

            case "Salvar":
                btn_salvar.setEnabled(false);
                btn_excluir.setEnabled(true);
                btn_pesquisar.setEnabled(true);
                btn_inserir.setEnabled(false);
                c_nome.setEnabled(true);
                c_cpf.setEnabled(true);
                c_endereco.setEnabled(true);
                c_telefone.setEnabled(true);                
                break;

            case "Editar":
                btn_salvar.setEnabled(true);
                btn_excluir.setEnabled(false);
                btn_pesquisar.setEnabled(false);
                btn_inserir.setEnabled(false);
                c_nome.setEnabled(true);
                c_cpf.setEnabled(true);
                c_endereco.setEnabled(true);
                c_telefone.setEnabled(true);
                break;

            case "Selecao":
                btn_salvar.setEnabled(false);
                btn_excluir.setEnabled(true);
                btn_pesquisar.setEnabled(true);
                btn_inserir.setEnabled(false);
                c_nome.setEnabled(false);
                c_cpf.setEnabled(false);
                c_endereco.setEnabled(false);
                c_telefone.setEnabled(false);
                break;

            default:
        }
    }
    public void Run(){
        while(jProgressBar1.getValue()<100){
            try {
                sleep(10);
                jProgressBar1.setValue(jProgressBar1.getValue() +10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        JOptionPane.showMessageDialog(null, "Movel finalizado" );
    }*/
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        buttonGroup7 = new javax.swing.ButtonGroup();
        buttonGroup8 = new javax.swing.ButtonGroup();
        buttonGroup9 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        list1 = new java.awt.List();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        tb_principal = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_cliente = new javax.swing.JTable();
        btn_excluir = new javax.swing.JButton();
        btn_pesquisar = new javax.swing.JButton();
        c_pesquisar = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        label_progresso = new javax.swing.JLabel();
        panel_projeto_mostrar_cliente = new javax.swing.JPanel();
        c_pesquisarP = new javax.swing.JTextField();
        btn_procurar_cliente_produto = new javax.swing.JButton();
        btn_inserirP = new javax.swing.JButton();
        btn_excluirP = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        c_codigo_cliente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jcombo_prazo = new javax.swing.JComboBox<>();
        jcombo_cor = new javax.swing.JComboBox<>();
        jcombo_modelo = new javax.swing.JComboBox<>();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_produto = new javax.swing.JTable();
        jProgressBar1 = new javax.swing.JProgressBar();
        Panel_Insere = new javax.swing.JPanel();
        c_nome = new javax.swing.JTextField();
        T_nome = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        c_endereco = new javax.swing.JTextField();
        btn_inserir = new javax.swing.JButton();
        btn_salvar = new javax.swing.JButton();
        c_cpf = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        c_telefone = new javax.swing.JFormattedTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Programa Principal");

        tbl_cliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Nome", "CPF", "Endereço", "Telefone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_clienteMouseClicked(evt);
            }
        });
        tbl_cliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbl_clienteKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_cliente);
        if (tbl_cliente.getColumnModel().getColumnCount() > 0) {
            tbl_cliente.getColumnModel().getColumn(0).setPreferredWidth(60);
            tbl_cliente.getColumnModel().getColumn(1).setPreferredWidth(130);
            tbl_cliente.getColumnModel().getColumn(2).setPreferredWidth(100);
            tbl_cliente.getColumnModel().getColumn(3).setPreferredWidth(150);
            tbl_cliente.getColumnModel().getColumn(4).setPreferredWidth(80);
        }

        btn_excluir.setText("Excluir");
        btn_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excluirActionPerformed(evt);
            }
        });

        btn_pesquisar.setText("Pesquisar");
        btn_pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pesquisarActionPerformed(evt);
            }
        });

        jLabel11.setText("Digite o nome:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(c_pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_pesquisar)
                .addGap(18, 18, 18)
                .addComponent(btn_excluir)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_excluir)
                    .addComponent(btn_pesquisar)
                    .addComponent(c_pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tb_principal.addTab("Cliente", jPanel3);

        label_progresso.setText("Progresso:");

        panel_projeto_mostrar_cliente.setToolTipText("Informações do Cliente");

        btn_procurar_cliente_produto.setText("Procurar Cliente");
        btn_procurar_cliente_produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_procurar_cliente_produtoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_projeto_mostrar_clienteLayout = new javax.swing.GroupLayout(panel_projeto_mostrar_cliente);
        panel_projeto_mostrar_cliente.setLayout(panel_projeto_mostrar_clienteLayout);
        panel_projeto_mostrar_clienteLayout.setHorizontalGroup(
            panel_projeto_mostrar_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_projeto_mostrar_clienteLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(btn_procurar_cliente_produto, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(c_pesquisarP, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        panel_projeto_mostrar_clienteLayout.setVerticalGroup(
            panel_projeto_mostrar_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_projeto_mostrar_clienteLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panel_projeto_mostrar_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(c_pesquisarP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_procurar_cliente_produto))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_inserirP.setText("Inserir");
        btn_inserirP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_inserirPActionPerformed(evt);
            }
        });

        btn_excluirP.setText("excluir");
        btn_excluirP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excluirPActionPerformed(evt);
            }
        });

        jLabel9.setText("Cor do Produto:");

        jLabel1.setText("Cod do Cliente:");

        jLabel5.setText("Prazo em dias:");

        jLabel7.setText("Modelo do produto:");

        jcombo_prazo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "30", "60" }));
        jcombo_prazo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcombo_prazoActionPerformed(evt);
            }
        });

        jcombo_cor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Branco", "Preto ", "Marrom ", "Bege", "Mescla" }));
        jcombo_cor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcombo_corActionPerformed(evt);
            }
        });

        jcombo_modelo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mesa", "Cadeira", "Cama", "Armario" }));
        jcombo_modelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcombo_modeloActionPerformed(evt);
            }
        });

        tbl_produto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Cpf", "Modelo", "Cor", "Prazo", "Cod_Prod"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbl_produto);
        if (tbl_produto.getColumnModel().getColumnCount() > 0) {
            tbl_produto.getColumnModel().getColumn(0).setPreferredWidth(30);
            tbl_produto.getColumnModel().getColumn(5).setPreferredWidth(50);
        }

        jTabbedPane1.addTab("Info", jScrollPane2);

        jProgressBar1.setForeground(new java.awt.Color(0, 255, 102));
        jProgressBar1.setStringPainted(true);
        jProgressBar1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jProgressBar1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel1))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(jLabel9)))
                            .addGap(24, 24, 24)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jcombo_modelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(c_codigo_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jcombo_prazo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jcombo_cor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGap(61, 61, 61)
                                    .addComponent(btn_excluirP))))
                        .addComponent(panel_projeto_mostrar_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(btn_inserirP)))
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label_progresso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label_progresso)
                            .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(panel_projeto_mostrar_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jcombo_modelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jcombo_cor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcombo_prazo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(c_codigo_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btn_inserirP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(btn_excluirP)))
                .addGap(20, 20, 20))
        );

        tb_principal.addTab("Projeto", jPanel4);

        T_nome.setText("Nome:");

        jLabel3.setText("CPF:");

        jLabel2.setText("Endereço:");

        btn_inserir.setText("Inserir");
        btn_inserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_inserirActionPerformed(evt);
            }
        });

        btn_salvar.setText("Salvar/ Editar");
        btn_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salvarActionPerformed(evt);
            }
        });

        try {
            c_cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel6.setText("Telefone:");

        try {
            c_telefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(###)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout Panel_InsereLayout = new javax.swing.GroupLayout(Panel_Insere);
        Panel_Insere.setLayout(Panel_InsereLayout);
        Panel_InsereLayout.setHorizontalGroup(
            Panel_InsereLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_InsereLayout.createSequentialGroup()
                .addGroup(Panel_InsereLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_InsereLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(Panel_InsereLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(T_nome)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_InsereLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(Panel_InsereLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_InsereLayout.createSequentialGroup()
                        .addComponent(c_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_salvar)
                        .addGap(119, 119, 119))
                    .addGroup(Panel_InsereLayout.createSequentialGroup()
                        .addGroup(Panel_InsereLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(c_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(c_endereco, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(c_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(Panel_InsereLayout.createSequentialGroup()
                .addGap(271, 271, 271)
                .addComponent(btn_inserir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Panel_InsereLayout.setVerticalGroup(
            Panel_InsereLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_InsereLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(Panel_InsereLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(T_nome)
                    .addComponent(c_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Panel_InsereLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(c_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(Panel_InsereLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_InsereLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(Panel_InsereLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(c_endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(Panel_InsereLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(c_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_inserir)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_InsereLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_salvar)
                        .addGap(52, 52, 52))))
        );

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/house.png"))); // NOI18N
        jMenu1.setText("Index");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/door_out.png"))); // NOI18N
        jMenuItem1.setText("Sair");
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tb_principal, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addComponent(Panel_Insere, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Panel_Insere, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(tb_principal)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void limparCampos(String modo) {
        c_nome.setText("");
        c_cpf.setText("");
        c_endereco.setText("");
        c_telefone.setText("");
        c_codigo_cliente.setText("");
        this.modo = modo;        
    }   
    private void btn_inserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_inserirActionPerformed
        Cliente c = new Cliente();
        ClienteDAO dao = new ClienteDAO();
        
        c.setNome(c_nome.getText());
        c.setCpf(c_cpf.getText());
        c.setEndereco(c_endereco.getText());
        c.setTelefone(c_telefone.getText());
        try {
            dao.inserir(c);
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }  
        lerTabela();
        limparCampos("Navegar");
        //Controller();
        modo="Navegar";
    }//GEN-LAST:event_btn_inserirActionPerformed

    private void btn_pesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pesquisarActionPerformed
        lerTabelaNome(c_pesquisar.getText());
        
    }//GEN-LAST:event_btn_pesquisarActionPerformed

    private void btn_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excluirActionPerformed
        if(tbl_cliente.getSelectedRow() !=-1){
            Cliente c = new Cliente();
            ClienteDAO dao = new ClienteDAO();

            c.setCodigo((int)tbl_cliente.getValueAt(tbl_cliente.getSelectedRow(),0));
            
            try {
                dao.deletar(c);
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
             
            lerTabela();
            limparCampos("Navegar");
        }

    }//GEN-LAST:event_btn_excluirActionPerformed

    private void tbl_clienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_clienteMouseClicked
         if(tbl_cliente.getSelectedRow() !=-1){
            
            c_nome.setText(tbl_cliente.getValueAt(tbl_cliente.getSelectedRow(),1).toString());
            c_cpf.setText(tbl_cliente.getValueAt(tbl_cliente.getSelectedRow(),2).toString());
            c_endereco.setText(tbl_cliente.getValueAt(tbl_cliente.getSelectedRow(),3).toString());
            c_telefone.setText(tbl_cliente.getValueAt(tbl_cliente.getSelectedRow(),4).toString());
        
        /*Controller();
        modo="Selecao";*/
        
        }
    }//GEN-LAST:event_tbl_clienteMouseClicked

    private void btn_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salvarActionPerformed
        if(tbl_cliente.getSelectedRow() !=-1){
        Cliente c = new Cliente();
        ClienteDAO dao = new ClienteDAO();
        
        c.setNome(c_nome.getText());
        c.setCpf(c_cpf.getText());
        c.setEndereco(c_endereco.getText());
        c.setTelefone(c_telefone.getText());
        c.setCodigo((int)tbl_cliente.getValueAt(tbl_cliente.getSelectedRow(),0));
        try {
            dao.editar(c);
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }  
        lerTabela();
        limparCampos("Navegar");
        //Controller();
        //modo="Navegar";
        }
    }//GEN-LAST:event_btn_salvarActionPerformed

    private void tbl_clienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_clienteKeyReleased
        if(tbl_cliente.getSelectedRow() !=-1){
            
            c_nome.setText(tbl_cliente.getValueAt(tbl_cliente.getSelectedRow(),1).toString());
            c_cpf.setText(tbl_cliente.getValueAt(tbl_cliente.getSelectedRow(),2).toString());
            c_endereco.setText(tbl_cliente.getValueAt(tbl_cliente.getSelectedRow(),3).toString());
            c_telefone.setText(tbl_cliente.getValueAt(tbl_cliente.getSelectedRow(),4).toString());
        
        /*Controller();
        modo="Selecao";*/
        
        }
    }//GEN-LAST:event_tbl_clienteKeyReleased

    private void btn_procurar_cliente_produtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_procurar_cliente_produtoActionPerformed
        lerTabelaCP(c_pesquisarP.getText());
    }//GEN-LAST:event_btn_procurar_cliente_produtoActionPerformed

    private void btn_inserirPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_inserirPActionPerformed
        Produto p = new Produto();
        ProdutoDAO pdao = new ProdutoDAO();
        
        Cliente cliente = new Cliente();        //pega o cliente
        cliente.setCodigo(Integer.parseInt(c_codigo_cliente.getText()));
        
        p.setModelo(String.valueOf(jcombo_modelo.getSelectedItem()));
        p.setCor (String.valueOf(jcombo_cor.getSelectedItem()));
        p.setPrazo(Integer.parseInt(String.valueOf(jcombo_prazo.getSelectedItem())));
        
        p.setCliente(cliente);
        
        try {
                pdao.inserirProduto(p);
            
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        lerTabelaProduto();
        limparCampos("Navegar");
        //Controller();
        modo="Navegar";
    }//GEN-LAST:event_btn_inserirPActionPerformed

    private void btn_excluirPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excluirPActionPerformed
            if(tbl_produto.getSelectedRow() !=-1)  {  
            Produto p = new Produto();
            ProdutoDAO pdao = new ProdutoDAO();
            
            p.setCodigoP((int)tbl_produto.getValueAt(tbl_produto.getSelectedRow(),6));
            
            try {
                pdao.deletarProduto(p);
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            lerTabelaProduto();
            limparCampos("Navegar");
        }
    }//GEN-LAST:event_btn_excluirPActionPerformed

    private void jcombo_modeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcombo_modeloActionPerformed
        jcombo_modelo.getModel();
    }//GEN-LAST:event_jcombo_modeloActionPerformed

    private void jcombo_corActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcombo_corActionPerformed
        jcombo_cor.getModel();
    }//GEN-LAST:event_jcombo_corActionPerformed

    private void jcombo_prazoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcombo_prazoActionPerformed
        jcombo_prazo.getModel();         
    }//GEN-LAST:event_jcombo_prazoActionPerformed

    private void jProgressBar1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jProgressBar1AncestorAdded
       /* if(tbl_cliente.getSelectedRow() !=-1){
            
        }*/
    }//GEN-LAST:event_jProgressBar1AncestorAdded

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Principal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_Insere;
    private javax.swing.JLabel T_nome;
    private javax.swing.JButton btn_excluir;
    private javax.swing.JButton btn_excluirP;
    private javax.swing.JButton btn_inserir;
    private javax.swing.JButton btn_inserirP;
    private javax.swing.JButton btn_pesquisar;
    private javax.swing.JButton btn_procurar_cliente_produto;
    private javax.swing.JButton btn_salvar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.ButtonGroup buttonGroup7;
    private javax.swing.ButtonGroup buttonGroup8;
    private javax.swing.ButtonGroup buttonGroup9;
    private javax.swing.JTextField c_codigo_cliente;
    private javax.swing.JFormattedTextField c_cpf;
    private javax.swing.JTextField c_endereco;
    private javax.swing.JTextField c_nome;
    private javax.swing.JTextField c_pesquisar;
    private javax.swing.JTextField c_pesquisarP;
    private javax.swing.JFormattedTextField c_telefone;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox<String> jcombo_cor;
    private javax.swing.JComboBox<String> jcombo_modelo;
    private javax.swing.JComboBox<String> jcombo_prazo;
    private javax.swing.JLabel label_progresso;
    private java.awt.List list1;
    private javax.swing.JPanel panel_projeto_mostrar_cliente;
    private javax.swing.JTabbedPane tb_principal;
    private javax.swing.JTable tbl_cliente;
    private javax.swing.JTable tbl_produto;
    // End of variables declaration//GEN-END:variables

    

}
