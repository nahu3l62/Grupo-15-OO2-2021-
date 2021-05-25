package com.unla.nahuel.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.unla.nahuel.entities.Usuario;
import com.unla.nahuel.repositories.IUsuarioRepository;
import com.unla.nahuel.services.IUsuarioService;



@Service("usuarioService")
public class UsuarioService implements IUsuarioService {
	
	@Autowired
	@Qualifier("usuarioRepository")
	private IUsuarioRepository usuarioRepository;
	
	@Override
	public List<Usuario> getAll() {
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario buscar(long id) {
		return usuarioRepository.findById(id).orElse(null);
	}
	
	@Override
	public void save(Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	
	/*@Override
	public boolean remove(Degree degree) {
		try {
			degreeRepository.delete(degree);
			return true;
		}catch (Exception e) {
			return false;
		}
	}*/
	

	@Override
	public void eliminar(long id) {
		usuarioRepository.deleteById(id);
	}







}
