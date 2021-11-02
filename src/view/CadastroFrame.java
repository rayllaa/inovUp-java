package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.CarroController;
import model.vo.Carro;

public class CadastroFrame extends JFrame{
	private CarroController controller;

	private JLabel tituloL, placaL, renavamL, modeloL, fabricanteL, anoFabricacaoL, anoModeloL;
	private JTextField placaTF, renavamTF, modeloTF, fabricanteTF, anoFabricacaoTF, anoModeloTF;
	private JButton limparB, cadastrarB;
	
	public JPanel painelCadastro() {

		controller = new CarroController();

		JPanel painelCadastro = new JPanel();
		painelCadastro.setBackground(Color.white);
		painelCadastro.setSize(600, 450);
		painelCadastro.setLayout(null);

		tituloL = new JLabel("Cadastro de Carro");
		tituloL.setBounds(190, 40, 400, 50);
		tituloL.setFont(new Font("Dialog", Font.PLAIN, 28));
		painelCadastro.add(tituloL);

		placaL = new JLabel("Placa:");
		placaL.setBounds(20, 130, 50, 20);
		placaL.setFont(new Font("Tahoma", Font.PLAIN, 15));

		placaTF = new JTextField();
		placaTF.setBounds(70, 131, 200, 20);
		placaTF.setBackground(Color.white);
		
		renavamL = new JLabel("RENAVAM:");
		renavamL.setBounds(20, 160, 80, 20);
		renavamL.setFont(new Font("Tahoma", Font.PLAIN, 15));

		renavamTF = new JTextField();
		renavamTF.setBounds(100, 160, 150, 20);
		renavamTF.setBackground(Color.white);

		modeloL = new JLabel("Modelo:");
		modeloL.setBounds(20, 190, 120, 20);
		modeloL.setFont(new Font("Tahoma", Font.PLAIN, 15));

		modeloTF = new JTextField();
		modeloTF.setBounds(80, 190, 140, 20);
		modeloTF.setBackground(Color.white);

		fabricanteL = new JLabel("Fabricante:");
		fabricanteL.setBounds(20, 220, 130, 20);
		fabricanteL.setFont(new Font("Tahoma", Font.PLAIN, 15));

		fabricanteTF = new JTextField();
		fabricanteTF.setBounds(100, 220, 200, 20);
		fabricanteTF.setBackground(Color.white);

		anoFabricacaoL = new JLabel("Ano Fabricação:");
		anoFabricacaoL.setBounds(20, 250, 130, 20);
		anoFabricacaoL.setFont(new Font("Tahoma", Font.PLAIN, 15));

		anoFabricacaoTF = new JTextField();
		anoFabricacaoTF.setBounds(135, 250, 100, 20);
		anoFabricacaoTF.setBackground(Color.white);
		
		anoModeloL = new JLabel("Ano Modelo:");
		anoModeloL.setBounds(20, 280, 100, 20);
		anoModeloL.setFont(new Font("Tahoma", Font.PLAIN, 15));

		anoModeloTF = new JTextField();
		anoModeloTF.setBounds(110, 280, 100, 20);
		anoModeloTF.setBackground(Color.white);

		limparB = new JButton("Limpar");
		limparB.setBounds(360, 340, 80, 25);
		limparB.setBackground(new Color(237, 249, 252));
		limparB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});

		cadastrarB = new JButton("Cadastrar");
		cadastrarB.setBounds(450, 340, 100, 25);
		cadastrarB.setBackground(new Color(237, 249, 252));
		cadastrarB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (cadastrarCarro() > 0)
					JOptionPane.showMessageDialog(null, String.format("Carro cadastrado com sucesso!"));
				else
					JOptionPane.showMessageDialog(null, String.format("Ocorreu um erro durante o cadastro!"));
			}
		});

		painelCadastro.add(placaL);
		painelCadastro.add(placaTF);
		painelCadastro.add(renavamL);
		painelCadastro.add(renavamTF);
		painelCadastro.add(modeloL);
		painelCadastro.add(modeloTF);
		painelCadastro.add(fabricanteL);
		painelCadastro.add(fabricanteTF);
		painelCadastro.add(anoFabricacaoL);
		painelCadastro.add(anoFabricacaoTF);
		painelCadastro.add(anoModeloL);
		painelCadastro.add(anoModeloTF);
		painelCadastro.add(limparB);
		painelCadastro.add(cadastrarB);

		return painelCadastro;
	}
	
	public void limpar() {

		placaTF.setText("");
		renavamTF.setText("");
		modeloTF.setText("");
		fabricanteTF.setText("");
		anoFabricacaoTF.setText("");
		anoModeloTF.setText("");
		
		placaTF.requestFocus();
	}
	
	public int cadastrarCarro() {

		Carro c = new Carro();

		c.setPlaca(placaTF.getText());
		c.setModelo(modeloTF.getText());
		c.setRenavam(renavamTF.getText());
		c.setFabricante(fabricanteTF.getText());
		c.setAno_fabricacao(anoFabricacaoTF.getText());
		c.setAno_modelo(anoModeloTF.getText());

		return controller.cadastrarCarro(c);
	}
}
