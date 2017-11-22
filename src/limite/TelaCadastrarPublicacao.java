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
public class TelaCadastrarPublicacao extends JFrame implements ActionListener {

    private final controlePublicacao ctrlPublicacao;
    private final JPanel painel = new JPanel(new GridBagLayout());
    private final JTextField tfISBN = new JTextField(20);
    private final JTextField tfTitulo = new JTextField(20);
    private final JTextField tfAutor = new JTextField(20);
    private final JTextField tfEditora = new JTextField(20);
    //private final JTextField tfStatus = new JTextField(20);
    private final JTextField tfExemplar = new JTextField(20);
    private final JButton btnCadastrar = new JButton("Cadastrar");

    public TelaCadastrarPublicacao(controlePublicacao controle) {
        super("Cadastrar publicação");
        this.ctrlPublicacao = controle;

        painel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(20, 30, 15, 50),
                BorderFactory.createEmptyBorder()));

        adicionarComponente(painel, new JLabel("ISBN"), 0, 1, 1, 1);
        adicionarComponente(painel, tfISBN, 1, 1, 1, 1);

        adicionarComponente(painel, new JLabel("Titulo"), 0, 2, 1, 1);
        adicionarComponente(painel, tfTitulo, 1, 2, 1, 1);

        adicionarComponente(painel, new JLabel("Autor"), 0, 3, 1, 1);
        adicionarComponente(painel, tfAutor, 1, 3, 1, 1);

        adicionarComponente(painel, new JLabel("Editora"), 0, 4, 1, 1);
        adicionarComponente(painel, tfEditora, 1, 4, 1, 1);

        //adicionarComponente(painel, new JLabel("Numero sequencia do exemplar"), 0, 5, 1, 1);
        //adicionarComponente(painel, tfExemplar, 1, 5, 1, 1);
        btnCadastrar.addActionListener(this);
        adicionarComponente(painel, btnCadastrar, 2, 6, 1, 3);

        super.add(painel);
        super.pack();
        super.setLocationRelativeTo(null);

        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        super.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int ISBN = Integer.parseInt(tfISBN.getText());
            String titulo = tfTitulo.getText();
            String autor = tfAutor.getText();
            String editora = tfEditora.getText();
            int exemplar = Integer.parseInt(tfExemplar.getText());
            controleExemplar ctrlExemplar = new controleExemplar();
            if(ctrlPublicacao.verificaSeISBNExiste(ISBN) == null){
                ctrlPublicacao.cadastraPublicacao(new Publicacao(ISBN, titulo, autor, editora, "Disponivel"));
                System.out.print("Agora: ");
                ctrlPublicacao.serializar();
                JOptionPane.showMessageDialog(this, "Cadastro realizado com sucesso");
                this.dispose();

            } else {
                JOptionPane.showMessageDialog(this, "ISBN já existente");
                //this.tfAutor.setText("");
                //this.tfEditora.setText("");
                //this.tfExemplar.setText("");
                this.tfISBN.setText("");
                //this.tfTitulo.setText("");

            }//Fazer else
        } catch (Exception exc) {
            System.out.print("aqui\n");

            JOptionPane.showMessageDialog(this, exc.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);

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
