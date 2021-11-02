package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;

import controller.CarroController;
import model.vo.Carro;

public class VisualizacaoFrame extends JFrame{

	private CarroController controller;
	private ArrayList<Carro> carros;

	private JLabel tituloListaL;
	private JButton atualizarB;
	
	private int length = 8;
	private String linhas [][] = new String[length][5];
	private String[] colunas = new String[] {"Id","Placa", "Modelo", "Fabricante", "Ano Fabricação"};
		
	public JPanel painelLista() {

		controller = new CarroController();

		JPanel painelListaCarros = new JPanel();
		painelListaCarros.setBackground(Color.white);
		painelListaCarros.setSize(600, 450);
		painelListaCarros.setLayout(null);
		setResizable(false);
		painelListaCarros.setVisible(true);

		tituloListaL = new JLabel("Carros Cadastrados");
		tituloListaL.setBounds(190, 40, 400, 50);
		tituloListaL.setFont(new Font("Dialog", Font.PLAIN, 20));
		painelListaCarros.add(tituloListaL);

		this.listaCarros();

		JTable tabela = new JTable(linhas, colunas); // cria tabela
		tabela.setVisible(true);

		tabela.setEnabled(true);// desabilita células da tabela
		tabela.setBorder(new LineBorder(Color.lightGray)); // borda externa
		tabela.setGridColor(Color.lightGray); // borda das células
		tabela.setShowGrid(true);// exibe grade tabela

		DefaultTableCellRenderer center = new DefaultTableCellRenderer();
		center.setHorizontalAlignment(SwingConstants.CENTER);
		// centraliza conteudo da célula
		tabela.getColumnModel().getColumn(0).setCellRenderer(center);
		tabela.getColumnModel().getColumn(1).setCellRenderer(center);
		tabela.getColumnModel().getColumn(2).setCellRenderer(center);
		tabela.getColumnModel().getColumn(3).setCellRenderer(center);
		tabela.getColumnModel().getColumn(4).setCellRenderer(center);

		// define largura das colunas
		tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(20);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(20);
		tabela.getColumnModel().getColumn(3).setPreferredWidth(50);
		tabela.getColumnModel().getColumn(4).setPreferredWidth(100);

		// define se as colunas são redimensionáveis
		tabela.getColumnModel().getColumn(0).setResizable(true);
		tabela.getColumnModel().getColumn(1).setResizable(true);
		tabela.getColumnModel().getColumn(2).setResizable(true);
		tabela.getColumnModel().getColumn(3).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(4).setResizable(true);

		tabela.setRowHeight(25); // define altura das linhas

		JScrollPane scroll = new JScrollPane(tabela);
		scroll.setBounds(20, 120, 550, 200);

		atualizarB = new JButton("Atualizar");
		atualizarB.setBounds(480, 350, 86, 25);
		atualizarB.setBackground(new Color(237, 249, 252));
		atualizarB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//String carro = String.valueOf(tabela.getValueAt(tabela.getSelectedRow(), tabela.getSelectedColumn()));
				//System.out.println(tabela.getSelectedRow()+tabela.getValueAt(tabela.getSelectedRow(), 1).toString());
				
				Carro c = new Carro();
				
				int linha = tabela.getSelectedRow();
				
				c.setId(Integer.parseInt(tabela.getValueAt(linha, 0).toString()));
				c.setPlaca(tabela.getValueAt(linha, 1).toString());
				c.setModelo(tabela.getValueAt(linha, 2).toString());
				c.setFabricante(tabela.getValueAt(linha, 3).toString());
				//c.setAno_fabricacao(tabela.getValueAt(linha, 3).toString());
				
				if(atualizarCarro(c) > 0)
					JOptionPane.showMessageDialog(null, String.format("Carro atualizado com sucesso!"));
				else
					JOptionPane.showMessageDialog(null, String.format("Ocorreu um erro durante a atualização!"));
			}
		});

		painelListaCarros.add(scroll);
		painelListaCarros.add(atualizarB);

		return painelListaCarros;
	}
	
	public void listaCarros() {
		
		carros = controller.listaCarros();

		for (int i = 0; i < carros.size(); i++) {
			if (i >= length)
				length++;

			linhas[i][0] = String.valueOf(carros.get(i).getId());
			linhas[i][1] = String.valueOf(carros.get(i).getPlaca());
			linhas[i][2] = String.valueOf(carros.get(i).getModelo());
			linhas[i][3] = String.valueOf(carros.get(i).getFabricante());
			linhas[i][4] = String.valueOf(carros.get(i).getAno_fabricacao());
		}
	}

	public int atualizarCarro(Carro c) {
		
		return controller.atualizarCarro(c);
	}
}