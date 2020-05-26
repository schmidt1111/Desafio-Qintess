package com.qintess.ingressosonline.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.ingressosonline.entity.CasaShow;
import com.qintess.ingressosonline.exception.IngressoException;
import com.qintess.ingressosonline.repository.CasaShowRepository;

@Service
public class CasaShowService {
	
	@Autowired
	private CasaShowRepository repository;
	
	public CasaShowService(CasaShowRepository repository) {
		this.repository = repository;
	}
	public CasaShow salvar(CasaShow casashow) {
		return repository.save(casashow);
	}
	public List<CasaShow> buscarTodos() {
		return repository.findAll();
	}
	public CasaShow delete(CasaShow casaShow) {
		repository.delete(casaShow);
		return casaShow;
	}
	public Object buscarPorId (Long id) {
		return repository.findById(id);
	}
	public void deleteId(Long id) {
		repository.deleteById(id);
	}
	public CasaShow atualizar(CasaShow casaShow, Long id) {
		CasaShow atualizar = repository.findById(id).orElseThrow(() -> new IngressoException("Usuario não localizado."));
		atualizar.setNome(casaShow.getNome());
		atualizar.setEndereco(casaShow.getEndereco());
		atualizar.setTelefone(casaShow.getTelefone());
		atualizar.setCep(casaShow.getCep());
		atualizar.setCidade(casaShow.getCidade());
		atualizar.setEstado(casaShow.getEstado());
		
		return repository.save(atualizar);
	}	
}

	
	