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
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.ParseException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Laiza
 */
public class TelaPrincipal extends JFrame implements ActionListener, WindowListener {

    private final JPanel painel = new JPanel(new GridBagLayout());
    private final JButton btnCadastrarAssociado = new JButton("Cadastrar associado");
    private final JButton btnCadastrarExemplar = new JButton("Cadastrar exemplar");
    private final JButton btnCadastrarPublicacao = new JButton("Cadastrar publicação");
    private final JButton btnEmprestimo = new JButton("Novo empréstimo");
    private final JButton btnListaExemplar = new JButton("Listar exemplares");
    private final JButton btnListaPublicacoes = new JButton("Listar publicações");

    private final JButton btnsair = new JButton("Sair");

    private controleAssociado ctrlAssociado;
    private controleEmprestimo ctrlEmprestimo;
    private controleExemplar ctrlExemplar;
    private controlePublicacao ctrlPublicacao;

    private void inicializaControles() {
        ctrlExemplar = new controleExemplar();
        ctrlAssociado = new controleAssociado();
        ctrlEmprestimo = new controleEmprestimo();
        ctrlPublicacao = new controlePublicacao();
    }

    public TelaPrincipal() {
        super("Sistema de biblioteca");
        this.inicializaControles();
        painel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(30, 50, 30, 50),
                BorderFactory.createEmptyBorder()));

        this.btnCadastrarAssociado.addActionListener(this);
        this.btnCadastrarExemplar.addActionListener(this);
        this.btnCadastrarPublicacao.addActionListener(this);
        this.btnEmprestimo.addActionListener(this);
        this.btnListaExemplar.addActionListener(this);
        this.btnListaPublicacoes.addActionListener(this);
        
        adicionarComponente(painel, this.btnCadastrarAssociado, 0, 0, 1, 1);
        adicionarComponente(painel, this.btnCadastrarExemplar, 0, 1, 1, 1);
        adicionarComponente(painel, this.btnCadastrarPublicacao, 0, 2, 1, 1);
        adicionarComponente(painel, this.btnEmprestimo, 0, 3, 1, 1);
        adicionarComponente(painel, this.btnListaExemplar, 0, 4, 1, 1);
        adicionarComponente(painel, this.btnListaPublicacoes, 0, 5, 1, 1);

        super.add(painel);
        super.addWindowListener(this);
        super.pack();
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setVisible(true);

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

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        try {
            if (btn.equals(this.btnCadastrarAssociado)) {
                new TelaCadastrarAssociado(this.ctrlAssociado);
                this.ctrlAssociado.serializar();
            }
            if (btn.equals(this.btnCadastrarExemplar)) {
                new TelaCadastrarExemplar(this.ctrlExemplar);
                this.ctrlExemplar.serializar();
            }
            if (btn.equals(this.btnCadastrarPublicacao)) {
                new TelaCadastrarPublicacao(this.ctrlPublicacao);
                this.ctrlPublicacao.serializar();
            }
            if (btn.equals(this.btnEmprestimo)) {
                new TelaNovoEmprestimo(this.ctrlEmprestimo);
                this.ctrlEmprestimo.serializar();
            }
            if (btn.equals(this.btnListaExemplar)) {
                new TelaExibeExemplar(this.ctrlExemplar);
                
            }
            if (btn.equals(this.btnListaPublicacoes)) {
                new TelaExibePublicacoes(this.ctrlPublicacao);
                
            }

        } catch (Exception exc) {

        }
    }

    @Override
    public void windowOpened(WindowEvent we) {
    }

    @Override
    public void windowClosing(WindowEvent we) {
        try {
            this.ctrlExemplar.serializar();

            this.ctrlAssociado.serializar();
            this.ctrlEmprestimo.serializar();
            this.ctrlPublicacao.serializar();
        } catch (Exception exc) {

        }
    }

    @Override
    public void windowClosed(WindowEvent we) {
    }

    @Override
    public void windowIconified(WindowEvent we) {
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
    }

    @Override
    public void windowActivated(WindowEvent we) {
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
    }

    public static void main(String h[]) {
        new TelaPrincipal();
    }
}