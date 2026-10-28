package br.unieuro.estoque.principal;

import br.unieuro.estoque.visao.TelaEstoque;
import javax.swing.UIManager;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {

        try {

            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        } catch (Exception ignored) {}

        SwingUtilities.invokeLater(() -> {

            TelaEstoque tela = new TelaEstoque();
            tela.setVisible(true);
        });
    }
}