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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
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
public class TelaNovoEmprestimo extends JFrame implements ActionListener {

    private final controleAssociado assoc = new controleAssociado();
    private controleEmprestimo ctrlEmprestimo;
        private controleExemplar ctrlExemplar;

    private final JPanel painel = new JPanel(new GridBagLayout());
    private final JTextField tfNumeroExemplar = new JTextField(20);
    private final JTextField tfISBN = new JTextField(20);
    private final JTextField tfcodigoAssociado = new JTextField(20);
    private final JTextField tfDia = new JTextField(2);
    private final JTextField tfMes = new JTextField(2);
    private final JTextField tfAno = new JTextField(4);
    private GregorianCalendar dataInicial;
    private final JFormattedTextField tfData = new JFormattedTextField(new SimpleDateFormat("dd/MM/yyyy"));
    private final JButton btnCadastrar = new JButton("Cadastrar emprestimo");

    public TelaNovoEmprestimo(controleEmprestimo controle, controleExemplar controle2) {
        super("Cadastra Emprestimo");
        this.ctrlEmprestimo = controle;
        this.ctrlExemplar = controle2;

        painel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(20, 30, 20, 25),
                BorderFactory.createEmptyBorder()));

        try {
            adicionarComponente(painel, new JLabel("Numero do exemplar"), 0, 0, 1, 1);
            adicionarComponente(painel, tfNumeroExemplar, 1, 0, 1, 1);

            adicionarComponente(painel, new JLabel("ISBN"), 0, 1, 1, 1);
            adicionarComponente(painel, tfISBN, 1, 1, 1, 1);

            adicionarComponente(painel, new JLabel("Codigo do Associado"), 0, 2, 1, 1);
            adicionarComponente(painel, tfcodigoAssociado, 1, 2, 1, 1);

            adicionarComponente(painel, new JLabel("Data "), 0, 3, 1, 1);
            MaskFormatter dateMask = new MaskFormatter("##/##/2017");
            dateMask.install(tfData);
            adicionarComponente(painel, tfData, 1, 3, 1, 1);

            
            btnCadastrar.addActionListener(this);
            adicionarComponente(painel, btnCadastrar, 2, 6, 1, 3);
            super.add(painel);
            super.pack();
            super.setLocationRelativeTo(null);
            super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            super.setVisible(true);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Erro no formato da data!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {

            int numeroExemplar = Integer.parseInt(tfNumeroExemplar.getText());
            int ISBN = Integer.parseInt(tfISBN.getText());
            int codigoAssociado = Integer.parseInt(tfcodigoAssociado.getText());
            

            Associado aw = ctrlEmprestimo.verificaAssoc(codigoAssociado);
            Exemplar aq = ctrlExemplar.procuraExemplar2(ISBN, numeroExemplar);
            GregorianCalendar gc = criarData(this.tfData.getText());

            if (aq != null && aq.getStatus().equalsIgnoreCase("Disponivel") && aw != null && gc!=null) {
               // aq.setStatus("Indisponivel");
                
                ctrlEmprestimo.fazerEmprestimo(new Emprestimo(gc, aq, ISBN, codigoAssociado, aw.getTempoMax()));
                this.ctrlEmprestimo.serializar();
                JOptionPane.showMessageDialog(null, "Emprestimo realizado");
                this.dispose();
            } else {if(aq == null || aq.getStatus().equalsIgnoreCase("Indisponivel"))
                JOptionPane.showMessageDialog(null, "Impossivel emprestar exemplar");
            if(aw == null)
                JOptionPane.showMessageDialog(null, "Codigo de associado inválido");
            }
            this.ctrlEmprestimo.serializar();
            this.ctrlExemplar.serializar();
        } catch (Exception exc) {
            System.out.print("\nd1");

        }
    }

    private GregorianCalendar criarData(String data) throws Exception {
        try {
            SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
            GregorianCalendar gc = new GregorianCalendar();
            Date date = new Date(fmt.parse(data).getTime());
            Date hj = new Date();
           // System.out.println("Mes "+date.getMonth());
            if (date.getMonth() > hj.getMonth()
                    || (date.getDate() > hj.getDate() && date.getMonth() == hj.getMonth())) {
                JOptionPane.showMessageDialog(null, "Data inválida");
            } else {
                gc.setTime(date);
                return gc;
            }
            return null;
        } catch (ParseException exc) {
            throw new Exception("Data no formato errado!");
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
