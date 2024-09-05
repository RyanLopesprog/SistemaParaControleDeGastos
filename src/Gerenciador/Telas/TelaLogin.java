package Gerenciador.Telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Gerenciador.Conexao;
import Gerenciador.Planilhas.Usuario;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaLogin extends JFrame {
	static Conexao con = new Conexao("jdbc:mysql://localhost:3306/controlefinanceiro", "root", "Aluno");

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin telalogin = new TelaLogin();
					telalogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaLogin() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_gestor_incio = new JLabel("Bem vindo a Gestão Financeira");
		lbl_gestor_incio.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lbl_gestor_incio.setBounds(88, 11, 269, 14);
		contentPane.add(lbl_gestor_incio);
		
		JLabel lbl_inicio_login = new JLabel("Usuario/Apelido:");
		lbl_inicio_login.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		lbl_inicio_login.setBounds(25, 96, 132, 14);
		contentPane.add(lbl_inicio_login);
		
		textField = new JTextField();
		textField.setBounds(25, 124, 132, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lbl_senha_inicio = new JLabel("Senha:");
		lbl_senha_inicio.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		lbl_senha_inicio.setBounds(25, 165, 63, 14);
		contentPane.add(lbl_senha_inicio);
		
		textField_1 = new JTextField();
		textField_1.setBounds(25, 190, 132, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btn_login_inicio = new JButton("Login");
		btn_login_inicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				TelaPrincipal telaPrincipal = new TelaPrincipal();
				telaPrincipal.setVisible(true);
						
				dispose();
			}
		});
		btn_login_inicio.setFont(new Font("Times New Roman", Font.ITALIC, 22));
		btn_login_inicio.setBounds(265, 114, 112, 35);
		contentPane.add(btn_login_inicio);
		
		JButton btn_cadastro_inicio = new JButton("Cadastro");
		btn_cadastro_inicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastro telacadastro = new TelaCadastro();
				telacadastro.setVisible(true);
				dispose();
			}
		});
		btn_cadastro_inicio.setFont(new Font("Times New Roman", Font.ITALIC, 22));
		btn_cadastro_inicio.setBounds(241, 180, 169, 35);
		contentPane.add(btn_cadastro_inicio);
	}

}
