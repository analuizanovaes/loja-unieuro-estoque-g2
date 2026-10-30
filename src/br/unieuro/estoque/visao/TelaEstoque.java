package br.unieuro.estoque.visao;

import br.unieuro.estoque.modelo.Produto;
import br.unieuro.estoque.dao.ProdutoDAO;
import br.unieuro.estoque.excecao.EstoqueException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class TelaEstoque extends JFrame {

    private JTable tabelaEstoque;
    private DefaultTableModel modeloTabela;
    private JTextField txtBusca;
    private JButton btnBuscar;

    private final Color FUNDO = Color.decode("#ff9ed4");
    private final Color PAINEL = Color.decode("#ffe4f1");
    private final Color TEXTO = Color.decode("#0f0f0100");
    private final Color ROXO_PASTEL = Color.decode("#e7a2fc");
    private final Color ROSA = Color.decode("#ff79c6");

    public TelaEstoque() {

        setTitle("Controle de Estoque");
        setSize(700, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(FUNDO);
        setLayout(new BorderLayout(15, 15));

        JPanel painelTopo = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        painelTopo.setBackground(FUNDO);

        JLabel lblBusca = new JLabel("Pesquisar Produto:");
        lblBusca.setForeground(TEXTO);
        lblBusca.setFont(new Font("Consolas", Font.BOLD, 14));

        txtBusca = new JTextField(15);
        txtBusca.setBackground(PAINEL);
        txtBusca.setForeground(TEXTO);
        txtBusca.setCaretColor(TEXTO);
        txtBusca.setBorder(BorderFactory.createLineBorder(ROXO_PASTEL, 1));
        txtBusca.setFont(new Font("Consolas", Font.PLAIN, 14));

        btnBuscar = new JButton("Consultar Estoque");
        btnBuscar.setFont(new Font("Consolas", Font.BOLD, 14));
        btnBuscar.setBackground(ROXO_PASTEL);
        btnBuscar.setForeground(FUNDO);
        btnBuscar.setFocusPainted(false);
        btnBuscar.setBorder(new EmptyBorder(8, 15, 8, 15));
        btnBuscar.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnBuscar.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) { btnBuscar.setBackground(ROSA); }
            public void mouseExited(MouseEvent e) { btnBuscar.setBackground(ROXO_PASTEL); }
        });

        btnBuscar.addActionListener(e -> buscarEstoqueMinimo());

        painelTopo.add(lblBusca);
        painelTopo.add(txtBusca);
        painelTopo.add(btnBuscar);

        String[] colunas = {"ID", "Produto", "Qtd Atual", "Estoque Mínimo", "Status"};
        modeloTabela = new DefaultTableModel(colunas, 0);
        tabelaEstoque = new JTable(modeloTabela);

        tabelaEstoque.setBackground(PAINEL);
        tabelaEstoque.setForeground(TEXTO);
        tabelaEstoque.setRowHeight(30);
        tabelaEstoque.setFont(new Font("Consolas", Font.PLAIN, 13));
        tabelaEstoque.setGridColor(FUNDO);

        tabelaEstoque.getTableHeader().setBackground(Color.decode("#6272a4"));
        tabelaEstoque.getTableHeader().setForeground(TEXTO);
        tabelaEstoque.getTableHeader().setFont(new Font("Consolas", Font.BOLD, 14));

        JScrollPane scrollPane = new JScrollPane(tabelaEstoque);
        scrollPane.getViewport().setBackground(FUNDO);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        JPanel painelCentral = new JPanel(new BorderLayout());
        painelCentral.setBackground(FUNDO);
        painelCentral.setBorder(new EmptyBorder(0, 15, 15, 15));
        painelCentral.add(scrollPane, BorderLayout.CENTER);

        add(painelTopo, BorderLayout.NORTH);
        add(painelCentral, BorderLayout.CENTER);
    }

    private void buscarEstoqueMinimo() {

        modeloTabela.setRowCount(0);
        String filtroNome = txtBusca.getText().toLowerCase();

        List<Produto> produtos;
        try {
            produtos = new ProdutoDAO().buscarAbaixoDoMinimo(filtroNome);
        } catch (EstoqueException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage(),
                    "Erro na Consulta",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        for (Produto p : produtos) {

            boolean correspondeAoFiltro = p.getNome().toLowerCase().contains(filtroNome);

            if (p.isAbaixoDoMinimo() && correspondeAoFiltro) {

                modeloTabela.addRow(new Object[]{
                        p.getId(),
                        p.getNome(),
                        p.getQuantidadeAtual(),
                        p.getEstoqueMinimo(),
                        p.getStatusAlerta()
                });
            }
        }

        if (modeloTabela.getRowCount() == 0) {

            JOptionPane.showMessageDialog(
                    this,
                    "Nenhum produto com estoque crítico corresponde a esta busca.",
                    "Resultado da Consulta",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }
}