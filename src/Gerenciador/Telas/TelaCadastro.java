package Gerenciador.Telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_nome_cadastro;
	private JTextField txt_cpf_cadastro;
	private JTextField txt_senha_cadastro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro telacadastro = new TelaCadastro();
					telacadastro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCadastro() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 389, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_cadastro = new JLabel("Cadastro ");
		lbl_cadastro.setBounds(152, 11, 87, 24);
		lbl_cadastro.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		contentPane.add(lbl_cadastro);
		
		JLabel lbl_nome_cadastro = new JLabel("Nome/Apelido:");
		lbl_nome_cadastro.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		lbl_nome_cadastro.setBounds(21, 69, 130, 24);
		contentPane.add(lbl_nome_cadastro);
		
		txt_nome_cadastro = new JTextField();
		txt_nome_cadastro.setBounds(21, 104, 130, 20);
		contentPane.add(txt_nome_cadastro);
		txt_nome_cadastro.setColumns(10);
		
		JLabel lbl_cpf_cadastro = new JLabel("C.P.F:");
		lbl_cpf_cadastro.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		lbl_cpf_cadastro.setBounds(21, 135, 73, 14);
		contentPane.add(lbl_cpf_cadastro);
		
		txt_cpf_cadastro = new JTextField();
		txt_cpf_cadastro.setBounds(21, 160, 130, 20);
		contentPane.add(txt_cpf_cadastro);
		txt_cpf_cadastro.setColumns(10);
		
		JLabel lbl_senha_cadastro = new JLabel("Senha:");
		lbl_senha_cadastro.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		lbl_senha_cadastro.setBounds(21, 197, 73, 14);
		contentPane.add(lbl_senha_cadastro);
		
		txt_senha_cadastro = new JTextField();
		txt_senha_cadastro.setBounds(21, 222, 130, 20);
		contentPane.add(txt_senha_cadastro);
		txt_senha_cadastro.setColumns(10);
		
		JButton btn_cadastro = new JButton("Cadastrar");
		btn_cadastro.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		btn_cadastro.setBounds(223, 73, 120, 38);
		contentPane.add(btn_cadastro);
		
		JButton btn_inicio_cadastro = new JButton("Inicio");
		btn_inicio_cadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								TelaInicio inicio = new TelaInicio();
								inicio.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					
					});
					dispose();
			}
		});
		btn_inicio_cadastro.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		btn_inicio_cadastro.setBounds(223, 142, 106, 38);
		contentPane.add(btn_inicio_cadastro);
		
		JButton btn_sair_cadastro = new JButton("Sair");
		btn_sair_cadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		btn_sair_cadastro.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		btn_sair_cadastro.setBounds(223, 213, 106, 33);
		contentPane.add(btn_sair_cadastro);
	}
}