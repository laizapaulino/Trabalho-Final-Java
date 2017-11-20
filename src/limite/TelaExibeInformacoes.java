/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package limite;

import controle.*;
import entidade.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Laiza
 */
public class TelaExibeInformacoes extends JFrame implements ActionListener {
//FALTA IMPLEMENTAR VER OS ASSOCIADOS
    private final JPanel painel = new JPanel(new GridBagLayout());

    private final JButton btnListaExemplar = new JButton("Listar exemplares");
    private final JButton btnListaPublicacoes = new JButton("Listar publicações");
    private final JButton btnListaAssociados = new JButton("Listar associados");
        private final JButton btnConsultaPublicacao = new JButton("Consultar publicaçao");
        private final JButton btnListaEmprestimos = new JButton("Lista emprestimos");

    private controlePublicacao ctrlPublicacao;
    private controleExemplar ctrlExemplar;
    private controleAssociado ctrlAssociado;

    //No construtor colocar outros controles talvez
    public TelaExibeInformacoes(controlePublicacao ctrlPublicacao, controleExemplar ctrlExemplar, controleAssociado ctrlAssociado) {
        super("Informações gerais");
        painel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(30, 50, 30, 50),
                BorderFactory.createEmptyBorder()));

        this.ctrlPublicacao = ctrlPublicacao;
        this.ctrlExemplar = ctrlExemplar;
        this.ctrlAssociado = ctrlAssociado;

        this.btnListaAssociados.addActionListener(this);
        this.btnListaExemplar.addActionListener(this);
        this.btnListaPublicacoes.addActionListener(this);
        this.btnConsultaPublicacao.addActionListener(this);
        this.btnListaEmprestimos.addActionListener(this);

        adicionarComponente(painel, this.btnListaPublicacoes, 0, 1, 1, 1);
        adicionarComponente(painel, this.btnListaExemplar, 0, 2, 1, 1);

        adicionarComponente(painel, this.btnListaAssociados, 0, 3, 1, 1);
        //adicionarComponente(painel, tfTitulo, 0, 4, 1, 1);
        
        adicionarComponente(painel, this.btnConsultaPublicacao, 0, 4, 1, 1);
        adicionarComponente(painel, this.btnListaEmprestimos, 0, 5, 1, 1);

        super.add(painel);
        super.pack();
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        super.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        JButton btn = (JButton) ae.getSource();
        try {

            if (btn.equals(this.btnListaExemplar)) {
                new TelaExibeExemplar(new controleExemplar());
            }
            if (btn.equals(this.btnListaPublicacoes)) {
               new TelaExibePublicacoes(this.ctrlPublicacao);

            }
            else if (btn.equals(this.btnListaAssociados)) {
                  new TelaExibeAssociados(this.ctrlAssociado);

            }
            else if (btn.equals(this.btnConsultaPublicacao)) {
                  new TelaConsultaPublicacao(new controleExemplar());

            }
            else if (btn.equals(this.btnListaEmprestimos)) {
                  new TelaExibeEmprestimos(new controleEmprestimo());

            }


        } catch (Exception exc) {

        }
    }

    private void adicionarComponente(JPanel painel, JComponent componente,
            int gridx, int gridy, int height, int width) {
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
