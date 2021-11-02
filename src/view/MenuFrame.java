package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MenuFrame extends JFrame{
	private JPanel painel;	

	public MenuFrame() {
		setTitle("InovUP");
		setBounds(370, 100, 600, 450);// (x, y, w, h)
		getContentPane().setBackground(Color.white);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);

		painel = new JPanel(); // painel inicial
		painel.setBackground(Color.white);
		painel.setSize(600, 450); // painel assume toda a altura e largura da janela
		painel.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		
		JMenuItem home = new JMenuItem("Início") {
			public Dimension getMaximumSize() {
				Dimension d1 = super.getPreferredSize();
				Dimension d2 = super.getMaximumSize();
				d2.width = d1.width;
				return d2;
			}
		};
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//setPanel(panelHome());
			}
		});
		
		JMenu carros = new JMenu("Carros") {
			public Dimension getMaximumSize() {
				Dimension d1 = super.getPreferredSize();
				Dimension d2 = super.getMaximumSize();
				d2.width = d1.width;
				return d2;
			}
		};

		JMenuItem listar = new JMenuItem("Listar");
		carros.add(listar);
		listar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VisualizacaoFrame visualizacao = new VisualizacaoFrame();
				setPanel(visualizacao.painelLista());
			}
		});

		carros.addSeparator();

		JMenuItem cadastrar = new JMenuItem("Cadastrar");
		carros.add(cadastrar);
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroFrame cadastro = new CadastroFrame();
				setPanel(cadastro.painelCadastro());
			}
		});
		
		JMenuItem sair = new JMenuItem("Sair") {
			public Dimension getMaximumSize() {
				Dimension d1 = super.getPreferredSize();
				Dimension d2 = super.getMaximumSize();
				d2.width = d1.width;
				return d2;
			}
		};
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		menuBar.add(home);
		menuBar.add(carros);
		menuBar.add(sair);

		setJMenuBar(menuBar);
		
		setContentPane(painel);
		setVisible(true);
	}

	private void setPanel(JPanel painel) { 
		this.setContentPane(painel);
		this.validate(); 
	}
}