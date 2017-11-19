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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Laiza
 */
public class TelaConsultaPublicacao extends JFrame implements ActionListener {

    controleExemplar ctrlExemplar;
    private final JPanel painel = new JPanel(new GridBagLayout());
    private JTextField tfCampoTitulo = new JTextField(20);
    private JTextField tfCampoISBN = new JTextField(20);
    private JTextArea resultado = new JTextArea(20, 40);
    private final JComboBox cbProcura = new JComboBox();
    private final JButton btnProcurar = new JButton("Procurar");
    private final JButton btnVai = new JButton("Selecionar");

    public TelaConsultaPublicacao(controleExemplar ctrlExemplar) {
        this.ctrlExemplar = ctrlExemplar;
        
        tfCampoTitulo.setEditable(false);
        tfCampoISBN.setEditable(false);
        cbProcura.addItem("Titulo");
        cbProcura.addItem("ISBN");
        adicionarComponente(painel, new JLabel("Procurar por: "), 0, 1, 1, 1);
        adicionarComponente(painel, this.cbProcura, 0, 2, 1, 1);

        btnVai.addActionListener(this);
        adicionarComponente(painel, this.btnVai, 1, 2, 1, 1);

        adicionarComponente(painel, new JLabel("Titulo: "), 0, 3, 1, 1);
        adicionarComponente(painel, this.tfCampoTitulo, 1, 3, 1, 1);

        adicionarComponente(painel, new JLabel("ISBN: "), 0, 4, 1, 1);
        adicionarComponente(painel, this.tfCampoISBN, 1, 4, 1, 1);

        btnProcurar.addActionListener(this);
        adicionarComponente(painel, this.btnProcurar, 1, 5, 1, 1);

        JScrollPane scroll = new JScrollPane(resultado,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        adicionarComponente(painel, new JLabel("Lista publicações cadastradas"), 0, 2, 1, 1);
        adicionarComponente(painel, scroll, 1, 6, 1, 1);
        super.add(painel);
        super.pack();
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
    public void actionPerformed(ActionEvent ae) {
        JButton btn = (JButton) ae.getSource();
        if (btn.equals(this.btnVai)) {

            if (cbProcura.getSelectedItem().toString().equalsIgnoreCase("Titulo")) {
                tfCampoTitulo.setEditable(true);
                tfCampoTitulo.setText("");
                tfCampoISBN.setText("");

                tfCampoISBN.setEditable(false);
                this.resultado.setText("");

            }
            if (cbProcura.getSelectedItem().toString().equalsIgnoreCase("ISBN")) {
                tfCampoISBN.setEditable(true);
                tfCampoTitulo.setText("");
                tfCampoISBN.setText("");

                tfCampoTitulo.setEditable(false);
                this.resultado.setText("");

            }
        }
        if (btn.equals(this.btnProcurar)) {
            if (cbProcura.getSelectedItem().toString().equalsIgnoreCase("Titulo")) {
                String titulo = tfCampoTitulo.getText();
                this.resultado.setText(ctrlExemplar.procuraporTitulo(titulo));

            }
            if (cbProcura.getSelectedItem().toString().equalsIgnoreCase("ISBN")) {
                int ISBN = Integer.parseInt(tfCampoISBN.getText());
                String ex = ctrlExemplar.procuraporISBN(ISBN) ;
                this.resultado.setText(ex);

            }
        }

    }

    public static void main(String args[]) {
        new TelaConsultaPublicacao(new controleExemplar());
    }
}
