package Gerenciador.Telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Gerenciador.Conexao;
import Gerenciador.Planilhas.Usuario;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipal extends JFrame {
	static Conexao con = new Conexao("jdbc:mysql://localhost:3306/controlefinanceiro", "root", "L0p3s09@");

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal(Usuario dadosrecebidos) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 749, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_bemvindo_principal = new JLabel("BEM VINDO, " + dadosrecebidos.getNome_usuario());
		lbl_bemvindo_principal.setBounds(211, 11, 475, 26);
		lbl_bemvindo_principal.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		contentPane.add(lbl_bemvindo_principal);
		
		JPanel panel = new JPanel();
		panel.setBounds(96, 188, 526, 216);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(2, 2, 5, 5));
		
		JButton bnt_receita = new JButton("Tabela Receitas");
		bnt_receita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaReceita receita = new TelaReceita();
				receita.setVisible(true);
				dispose();
			}
		});
		bnt_receita.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		panel.add(bnt_receita);
		
		JButton bnt_despesa = new JButton("Tabela Despesas");
		bnt_despesa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaDespesas teladespesa = new TelaDespesas();
				teladespesa.setVisible(true);
				dispose();
			}
		});
		bnt_despesa.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		panel.add(bnt_despesa);
		
		JButton bnt_login = new JButton("Login");
		bnt_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLogin telalogin = new TelaLogin();
				telalogin.setVisible(true);
				dispose();
			}
		});
		bnt_login.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		panel.add(bnt_login);
		
		JButton bnt_sair = new JButton("Sair");
		bnt_sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		bnt_sair.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		panel.add(bnt_sair);
		
		JLabel lbl_principal = new JLabel("Selecione a opção desejada!.");
		lbl_principal.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lbl_principal.setBounds(224, 114, 248, 26);
		contentPane.add(lbl_principal);
		
		
	}
}
