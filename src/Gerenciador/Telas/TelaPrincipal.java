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
		lbl_bemvindo_principal.setBounds(256, 10, 222, 26);
		lbl_bemvindo_principal.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		contentPane.add(lbl_bemvindo_principal);
		
		JPanel panel = new JPanel();
		panel.setBounds(58, 96, 204, 130);
		contentPane.add(panel);
	}
}
