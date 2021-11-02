package controller;

import java.util.ArrayList;

import model.dao.CarroDAO;
import model.vo.Carro;

public class CarroController {
	CarroDAO dao = new CarroDAO();
	
	public int cadastrarCarro(Carro c) {
		return dao.createCarro(c);
	}
	
	public ArrayList<Carro> listaCarros() {
		return dao.readCarros();
	}
	
	public int atualizarCarro(Carro c) {
		return dao.updateCarro(c);
	}
}
