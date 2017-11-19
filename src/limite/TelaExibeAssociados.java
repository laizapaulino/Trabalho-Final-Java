/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package limite;

import controle.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Laiza
 */
public class TelaExibeAssociados extends JFrame implements ActionListener {

    private controleAssociado ctrlAssociado;
    private final JPanel painel = new JPanel(new GridBagLayout());
    private final JTextArea resultado = new JTextArea(20, 40);
    private final JComboBox cbStatus = new JComboBox();
    private final JButton btnProcurar = new JButton("Procurar");

    public TelaExibeAssociados(controleAssociado ctrlAssociado) {
        //super("Lista exemplares cadastrados");
        this.ctrlAssociado = ctrlAssociado;
        painel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(35, 55, 35, 55),
                BorderFactory.createEmptyBorder()));

        resultado.setEditable(false);
        //String isso = this.ctrlAssociado.retornaPorStatus(Status);
        // resultado.setText(isso+"\n\n");
        this.cbStatus.addItem("Graduação");
        this.cbStatus.addItem("Pós-graduação");
        this.cbStatus.addItem("Professor");
        this.btnProcurar.addActionListener(this);
        adicionarComponente(painel, this.cbStatus, 0, 1, 1, 1);
        adicionarComponente(painel, this.btnProcurar, 1, 1, 1, 1);

        JScrollPane scroll = new JScrollPane(resultado,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        adicionarComponente(painel, new JLabel("Lista associados cadastrados"), 0, 2, 1, 1);
        adicionarComponente(painel, scroll, 0, 3, 1, 1);
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
        try {
            this.ctrlAssociado.lerAssociados();
            //String a = this.ctrlAssociado.retornaPorStatus(cbStatus.getSelectedItem().toString());
            resultado.setText(this.ctrlAssociado.retornaPorStatus(cbStatus.getSelectedItem().toString()));
        } catch (Exception exc) {

        }
    }
}
