/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package limite;

import controle.*;
import entidade.Associado;
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
public class TelaCadastrarAssociado extends JFrame implements ActionListener {
    
    private controleAssociado ctrlAssociado;
    private final JPanel painel = new JPanel(new GridBagLayout());
    private final JTextField tfCodigo = new JTextField(20);
    private final JTextField tfNome = new JTextField(20);
    private final JTextField tfEndereco = new JTextField(30);
    private final JTextField tfEmail = new JTextField(30);
    private final JTextField tfStatus = new JTextField(10);
    
    private final JButton btncadastrar = new JButton("Cadastrar associado");
    
    public TelaCadastrarAssociado(controleAssociado controle) {
        super("Cadastrar novo associado");
        this.ctrlAssociado = controle;
        
        painel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(50, 75, 50, 75),
                BorderFactory.createEmptyBorder()));
        
        adicionarComponente(painel, new JLabel("Código"), 0, 0, 1, 1);
        adicionarComponente(painel, tfCodigo, 1, 0, 1, 1);
        
        adicionarComponente(painel, new JLabel("Nome"), 0, 1, 1, 1);
        adicionarComponente(painel, tfNome, 1, 1, 1, 1);
        
        adicionarComponente(painel, new JLabel("Endereço"), 0, 2, 1, 1);
        adicionarComponente(painel, tfEndereco, 1, 2, 1, 1);
        
        adicionarComponente(painel, new JLabel("Email"), 0, 3, 1, 1);
        adicionarComponente(painel, tfEmail, 1, 3, 1, 1);
        
        adicionarComponente(painel, new JLabel("Status"), 0, 4, 1, 1);
        adicionarComponente(painel, tfStatus, 1, 4, 1, 1);//Não deve ser um campo de texto

        btncadastrar.addActionListener(this);
        adicionarComponente(painel, btncadastrar, 1, 5, 1, 1);
        
        super.add(painel);
        super.pack();
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        super.setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent e) {
        try {
            int codigo = Integer.parseInt(tfCodigo.getText());
            String nome = tfNome.getText();
            String endereco = tfEndereco.getText();
            String email = tfEmail.getText();
            String status = tfStatus.getText();
            ctrlAssociado.cadastraAssociado(new Associado(codigo, nome, endereco, email, status));
           ctrlAssociado.serializar();
            this.dispose();
        }catch (Exception exc){
            
        }
    }

    public void adicionarComponente(JPanel painel, JComponent componente, int gridx, int gridy, int height, int width) {
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
