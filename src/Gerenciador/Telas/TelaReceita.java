package Gerenciador.Telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class TelaReceita extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_nome_receita;
	private JTextField txt_data_receita;
	private JTextField txt_valor_receita;
	private JTextField txt_tipo_receita;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaReceita receita = new TelaReceita();
					receita.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaReceita() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_gestao_receita = new JLabel("Gestão Financeira: Receita.");
		lbl_gestao_receita.setBounds(266, 10, 261, 27);
		lbl_gestao_receita.setFont(new Font("Times New Roman", Font.ITALIC, 22));
		contentPane.add(lbl_gestao_receita);
		
		JLabel lbl_nome_receita = new JLabel("Nome:");
		lbl_nome_receita.setBounds(31, 132, 59, 27);
		lbl_nome_receita.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		contentPane.add(lbl_nome_receita);
		
		txt_nome_receita = new JTextField();
		txt_nome_receita.setBounds(104, 138, 108, 19);
		contentPane.add(txt_nome_receita);
		txt_nome_receita.setColumns(10);
		
		JLabel lbl_data_receita = new JLabel("Data:");
		lbl_data_receita.setBounds(31, 180, 59, 19);
		lbl_data_receita.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		contentPane.add(lbl_data_receita);
		
		txt_data_receita = new JTextField();
		txt_data_receita.setBounds(104, 182, 108, 19);
		contentPane.add(txt_data_receita);
		txt_data_receita.setColumns(10);
		
		JLabel lbl_valor_receita = new JLabel("Valor: ");
		lbl_valor_receita.setBounds(31, 226, 59, 13);
		lbl_valor_receita.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		contentPane.add(lbl_valor_receita);
		
		txt_valor_receita = new JTextField();
		txt_valor_receita.setBounds(104, 225, 108, 19);
		contentPane.add(txt_valor_receita);
		txt_valor_receita.setColumns(10);
		
		JLabel lbl_tipo_receita = new JLabel("Tipo: ");
		lbl_tipo_receita.setBounds(31, 268, 59, 18);
		lbl_tipo_receita.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		contentPane.add(lbl_tipo_receita);
		
		txt_tipo_receita = new JTextField();
		txt_tipo_receita.setBounds(104, 267, 108, 19);
		contentPane.add(txt_tipo_receita);
		txt_tipo_receita.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(31, 327, 300, 120);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btn_add = new JButton("Adicionar");
		btn_add.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btn_add.setBounds(10, 10, 124, 45);
		panel.add(btn_add);
		
		JButton btn_despesas = new JButton("Despesas");
		btn_despesas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							TelaDespesas despesas = new TelaDespesas();
							despesas.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				dispose();
			}
		});
		btn_despesas.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btn_despesas.setBounds(166, 10, 124, 45);
		panel.add(btn_despesas);
		
		JButton btn_inicio = new JButton("Inicio");
		btn_inicio.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btn_inicio.setBounds(10, 65, 124, 45);
		panel.add(btn_inicio);
		
		JButton btn_sair = new JButton("Sair");
		btn_sair.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btn_sair.setBounds(166, 65, 124, 45);
		panel.add(btn_sair);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(426, 76, 348, 424);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id_receita", "id_usuario", "data_receita", "nome_receita", "valor_receita"
			}
		));
		scrollPane.setViewportView(table);
	}
}
