package com.qintess.ingressosonline.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.ingressosonline.entity.Compra;
import com.qintess.ingressosonline.exception.IngressoException;
import com.qintess.ingressosonline.repository.CompraRepository;

@Service
public class CompraService {
	
	@Autowired
	private CompraRepository compraRepository;
	private double valorTotal;
	
	public CompraService(CompraRepository compraRepository) {
		this.compraRepository = compraRepository;
	}
	public Compra salvar(Compra compra) {
		compra.setValorTotal(setValorTotal(compra.getValorUnit(), compra.getQtd()));
		return compraRepository.save(compra);
	}
	public List<Compra> buscarTodos() {
		return compraRepository.findAll();
	}
	public Compra delete(Compra compra) {
		compraRepository.delete(compra);
		return compra;
	}
	public Object buscarPorId (Long id) {
		return compraRepository.findById(id);
	}
	public void deleteId(Long id) {
		compraRepository.deleteById(id);
	}
	
	public Compra atualizar(Compra compra, Long id) {
		Compra atualizar = compraRepository.findById(id).orElseThrow(() -> new IngressoException("Usuario não localizado."));
		atualizar.setEvento(compra.getEvento());
		atualizar.setDate(compra.getDate());
		atualizar.setQtd(compra.getQtd());
		atualizar.setUsuario(compra.getUsuario());
		atualizar.setValorTotal(compra.getValorTotal());
		atualizar.setValorUnit(compra.getValorUnit());
		
		return compraRepository.save(atualizar);
	}
	public Double setValorTotal(double valorUnitario, Integer qtd) {
	return valorTotal = valorUnitario * qtd;
	}
	public String analisarCompra(Compra compra) {
		if (compra.getQtd()<=4) {
			salvar(compra);
			return "Compra efetuada com sucesso!";
		}else {
				return "Não é possivel comprar mais de 4 ingressos";
			
		}
	}
	
}