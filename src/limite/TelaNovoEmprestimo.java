/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package limite;

import controle.*;
import entidade.Emprestimo;
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
public class TelaNovoEmprestimo extends JFrame implements ActionListener {

    private final controleAssociado assoc = new controleAssociado();
    private controleEmprestimo ctrlEmprestimo = new controleEmprestimo();
    private final JPanel painel = new JPanel(new GridBagLayout());
    private final JTextField tfNumeroExemplar = new JTextField(20);
    private final JTextField tfISBN = new JTextField(20);
    private final JTextField tfcodigoAssociado = new JTextField(20);
    private final JTextField tfDia = new JTextField(02);
    private final JTextField tfMes = new JTextField(02);
    private final JTextField tfAno = new JTextField(02);

    private final JButton btnCadastrar = new JButton("Cadastrar emprestimo");

    public TelaNovoEmprestimo(controleEmprestimo controle) {
        super("Cadastra Emprestimo");
        this.ctrlEmprestimo = controle;

        painel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(20, 30, 50, 35),
                BorderFactory.createEmptyBorder()));

        adicionarComponente(painel, new JLabel("Numero do exemplar"), 0, 0, 1, 1);
        adicionarComponente(painel, tfNumeroExemplar, 1, 0, 1, 1);

        adicionarComponente(painel, new JLabel("ISBN"), 0, 1, 1, 1);
        adicionarComponente(painel, tfISBN, 1, 1, 1, 1);

        adicionarComponente(painel, new JLabel("Codigo do Associado"), 0, 2, 1, 1);
        adicionarComponente(painel, tfcodigoAssociado, 1, 2, 1, 1);

        adicionarComponente(painel, new JLabel("Dia"), 0, 3, 1, 1);
        adicionarComponente(painel, tfDia, 1, 3, 1, 1);

        adicionarComponente(painel, new JLabel("Mes"), 0, 4, 1, 1);
        adicionarComponente(painel, tfMes, 1, 4, 1, 1);

        adicionarComponente(painel, new JLabel("Ano"), 0, 5, 1, 1);
        adicionarComponente(painel, tfAno, 1, 5, 1, 1);

        btnCadastrar.addActionListener(this);
        adicionarComponente(painel, btnCadastrar, 0, 6, 1, 2);
        super.add(painel);
        super.pack();
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        super.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int numeroExemplar = Integer.parseInt(tfNumeroExemplar.getText());
            int ISBN = Integer.parseInt(tfISBN.getText());
            int codigoAssociado = Integer.parseInt(tfcodigoAssociado.getText());
            int dia = Integer.parseInt(tfDia.getText());
            int mes = Integer.parseInt(tfMes.getText());
            int ano = Integer.parseInt(tfAno.getText());
            int prazo = 0;
            ctrlEmprestimo.fazerEmprestimo(new Emprestimo(numeroExemplar, ISBN, dia, mes, ano, codigoAssociado, prazo));
            this.dispose();
        } catch (Exception exc) {

        }
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
    
}
