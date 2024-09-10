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
import javax.swing.table.TableModel;

import Gerenciador.Planilhas.Receita;
import Gerenciador.Planilhas.Usuario;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class TelaReceita extends JFrame {
	static Gerenciador.Conexao con = new Gerenciador.Conexao("jdbc:mysql://localhost:3306/controlefinanceiro", "root", "Aluno");


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_nome_receita;
	private JTextField txt_data_receita;
	private JTextField txt_valor_receita;
	private JTable table_receita;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaReceita receita = new TelaReceita(null);
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
	public TelaReceita(Usuario dadosrecebidos) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 936, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_gestao_receita = new JLabel("Gestão Financeira: Receita.");
		lbl_gestao_receita.setBounds(266, 10, 261, 27);
		lbl_gestao_receita.setFont(new Font("Times New Roman", Font.ITALIC, 22));
		contentPane.add(lbl_gestao_receita);
		
		JLabel lbl_nome_receita = new JLabel("Nome:");
		lbl_nome_receita.setBounds(31, 68, 59, 27);
		lbl_nome_receita.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		contentPane.add(lbl_nome_receita);
		
		txt_nome_receita = new JTextField();
		txt_nome_receita.setBounds(104, 74, 108, 19);
		contentPane.add(txt_nome_receita);
		txt_nome_receita.setColumns(10);
		
		JLabel lbl_data_receita = new JLabel("Data:");
		lbl_data_receita.setBounds(31, 116, 59, 19);
		lbl_data_receita.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		contentPane.add(lbl_data_receita);
		
		txt_data_receita = new JTextField();
		txt_data_receita.setBounds(104, 118, 108, 19);
		contentPane.add(txt_data_receita);
		txt_data_receita.setColumns(10);
		
		JLabel lbl_valor_receita = new JLabel("Valor: ");
		lbl_valor_receita.setBounds(31, 162, 59, 13);
		lbl_valor_receita.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		contentPane.add(lbl_valor_receita);
		
		txt_valor_receita = new JTextField();
		txt_valor_receita.setBounds(104, 161, 108, 19);
		contentPane.add(txt_valor_receita);
		txt_valor_receita.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(31, 344, 269, 120);
		contentPane.add(panel);
		panel.setLayout(null);	

		table_receita = new JTable();
		
		
		Object[] listaColunas = { "ID Receita", "Nome",  "Receita","Data", "Valor"};
		DefaultTableModel modelo = new DefaultTableModel(
		    new Object[][] {
		    },
		    listaColunas
		);

		java.util.List<Receita> receitas = con.buscarTodasReceitas();
		for (Receita r : receitas) {
		    Object[] infoReceita = {
		        r.getId_receita(),
		        r.getId_usuario(),
		        r.getData_receita(),
		        r.getNome_receita(),
		        r.getValor_receita()
		    };

		    modelo.addRow(infoReceita);
		}
		table_receita.setModel(modelo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(383, 76, 512, 424);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(table_receita);
		
		table_receita.setDefaultEditor(Object.class, null);
		
		
		JButton btn_despesas = new JButton("Despesas");
		btn_despesas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaDespesas despesas = new TelaDespesas(dadosrecebidos);
				despesas.setVisible(true);
				dispose();
			}
		});
		
		btn_despesas.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btn_despesas.setBounds(135, 11, 124, 44);
		panel.add(btn_despesas);
		
		JButton btn_inicio = new JButton("Inicio");
		btn_inicio.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btn_inicio.setBounds(10, 65, 124, 45);
		panel.add(btn_inicio);
		
		JButton btn_sair = new JButton("Sair");
		btn_sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);			
				}
		});
		btn_sair.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btn_sair.setBounds(135, 65, 124, 45);
		panel.add(btn_sair);
		
		JButton btn_adicionar = new JButton("Adicionar");
		btn_adicionar.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btn_adicionar.setBounds(10, 11, 124, 45);
		panel.add(btn_adicionar);
		btn_adicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Receita receita = new Receita(0,dadosrecebidos.getId_usuario(), dadosrecebidos.getNome_usuario(), txt_nome_receita.getText(), txt_data_receita.getText(),  txt_valor_receita.getText());
				con.inserirNovaReceita(receita);
				
				Object[] listaColunas = { "ID Receita", "Nome", "Data", "Receita", "Valor"};
				DefaultTableModel modelo = new DefaultTableModel(
				    new Object[][] {
				    },
				    listaColunas
				);

				java.util.List<Receita> receitas = con.buscarTodasReceitas();
				for (Receita r : receitas) {
				    Object[] infoReceita = {
				        r.getId_receita(),
				        r.getNome_usuario(),
				        r.getNome_receita(),
				        r.getData_receita(),
				        r.getValor_receita()
				    };

				    modelo.addRow(infoReceita);
				}
				table_receita.setModel(modelo);
			
			}
		});
		
		JLabel lbl_mes_ano_receita = new JLabel("Selecione o Mês/Ano Desejado");
		lbl_mes_ano_receita.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lbl_mes_ano_receita.setBounds(31, 200, 210, 23);
		contentPane.add(lbl_mes_ano_receita);
		
		JComboBox comboBox_meses_receita = new JComboBox();
		comboBox_meses_receita.setModel(new DefaultComboBoxModel(new String[] {"JANEIRO", "FEVEREIRO", "MARÇO", "ABRIL", "MAIO", "JUNHO", "JULHO", "AGOSTO", "SETEMBRO", "OUTUBRO", "NOVEMBRO ", "DEZEMBO"}));
		comboBox_meses_receita.setToolTipText("");
		comboBox_meses_receita.setMaximumRowCount(12);
		comboBox_meses_receita.setBounds(31, 234, 111, 27);
		contentPane.add(comboBox_meses_receita);
		
		JComboBox comboBox_anos_receita = new JComboBox();
		comboBox_anos_receita.setToolTipText("");
		comboBox_anos_receita.setModel(new DefaultComboBoxModel(new String[] {"2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040"}));
		comboBox_anos_receita.setSelectedIndex(0);
		comboBox_anos_receita.setMaximumRowCount(12);
		comboBox_anos_receita.setBounds(152, 233, 92, 28);
		contentPane.add(comboBox_anos_receita);
		
		JButton btn_buscar_receita = new JButton("Buscar");
		btn_buscar_receita.setBounds(69, 272, 122, 19);
		contentPane.add(btn_buscar_receita);
	}
}

