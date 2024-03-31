package cadastroclientes;

import cadastroclientes.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private CadastroClientes cadastro;
    private JTextArea textArea;

    public Main() {
        cadastro = new CadastroClientes();
        JButton salvarButton = new JButton("Salvar Clientes");
        JButton adicionarButton = new JButton("Adicionar Cliente");
        JButton visualizarButton = new JButton("Visualizar Clientes");
        JButton atualizarButton = new JButton("Atualizar Cliente");
        JButton excluirButton = new JButton("Excluir Cliente");

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastro.salvarClientes();
                JOptionPane.showMessageDialog(Main.this, "Clientes salvos com sucesso!", "Salvar Clientes", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField nomeField = new JTextField(10);
                JTextField emailField = new JTextField(10);
                JTextField telefoneField = new JTextField(10);

                JPanel panel = new JPanel(new GridLayout(0, 1));
                panel.add(new JLabel("Nome:"));
                panel.add(nomeField);
                panel.add(new JLabel("Email:"));
                panel.add(emailField);
                panel.add(new JLabel("Telefone:"));
                panel.add(telefoneField);

                int result = JOptionPane.showConfirmDialog(Main.this, panel, "Adicionar Cliente", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    String nome = nomeField.getText();
                    String email = emailField.getText();
                    String telefone = telefoneField.getText();

                    Cliente novoCliente = new Cliente(nome, email, telefone);

                    cadastro.adicionarCliente(novoCliente);
                }
            }
        });

        visualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastro.visualizarClientes();
            }
        });

        atualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField indexField = new JTextField(5);
                JTextField nomeField = new JTextField(10);
                JTextField emailField = new JTextField(10);
                JTextField telefoneField = new JTextField(10);

                JPanel panel = new JPanel(new GridLayout(0, 1));
                panel.add(new JLabel("Índice do Cliente a Atualizar:"));
                panel.add(indexField);
                panel.add(new JLabel("Novo Nome:"));
                panel.add(nomeField);
                panel.add(new JLabel("Novo Email:"));
                panel.add(emailField);
                panel.add(new JLabel("Novo Telefone:"));
                panel.add(telefoneField);

                int result = JOptionPane.showConfirmDialog(Main.this, panel, "Atualizar Cliente", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    int index = Integer.parseInt(indexField.getText()) - 1;
                    String nome = nomeField.getText();
                    String email = emailField.getText();
                    String telefone = telefoneField.getText();

                    Cliente novoCliente = new Cliente(nome, email, telefone);

                    cadastro.atualizarCliente(index, novoCliente);
                }
            }
        });

        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String indexStr = JOptionPane.showInputDialog(Main.this, "Digite o índice do cliente a ser excluído:");
                if (indexStr != null && !indexStr.isEmpty()) {
                    int index = Integer.parseInt(indexStr) - 1;
                    cadastro.excluirCliente(index);
                    JOptionPane.showMessageDialog(Main.this, "Cliente excluído com sucesso!", "Excluir Cliente", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 1));
        buttonPanel.add(salvarButton);
        buttonPanel.add(adicionarButton);
        buttonPanel.add(visualizarButton);
        buttonPanel.add(atualizarButton);
        buttonPanel.add(excluirButton);

        add(buttonPanel);

        setTitle("Cadastro de Clientes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }
}