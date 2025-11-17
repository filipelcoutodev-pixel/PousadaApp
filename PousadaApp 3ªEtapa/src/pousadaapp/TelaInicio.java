package pousadaapp;

import Model.Gastos;
import Model.Hospede;

import Model.ListaGastos;
import Model.ListaHospede;
import java.awt.event.KeyEvent;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author FilipeLuizCouto
 */
public class TelaInicio extends javax.swing.JFrame {

    double saidas;
    double entradas;
    double valorDiaria;
    double caixaPousada;

    public double pagar(double valorgasto) {
        valorgasto = saidas;
        return saidas;
    }
    
    public void acessibilidade(){
        btnCdastro.setMnemonic(KeyEvent.VK_N);
        btnSalvar.setMnemonic(KeyEvent.VK_S);
        btnCaixa.setMnemonic(KeyEvent.VK_C);
        btnGastos.setMnemonic(KeyEvent.VK_G);
        btnOK.setMnemonic(KeyEvent.VK_O);
        btnSair.setMnemonic(KeyEvent.VK_S);
        btnVoltar.setMnemonic(KeyEvent.VK_V);
        btnSairCaixa.setMnemonic(KeyEvent.VK_E);
        btnSairCadastro.setMnemonic(KeyEvent.VK_0);
    }
    public void Hospedar() {
        // Criado o Objeto Hospede
Hospede hospede = new Hospede();
       
        if (txtNovoHospede.getText().isEmpty() || txtCpfHospede.getText().isEmpty() || txtContatoHospede.getText().isEmpty() || txtIdadeHospede.getText().isEmpty() || txtNumeroDiarias.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos os Campos devem Ser Preenchidos");
        }else{
      
        hospede.setNome(txtNovoHospede.getText());
        
        String incpf =txtCpfHospede.getText();
        boolean validaCpf = incpf.matches("[0-9]{3}[.][0-9]{3}[.][0-9]{3}[-][0-9]{2}");
        
        String inIdade = txtIdadeHospede.getText();
        boolean validaIdade= inIdade.matches("[0-9]{2}");
        hospede.setIdade(Integer.parseInt(txtIdadeHospede.getText()));
        
        String inContato = txtContatoHospede.getText();
        boolean validaContato = inContato.matches("[0-9]{2}[-][0-9]{9}");
        hospede.setContato(txtContatoHospede.getText());
        
        String inNumeroDiarias = txtNumeroDiarias.getText();
        boolean validaDiarias = inNumeroDiarias.matches("[0-9]{2}");
        hospede.setNumeroDiarias(Integer.parseInt(txtNumeroDiarias.getText()));
        
        if(validaCpf){
            hospede.setCpf(incpf);
        }else{
            JOptionPane.showMessageDialog(null, "Informe um CPF Válido:\n Ex.: 999.999.999-99");
        }
        if(validaIdade){
            hospede.setIdade(Integer.parseInt(inIdade));
        }else{
            JOptionPane.showMessageDialog(null, "Informe uma Idade Válida:\n Ex.:999");
        }
        if(validaContato){
            hospede.setContato(inContato);
        }else{
            JOptionPane.showMessageDialog(null, "Informe um Contato Válido:\n Ex.: 99-999999999");
        }
        hospede.setIdentificacaoQuarto(cbxQuarto.getSelectedItem().toString());
         
             ListaHospede.Adicionar(hospede);

        valorDiaria = Double.parseDouble(JOptionPane.showInputDialog("Hospede " + hospede.getNome() + " acomodado no quarto " + hospede.getIdentificacaoQuarto() + "\nEntre com o valor da Diaria"));

        hospede.setSaldoHosepde(hospede.getNumeroDiarias() * valorDiaria);

        entradas += hospede.getSaldoHosepde();
        
        lblEntradas.setText(Double.toString(entradas));
        
        tbllistaHospede = new javax.swing.JTable();
        // Definimdo nome das colunas
        String[] colunas = {"Nome", "Cpf", "Idade", "Contato", "Quarto", "Diarias"};
        DefaultTableModel tabelaEntrada = new DefaultTableModel(colunas, 0);
        
        // Pegando os dados cadastrados na lista de Hospedes
        List<Hospede> lista = ListaHospede.Listar();

        for (int l = 0; l < lista.size(); l++) {

            // Extraímos os dados
            hospede = lista.get(l);

            // Montando a linha da tabela
            String[] linha = {
                hospede.getNome(),
                hospede.getCpf(),
                Integer.toString(hospede.getIdade()),
                hospede.getContato(),
                hospede.getIdentificacaoQuarto(),
                Integer.toString(hospede.getNumeroDiarias())
            };
            tabelaEntrada.addRow(linha);

            tbllistaHospede.setModel(tabelaEntrada);

            ScpTabela.setViewportView(tbllistaHospede);
        }

        txtNovoHospede.setText("");
        txtCpfHospede.setText("");
        txtIdadeHospede.setText("");
        txtContatoHospede.setText("");

        txtNumeroDiarias.setText("");

    }
    }
    public void gasto() {

        Gastos gastos = new Gastos();

        if (txtDescGastos.getText().isEmpty() || txtValorGastos.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os Campos");
        }else{
        gastos.setDescricao(txtDescGastos.getText());

      
            gastos.setValorGasto(Double.parseDouble(txtValorGastos.getText()));
        }

        ListaGastos.Adicionar(gastos);

        tabelaGastos = new javax.swing.JTable();
        // Definindo nome das coluna
        String[] colunasGastos = {"Descrição", "Valor Gasto"};
        DefaultTableModel tabelModelGastos = new DefaultTableModel(colunasGastos, 0);
        // Pegando os dados na lista de gastos
        List<Gastos> lista = ListaGastos.Listar();

        for (int i = 0; i < lista.size(); i++) {
            
            gastos = lista.get(i);

            String[] linha = {
                gastos.getDescricao(),
                Double.toString(gastos.getValorGasto())
            };

            // Adicionando a linha na tabela
            tabelModelGastos.addRow(linha);
            tabelaGastos.setModel(tabelModelGastos);

            ScpGastos.setViewportView(tabelaGastos);
        }

        saidas += gastos.getValorGasto();
        pagar(saidas);
        txtValorGastos.setText("");
        txtDescGastos.setText("");

    }

    public TelaInicio() {

        initComponents();
        acessibilidade();
        ScpGastos.setVisible(false);
        ScpTabela.setVisible(false);
        PainelGastos.setVisible(false);
        PainelCadastro.setVisible(false);
        PainelCaixa.setVisible(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PainelTitulo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblQuarto = new javax.swing.JLabel();
        Painelfundo = new javax.swing.JPanel();
        ScpTabela = new javax.swing.JScrollPane();
        tbllistaHospede = new javax.swing.JTable();
        lblFundo = new javax.swing.JLabel();
        PainelBotoes = new javax.swing.JPanel();
        btnCdastro = new javax.swing.JButton();
        btnGastos = new javax.swing.JButton();
        btnCaixa = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        PainelCadastro = new javax.swing.JPanel();
        btnSalvar = new javax.swing.JButton();
        lblNovoHospede = new javax.swing.JLabel();
        txtNovoHospede = new javax.swing.JTextField();
        lblCpfHospede = new javax.swing.JLabel();
        txtCpfHospede = new javax.swing.JTextField();
        txtContatoHospede = new javax.swing.JTextField();
        lblContatoHospede = new javax.swing.JLabel();
        lblNumeroDiarias = new javax.swing.JLabel();
        txtNumeroDiarias = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        lblIdadeHospede = new javax.swing.JLabel();
        txtIdadeHospede = new javax.swing.JTextField();
        btnSairCadastro = new javax.swing.JButton();
        cbxQuarto = new javax.swing.JComboBox<>();
        PainelCaixa = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblEntradas = new javax.swing.JLabel();
        lblGastos = new javax.swing.JLabel();
        lblSaldo = new javax.swing.JLabel();
        btnSairCaixa = new javax.swing.JButton();
        PainelGastos = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtDescGastos = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtValorGastos = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();
        btnOK = new javax.swing.JButton();
        PainelFundo2 = new javax.swing.JPanel();
        lblFundoGastos = new javax.swing.JLabel();
        ScpGastos = new javax.swing.JScrollPane();
        tabelaGastos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        PainelTitulo.setBackground(new java.awt.Color(0, 102, 153));
        PainelTitulo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Constantia", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Pousada da Dulci");
        jLabel1.setAlignmentY(0.0F);
        PainelTitulo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1502, 156));

        lblQuarto.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        lblQuarto.setForeground(new java.awt.Color(0, 102, 153));

        Painelfundo.setPreferredSize(new java.awt.Dimension(1068, 719));
        Painelfundo.setLayout(null);

        tbllistaHospede.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        tbllistaHospede.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Quarto", "Nome", "Cpf", "Idade", "Contato", "Diarias"
            }
        ));
        ScpTabela.setViewportView(tbllistaHospede);

        Painelfundo.add(ScpTabela);
        ScpTabela.setBounds(130, 130, 640, 310);

        lblFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pousadaapp/Pousada3.png"))); // NOI18N
        lblFundo.setMaximumSize(new java.awt.Dimension(961, 654));
        lblFundo.setMinimumSize(new java.awt.Dimension(961, 654));
        Painelfundo.add(lblFundo);
        lblFundo.setBounds(0, 10, 2270, 650);

        btnCdastro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCdastro.setText("Cadastrar");
        btnCdastro.setToolTipText("Alt+N");
        btnCdastro.setPreferredSize(new java.awt.Dimension(80, 40));
        btnCdastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCdastroActionPerformed(evt);
            }
        });

        btnGastos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGastos.setText("Gastos");
        btnGastos.setToolTipText("Alt+G");
        btnGastos.setPreferredSize(new java.awt.Dimension(80, 40));
        btnGastos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGastosActionPerformed(evt);
            }
        });

        btnCaixa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCaixa.setText("Caixa");
        btnCaixa.setToolTipText("Alt+C");
        btnCaixa.setPreferredSize(new java.awt.Dimension(80, 40));
        btnCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCaixaActionPerformed(evt);
            }
        });

        btnVoltar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.setToolTipText("Alt+V");
        btnVoltar.setPreferredSize(new java.awt.Dimension(80, 40));
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PainelBotoesLayout = new javax.swing.GroupLayout(PainelBotoes);
        PainelBotoes.setLayout(PainelBotoesLayout);
        PainelBotoesLayout.setHorizontalGroup(
            PainelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelBotoesLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(btnCdastro, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnGastos, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        PainelBotoesLayout.setVerticalGroup(
            PainelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PainelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCdastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGastos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        PainelCadastro.setForeground(new java.awt.Color(0, 102, 153));
        PainelCadastro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSalvar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        PainelCadastro.add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, -1, 30));

        lblNovoHospede.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNovoHospede.setForeground(new java.awt.Color(0, 102, 153));
        lblNovoHospede.setText("Nome:");
        PainelCadastro.add(lblNovoHospede, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 67, -1));

        txtNovoHospede.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        PainelCadastro.add(txtNovoHospede, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 349, -1));

        lblCpfHospede.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCpfHospede.setForeground(new java.awt.Color(0, 102, 153));
        lblCpfHospede.setText("CPF");
        PainelCadastro.add(lblCpfHospede, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 85, 37, -1));

        txtCpfHospede.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtCpfHospede.setToolTipText("Entre com o CPF: 999.999.999-99");
        txtCpfHospede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCpfHospedeActionPerformed(evt);
            }
        });
        PainelCadastro.add(txtCpfHospede, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 170, -1));

        txtContatoHospede.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtContatoHospede.setToolTipText("Insira o Telefone 99-999999999");
        txtContatoHospede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContatoHospedeActionPerformed(evt);
            }
        });
        PainelCadastro.add(txtContatoHospede, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 170, -1));

        lblContatoHospede.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblContatoHospede.setForeground(new java.awt.Color(0, 102, 153));
        lblContatoHospede.setText("Contato");
        PainelCadastro.add(lblContatoHospede, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 145, 55, -1));

        lblNumeroDiarias.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNumeroDiarias.setForeground(new java.awt.Color(0, 102, 153));
        lblNumeroDiarias.setText("Numero de Diarias");
        PainelCadastro.add(lblNumeroDiarias, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 173, 147, -1));

        txtNumeroDiarias.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNumeroDiarias.setToolTipText("Insira o Numero de Diarias 99");
        txtNumeroDiarias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroDiariasActionPerformed(evt);
            }
        });
        PainelCadastro.add(txtNumeroDiarias, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 46, -1));

        jLabel8.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 153));
        jLabel8.setText("Cadastro de Hospedes");
        PainelCadastro.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 200, 30));

        lblIdadeHospede.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblIdadeHospede.setForeground(new java.awt.Color(0, 102, 153));
        lblIdadeHospede.setText("Idade");
        PainelCadastro.add(lblIdadeHospede, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 113, 43, -1));

        txtIdadeHospede.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtIdadeHospede.setToolTipText("Insira a Idade: 99");
        PainelCadastro.add(txtIdadeHospede, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 71, -1));

        btnSairCadastro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSairCadastro.setText("Sair");
        btnSairCadastro.setToolTipText("Alt+0");
        btnSairCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairCadastroActionPerformed(evt);
            }
        });
        PainelCadastro.add(btnSairCadastro, new org.netbeans.lib.awtextra.AbsoluteConstraints(448, 173, 70, -1));

        cbxQuarto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbxQuarto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quarto 1 ", "Quarto 2", "Quarto 3", "Quarto 4", "Quarto 5" }));
        PainelCadastro.add(cbxQuarto, new org.netbeans.lib.awtextra.AbsoluteConstraints(414, 97, -1, -1));

        jLabel9.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 153));
        jLabel9.setText("Caixa");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 102, 153));
        jLabel11.setText("Saldo");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 102, 153));
        jLabel12.setText("Gastos");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 153));
        jLabel13.setText("Entradas");

        lblEntradas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        lblGastos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        lblSaldo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        btnSairCaixa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSairCaixa.setText("Sair");
        btnSairCaixa.setToolTipText("Alt+E");
        btnSairCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairCaixaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PainelCaixaLayout = new javax.swing.GroupLayout(PainelCaixa);
        PainelCaixa.setLayout(PainelCaixaLayout);
        PainelCaixaLayout.setHorizontalGroup(
            PainelCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelCaixaLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(PainelCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelCaixaLayout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PainelCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PainelCaixaLayout.createSequentialGroup()
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(60, 60, 60)
                            .addComponent(lblEntradas, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(PainelCaixaLayout.createSequentialGroup()
                            .addGroup(PainelCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(PainelCaixaLayout.createSequentialGroup()
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(78, 78, 78))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelCaixaLayout.createSequentialGroup()
                                    .addComponent(jLabel12)
                                    .addGap(75, 75, 75)))
                            .addGroup(PainelCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblGastos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 214, Short.MAX_VALUE)
                            .addComponent(btnSairCaixa))))
                .addGap(19, 19, 19))
        );
        PainelCaixaLayout.setVerticalGroup(
            PainelCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelCaixaLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(PainelCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSairCaixa)
                    .addGroup(PainelCaixaLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PainelCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(lblEntradas, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(PainelCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(lblGastos, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(PainelCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblSaldo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 153));
        jLabel2.setText("Novo:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 153));
        jLabel5.setText("Descrição");

        txtDescGastos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 153));
        jLabel6.setText("Valor");

        txtValorGastos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 153));
        jLabel7.setText("Gastos");

        btnSair.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnOK.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PainelGastosLayout = new javax.swing.GroupLayout(PainelGastos);
        PainelGastos.setLayout(PainelGastosLayout);
        PainelGastosLayout.setHorizontalGroup(
            PainelGastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelGastosLayout.createSequentialGroup()
                .addGroup(PainelGastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelGastosLayout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addComponent(jLabel7))
                    .addGroup(PainelGastosLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PainelGastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txtDescGastos, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(PainelGastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtValorGastos, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(121, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelGastosLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(PainelGastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelGastosLayout.createSequentialGroup()
                        .addComponent(btnOK)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelGastosLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSair)))
                .addGap(17, 17, 17))
        );
        PainelGastosLayout.setVerticalGroup(
            PainelGastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelGastosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGroup(PainelGastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelGastosLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel2))
                    .addGroup(PainelGastosLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PainelGastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PainelGastosLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtValorGastos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PainelGastosLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDescGastos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PainelGastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnOK)
                            .addComponent(btnSair))))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        PainelFundo2.setPreferredSize(new java.awt.Dimension(1068, 719));

        lblFundoGastos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pousadaapp/Pousada3.png"))); // NOI18N

        tabelaGastos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tabelaGastos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        ScpGastos.setViewportView(tabelaGastos);

        javax.swing.GroupLayout PainelFundo2Layout = new javax.swing.GroupLayout(PainelFundo2);
        PainelFundo2.setLayout(PainelFundo2Layout);
        PainelFundo2Layout.setHorizontalGroup(
            PainelFundo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelFundo2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblFundoGastos, javax.swing.GroupLayout.PREFERRED_SIZE, 961, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PainelFundo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelFundo2Layout.createSequentialGroup()
                    .addContainerGap(65, Short.MAX_VALUE)
                    .addComponent(ScpGastos, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(495, Short.MAX_VALUE)))
        );
        PainelFundo2Layout.setVerticalGroup(
            PainelFundo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelFundo2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblFundoGastos, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PainelFundo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelFundo2Layout.createSequentialGroup()
                    .addContainerGap(146, Short.MAX_VALUE)
                    .addComponent(ScpGastos, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(262, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PainelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 2840, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(3264, 3264, 3264)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1006, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PainelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PainelCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PainelCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PainelGastos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Painelfundo, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(lblQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(PainelFundo2, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PainelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel3)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PainelCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(200, 200, 200)
                                .addComponent(PainelCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20)
                        .addComponent(PainelGastos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(PainelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Painelfundo, javax.swing.GroupLayout.PREFERRED_SIZE, 654, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(lblQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(PainelFundo2, javax.swing.GroupLayout.PREFERRED_SIZE, 654, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        gasto();
        pagar(saidas);

        ScpGastos.setVisible(true);
        tabelaGastos.setVisible(true);
        lblGastos.setText(Double.toString(saidas));
        CalculacaixaPousada();
        lblSaldo.setText(Double.toString(caixaPousada));
    }//GEN-LAST:event_btnOKActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        ScpGastos.setVisible(false);
        tabelaGastos.setVisible(false);
        PainelCadastro.setVisible(false);
        PainelCaixa.setVisible(false);
        PainelGastos.setVisible(false);

    }//GEN-LAST:event_btnSairActionPerformed

    private void btnSairCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairCadastroActionPerformed
        ScpTabela.setVisible(false);
        tbllistaHospede.setVisible(false);
        PainelCadastro.setVisible(false);
        PainelCaixa.setVisible(false);
        PainelGastos.setVisible(false);
    }//GEN-LAST:event_btnSairCadastroActionPerformed

    private void txtNumeroDiariasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroDiariasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroDiariasActionPerformed

    private void txtContatoHospedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContatoHospedeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContatoHospedeActionPerformed

    private void txtCpfHospedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCpfHospedeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCpfHospedeActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        Hospedar();
        ScpTabela.setVisible(true);
        tbllistaHospede.setVisible(true);

        lblEntradas.setText(Double.toString(entradas));
        CalculacaixaPousada();
        lblSaldo.setText(Double.toString(caixaPousada));
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCaixaActionPerformed
        PainelCaixa.setVisible(true);
        PainelCadastro.setVisible(false);
        PainelGastos.setVisible(false);
        ScpTabela.setVisible(false);
        tabelaGastos.setVisible(false);
        PainelCaixa.setVisible(true);
        PainelCadastro.setVisible(false);
        PainelGastos.setVisible(false);
        ScpGastos.setVisible(false);
    }//GEN-LAST:event_btnCaixaActionPerformed

    private void btnGastosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGastosActionPerformed
        PainelFundo2.setVisible(true);
        Painelfundo.setVisible(false);
        PainelGastos.setVisible(true);
        PainelCadastro.setVisible(false);
        PainelCaixa.setVisible(false);
        ScpGastos.setVisible(true);
        tabelaGastos.setVisible(true);
    }//GEN-LAST:event_btnGastosActionPerformed

    private void btnCdastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCdastroActionPerformed
        PainelFundo2.setVisible(false);
        Painelfundo.setVisible(true);
        PainelCaixa.setVisible(false);
        PainelGastos.setVisible(false);
        PainelCadastro.setVisible(true);
      
    }//GEN-LAST:event_btnCdastroActionPerformed

    private void btnSairCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairCaixaActionPerformed
        PainelCadastro.setVisible(false);
        PainelCaixa.setVisible(false);
        PainelGastos.setVisible(false);
        ScpGastos.setVisible(false);
    }//GEN-LAST:event_btnSairCaixaActionPerformed

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
            java.util.logging.Logger.getLogger(TelaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PainelBotoes;
    private javax.swing.JPanel PainelCadastro;
    private javax.swing.JPanel PainelCaixa;
    private javax.swing.JPanel PainelFundo2;
    private javax.swing.JPanel PainelGastos;
    private javax.swing.JPanel PainelTitulo;
    private javax.swing.JPanel Painelfundo;
    private javax.swing.JScrollPane ScpGastos;
    private javax.swing.JScrollPane ScpTabela;
    private javax.swing.JButton btnCaixa;
    private javax.swing.JButton btnCdastro;
    private javax.swing.JButton btnGastos;
    private javax.swing.JButton btnOK;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSairCadastro;
    private javax.swing.JButton btnSairCaixa;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> cbxQuarto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblContatoHospede;
    private javax.swing.JLabel lblCpfHospede;
    private javax.swing.JLabel lblEntradas;
    private javax.swing.JLabel lblFundo;
    private javax.swing.JLabel lblFundoGastos;
    private javax.swing.JLabel lblGastos;
    private javax.swing.JLabel lblIdadeHospede;
    private javax.swing.JLabel lblNovoHospede;
    private javax.swing.JLabel lblNumeroDiarias;
    private javax.swing.JLabel lblQuarto;
    private javax.swing.JLabel lblSaldo;
    private javax.swing.JTable tabelaGastos;
    private javax.swing.JTable tbllistaHospede;
    private javax.swing.JTextField txtContatoHospede;
    private javax.swing.JTextField txtCpfHospede;
    private javax.swing.JTextField txtDescGastos;
    private javax.swing.JTextField txtIdadeHospede;
    private javax.swing.JTextField txtNovoHospede;
    private javax.swing.JTextField txtNumeroDiarias;
    private javax.swing.JTextField txtValorGastos;
    // End of variables declaration//GEN-END:variables
public void CalculacaixaPousada() {
        caixaPousada = entradas - saidas;
    }

}
