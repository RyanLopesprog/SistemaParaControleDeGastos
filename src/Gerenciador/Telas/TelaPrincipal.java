package Gerenciador.Telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Gerenciador.Conexao;
import Gerenciador.Setup;
import Gerenciador.Planilhas.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
	static Conexao con = new Conexao("jdbc:mysql://localhost:3306/controlefinanceiro", "root", "Aluno");

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
		lbl_bemvindo_principal.setBounds(209, 26, 475, 26);
		lbl_bemvindo_principal.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		contentPane.add(lbl_bemvindo_principal);

		JPanel panel = new JPanel();
		panel.setBounds(103, 188, 526, 116);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 3, 3, 5));

		JButton bnt_receita = new JButton("Tabela Receitas");
		bnt_receita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaReceita receita = new TelaReceita(dadosrecebidos);
				receita.setVisible(true);
				dispose();
			}
		});
		bnt_receita.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		panel.add(bnt_receita);

		JButton bnt_despesa = new JButton("Tabela Despesas");
		bnt_despesa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaDespesas teladespesa = new TelaDespesas(dadosrecebidos);
				teladespesa.setVisible(true);
				dispose();
			}
		});
		bnt_despesa.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		panel.add(bnt_despesa);

		JButton bnt_dropdata = new JButton("Resetar");
		bnt_dropdata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mensagem = "Você tem certeza de que deseja apagar todos os dados?";

				int resposta = JOptionPane.showConfirmDialog(null, mensagem, "Aviso", JOptionPane.YES_NO_OPTION,
						JOptionPane.WARNING_MESSAGE);

				if (resposta == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(null, "Dados apagados com sucesso.", "Confirmação",
							JOptionPane.INFORMATION_MESSAGE);
					Setup.drop();
					Setup.inicializar();
				} else if (resposta == JOptionPane.NO_OPTION) {
					JOptionPane.showMessageDialog(null, "Você cancelou a ação.", "Cancelamento",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Ação não concluída.", "Aviso",
							JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});
		bnt_dropdata.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		panel.add(bnt_dropdata);

		JLabel lbl_principal = new JLabel("Selecione a opção desejada!.");
		lbl_principal.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lbl_principal.setBounds(224, 114, 248, 26);
		contentPane.add(lbl_principal);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(178, 314, 376, 116);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 3, 5));

		JButton bnt_login = new JButton("Login");
		bnt_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLogin telalogin = new TelaLogin();
				telalogin.setVisible(true);
				dispose();
			}
		});
		bnt_login.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		panel_1.add(bnt_login);

		JButton bnt_sair = new JButton("Sair");
		bnt_sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		bnt_sair.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		panel_1.add(bnt_sair);

	}
}
