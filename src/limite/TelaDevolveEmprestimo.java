/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package limite;

import controle.*;
import entidade.Data;
import entidade.Exemplar;
import entidade.Publicacao;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Laiza
 */
public class TelaDevolveEmprestimo extends JFrame implements ActionListener {

    private final controleAssociado assoc = new controleAssociado();
    private controleExemplar ctrlExemplar;
    private controleEmprestimo ctrlEmprestimo;
    private final JPanel painel = new JPanel(new GridBagLayout());
    private final JTextField tfNumeroExemplar = new JTextField(20);
    private final JTextField tfISBN = new JTextField(20);
    private final JTextField tfcodigoAssociado = new JTextField(20);

    private GregorianCalendar dataInicial;
    private final JFormattedTextField tfData = new JFormattedTextField(new SimpleDateFormat("dd/MM/yyyy"));
    private final JButton btnDevolver = new JButton("Devolver");
    private final JButton btnVai = new JButton("Busca");

    public TelaDevolveEmprestimo(controleEmprestimo ctrl, controleExemplar ctrlExemplar) {
        super("Devolve Emprestimo");
        this.ctrlEmprestimo = ctrl;
        this.ctrlExemplar = ctrlExemplar;
        //this.ctrlEmprestimo.lerEmprestimos();

        painel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(20, 30, 20, 25),
                BorderFactory.createEmptyBorder()));
        /*tfNumeroExemplar.setEditable(false);
        tfISBN.setEditable(false);

        adicionarComponente(painel, new JLabel("Codigo do Associado"), 0, 0, 1, 1);
        adicionarComponente(painel, tfcodigoAssociado, 1, 0, 1, 1);*/

        adicionarComponente(painel, new JLabel("Numero do exemplar"), 0, 2, 1, 1);
        adicionarComponente(painel, tfNumeroExemplar, 1, 2, 1, 1);

        adicionarComponente(painel, new JLabel("ISBN"), 0, 3, 1, 1);
        adicionarComponente(painel, tfISBN, 1, 3, 1, 1);
        this.btnVai.addActionListener(this);
        //btnVai.setSize(2, 2);
        //adicionarComponente(painel, btnVai, 2, 0, 1, 1);

        this.btnDevolver.addActionListener(this);
        adicionarComponente(painel, btnDevolver, 3, 5, 1, 3);
        super.add(painel);
        super.pack();
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        super.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        JButton btn = (JButton) ae.getSource();
       
        if (btn.equals(this.btnDevolver)) {
            try {
               int res = this.ctrlEmprestimo.devolucao2( Integer.parseInt(this.tfISBN.getText()),Integer.parseInt(this.tfNumeroExemplar.getText()));
           if(res == 0){
               ctrlExemplar.procuraExemplar2(Integer.parseInt(this.tfISBN.getText()),Integer.parseInt(this.tfNumeroExemplar.getText())).setStatus("Disponivel");
           }
                this.ctrlEmprestimo.serializar();
                this.ctrlExemplar.serializar();
//                this.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "ERRO");
            }
            this.dispose();
        }

    }

    private int avaliaDiferenca(Date data) {
        Date hj = new Date();
        Data a = new Data();
        int dif = a.diferenca(new Data(data.getDate(), data.getMonth()), new Data(hj.getDate(), hj.getMonth()));
        return dif;
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

    /*public static void main(String x[]) {
        new TelaDevolveEmprestimo();
    }*/
}
