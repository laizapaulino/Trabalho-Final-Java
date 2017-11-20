/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package limite;

import controle.*;
import entidade.Exemplar;
import entidade.Publicacao;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Laiza
 */
public class TelaCadastrarExemplar extends JFrame implements ActionListener {

    private controleExemplar ctrlExemplar;
    private final JPanel painel = new JPanel(new GridBagLayout());
    private final JTextField tfNumero = new JTextField(20);
    private final JTextField tfISBN = new JTextField(20);
    private final JTextField tfPreco = new JTextField(6);
    private final JButton btnCadastrar = new JButton("Cadastrar");

    public TelaCadastrarExemplar(controleExemplar controle) {
        super("Cadastrar exemplar");
        this.ctrlExemplar = controle;

        painel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(20, 30, 20, 35),
                BorderFactory.createEmptyBorder()));

        adicionarComponente(painel, new JLabel("ISBN"), 0, 0, 1, 1);
        adicionarComponente(painel, tfISBN, 1, 0, 1, 1);

        adicionarComponente(painel, new JLabel("Numero de sequencia (após o 1)"), 0, 1, 1, 1);
        adicionarComponente(painel, tfNumero, 1, 1, 1, 1);

        adicionarComponente(painel, new JLabel("Preco"), 0, 2, 1, 1);
        adicionarComponente(painel, tfPreco, 1, 2, 1, 1);

        btnCadastrar.addActionListener(this);
        adicionarComponente(painel, btnCadastrar, 2, 3, 1, 1);
        super.add(painel);
        super.pack();
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        super.setVisible(true);

    }

    private void adicionarComponente(JPanel painel, JComponent componente, int gridx, int gridy, int height, int width) {
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.gridx = gridx;
        c.gridy = gridy;
        c.gridheight = height;
        c.gridwidth = width;
        painel.add(componente, c);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            int numero = Integer.parseInt("1" + tfNumero.getText());
            int ISBN = Integer.parseInt(tfISBN.getText());
            float preco = Float.parseFloat(tfPreco.getText());
            controlePublicacao x = new controlePublicacao();
            Publicacao a = x.verificaSeISBNExiste(ISBN);
            if (a != null) {
                ctrlExemplar.cadastraExemplar(new Exemplar(a, numero, ISBN, preco));
                JOptionPane.showMessageDialog(this, "Cadastro realizado com sucesso");
                this.ctrlExemplar.serializar();
                this.dispose();
            } else {
                tfISBN.setText("");
                JOptionPane.showMessageDialog(this, "Erro dados inválidos");
            }

        } catch (Exception exc) {
            // System.out.print("aqui\n");

            JOptionPane.showMessageDialog(this, exc.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);

        }
    }

}
