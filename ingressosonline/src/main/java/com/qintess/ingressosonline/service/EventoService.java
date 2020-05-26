package com.qintess.ingressosonline.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.ingressosonline.entity.Evento;
import com.qintess.ingressosonline.exception.IngressoException;
import com.qintess.ingressosonline.repository.EventoRepository;

@Service
public class EventoService {
	
	@Autowired
	private EventoRepository eventoRepository;
	
	public EventoService(EventoRepository eventoRepository) {
		this.eventoRepository = eventoRepository;
	}
	public Evento salvar(Evento evento) {
		return eventoRepository.save(evento);
	}
	public List<Evento> buscarTodos() {
		return eventoRepository.findAll();
	}
	public Evento delete(Evento evento) {
		eventoRepository.delete(evento);
		return evento;
	}
	public Object buscarPorId (Long id) {
		return eventoRepository.findById(id);
	}
	public void deleteId(Long id) {
		eventoRepository.deleteById(id);
	}
	/*public void setIngressoTotal(Compra compra, Integer qtd, Integer ingressoTotal) {
		if (qtd <= 4) {
		this.setIngressoTotal(compra, qtd, ingressoTotal);
		ingressoTotal = ingressoTotal - qtd;
		} else {
			System.out.println("Cada usuário pode comprar até 4 ingressos");
		}
	}*/
	public Evento atualizar(Evento evento, Long id) {
		Evento atualizar = eventoRepository.findById(id).orElseThrow(() -> new IngressoException("Usuario não localizado."));
		atualizar.setNome(evento.getNome());
		atualizar.setData(evento.getData());
		atualizar.setDescricao(evento.getDescricao());
		atualizar.setIngressoTotal(evento.getIngressoTotal());
		atualizar.setCasaShow(evento.getCasaShow());
		atualizar.setIngressoTotal(evento.getIngressoTotal());
		return eventoRepository.save(atualizar);
	}
}
