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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class TelaDespesas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_nome_despesas;
	private JTextField txt_data_despesas;
	private JTextField txt_valor_despesas;
	private JTextField txt_tipo_despesas;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	}

	/**
	 * Create the frame.
	 */
	public TelaDespesas() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_gestao_receita = new JLabel("Gestão Financeira: Despesas.");
		lbl_gestao_receita.setFont(new Font("Times New Roman", Font.ITALIC, 22));
		lbl_gestao_receita.setBounds(242, 10, 287, 27);
		contentPane.add(lbl_gestao_receita);
		
		JLabel lbl_nome_despesas = new JLabel("Nome:");
		lbl_nome_despesas.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lbl_nome_despesas.setBounds(10, 60, 59, 27);
		contentPane.add(lbl_nome_despesas);
		
		txt_nome_despesas = new JTextField();
		txt_nome_despesas.setBounds(83, 66, 108, 19);
		contentPane.add(txt_nome_despesas);
		txt_nome_despesas.setColumns(10);
		
		JLabel lbl_data_despesas = new JLabel("Data:");
		lbl_data_despesas.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lbl_data_despesas.setBounds(10, 108, 59, 19);
		contentPane.add(lbl_data_despesas);
		
		txt_data_despesas = new JTextField();
		txt_data_despesas.setBounds(83, 110, 108, 19);
		contentPane.add(txt_data_despesas);
		txt_data_despesas.setColumns(10);
		
		JLabel lbl_valor_despesas = new JLabel("Valor: ");
		lbl_valor_despesas.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lbl_valor_despesas.setBounds(10, 154, 59, 13);
		contentPane.add(lbl_valor_despesas);
		
		txt_valor_despesas = new JTextField();
		txt_valor_despesas.setBounds(83, 153, 108, 19);
		contentPane.add(txt_valor_despesas);
		txt_valor_despesas.setColumns(10);
		
		JLabel lbl_tipo_despesas = new JLabel("Tipo: ");
		lbl_tipo_despesas.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lbl_tipo_despesas.setBounds(10, 196, 59, 18);
		contentPane.add(lbl_tipo_despesas);
		
		txt_tipo_despesas = new JTextField();
		txt_tipo_despesas.setBounds(83, 195, 108, 19);
		contentPane.add(txt_tipo_despesas);
		txt_tipo_despesas.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 339, 269, 136);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btn_add = new JButton("Adicionar");
		btn_add.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btn_add.setBounds(10, 10, 124, 45);
		panel.add(btn_add);
		
		JButton btn_receitas = new JButton("Receitas");
		btn_receitas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
				dispose();
			}
		});
		btn_receitas.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btn_receitas.setBounds(10, 65, 124, 45);
		panel.add(btn_receitas);
		
		JButton btn_inicio = new JButton("Inicio");
		btn_inicio.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btn_inicio.setBounds(135, 65, 124, 45);
		panel.add(btn_inicio);
		
		JButton btn_sair = new JButton("Sair");
		btn_sair.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btn_sair.setBounds(135, 11, 124, 45);
		panel.add(btn_sair);
		
		JComboBox comboBox_meses_despesas = new JComboBox();
		comboBox_meses_despesas.setModel(new DefaultComboBoxModel(new String[] {"JANEIRO", "FEVEREIRO", "MARÇO", "ABRIL", "MAIO", "JUNHO", "JULHO", "AGOSTO", "SETEMBRO", "OUTUBRO", "NOVEMBRO ", "DEZEMBO"}));
		comboBox_meses_despesas.setToolTipText("");
		comboBox_meses_despesas.setMaximumRowCount(12);
		comboBox_meses_despesas.setBounds(33, 280, 111, 27);
		contentPane.add(comboBox_meses_despesas);
		
		JLabel lblNewLabel = new JLabel("Selecione o Mês/Ano Desejado");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setBounds(33, 246, 210, 23);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox_anos_despesas = new JComboBox();
		comboBox_anos_despesas.setModel(new DefaultComboBoxModel(new String[] {"2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040"}));
		comboBox_anos_despesas.setSelectedIndex(20);
		comboBox_anos_despesas.setToolTipText("");
		comboBox_anos_despesas.setMaximumRowCount(12);
		comboBox_anos_despesas.setBounds(154, 280, 92, 27);
		contentPane.add(comboBox_anos_despesas);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(358, 60, 416, 440);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id_despesa", "id_usuario", "data_despesa", "nome_despesa", "valor_despesa", "tipo_despesa"
			}
		));
		scrollPane.setViewportView(table);
	}
}
