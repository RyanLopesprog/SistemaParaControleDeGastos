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

import Gerenciador.Planilhas.Despesa;
import Gerenciador.Planilhas.Usuario;

import java.awt.GridBagLayout;
import java.awt.GridLayout;

public class TelaDespesas extends JFrame {
	static Gerenciador.Conexao con = new Gerenciador.Conexao("jdbc:mysql://localhost:3306/controlefinanceiro", "root",
			"Aluno");

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_nome_despesas;
	private JTextField txt_data_despesas;
	private JTextField txt_valor_despesas;
	private JTable table_despesa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDespesas despesas = new TelaDespesas(null);
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
	public TelaDespesas(Usuario dadosrebidos) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 926, 550);
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


		
		table_despesa = new JTable();
		Object[] listaColunas = { "ID Despesa", "Nome", "Data", "Despesa", "Valor" };
		DefaultTableModel modelo = new DefaultTableModel(new Object[][] {}, listaColunas);

		java.util.List<Despesa> despesas = con.buscarTodasDespesas();
		for (Despesa d : despesas) {
			Object[] infoDespesa = { d.getId_despesa(), d.getId_usuario(), d.getData_despesa(), d.getNome_despesa(),
					d.getValor_despesa() };

			modelo.addRow(infoDespesa);
		}
		table_despesa.setModel(modelo);
		table_despesa.setDefaultEditor(Object.class, null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(383, 76, 512, 424);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(table_despesa);

		JComboBox comboBox_meses_despesas = new JComboBox();
		comboBox_meses_despesas.setModel(new DefaultComboBoxModel(new String[] { "JANEIRO", "FEVEREIRO", "MARÇO",
				"ABRIL", "MAIO", "JUNHO", "JULHO", "AGOSTO", "SETEMBRO", "OUTUBRO", "NOVEMBRO ", "DEZEMBO" }));
		comboBox_meses_despesas.setToolTipText("");
		comboBox_meses_despesas.setMaximumRowCount(12);
		comboBox_meses_despesas.setBounds(31, 259, 111, 27);
		contentPane.add(comboBox_meses_despesas);

		JLabel lbl_mes_ano_despesas = new JLabel("Selecione o Mês/Ano Desejado");
		lbl_mes_ano_despesas.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lbl_mes_ano_despesas.setBounds(31, 225, 210, 23);
		contentPane.add(lbl_mes_ano_despesas);

		JComboBox comboBox_anos_despesas = new JComboBox();
		comboBox_anos_despesas.setModel(new DefaultComboBoxModel(new String[] { "2024", "2025", "2026", "2027", "2028",
				"2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040" }));
		comboBox_anos_despesas.setSelectedIndex(0);
		comboBox_anos_despesas.setToolTipText("");
		comboBox_anos_despesas.setMaximumRowCount(12);
		comboBox_anos_despesas.setBounds(152, 259, 92, 27);
		contentPane.add(comboBox_anos_despesas);

		JButton btn_buscar_despesas = new JButton("Buscar");
		btn_buscar_despesas.setBounds(69, 297, 122, 19);
		contentPane.add(btn_buscar_despesas);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 340, 320, 136);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(2, 2, 0, 0));
		
		JButton bnt_adicionar = new JButton("Adicionar");
		bnt_adicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Despesa despesa = new Despesa(0, 1, txt_nome_despesas.getText(), txt_data_despesas.getText(),
						txt_valor_despesas.getText());
				con.inserirNovaDespesa(despesa);

				Object[] listaColunas = { "ID Despesa", "Nome", "Data", "Despesa", "Valor" };
				DefaultTableModel modelo = new DefaultTableModel(new Object[][] {}, listaColunas);

				java.util.List<Despesa> despesas = con.buscarTodasDespesas();
				for (Despesa d : despesas) {
					Object[] infoDespesa = { d.getId_despesa(), d.getId_usuario(), d.getNome_despesa(),
							d.getData_despesa(), d.getValor_despesa() };

					modelo.addRow(infoDespesa);
				}
				table_despesa.setModel(modelo);

			}
			
		});
		panel.add(bnt_adicionar);
		
		JButton btnNewButton_2 = new JButton("New button");
		panel.add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("New button");
		panel.add(btnNewButton);
		
		JButton btnNewButton_3 = new JButton("New button");
		panel.add(btnNewButton_3);

	}
}
