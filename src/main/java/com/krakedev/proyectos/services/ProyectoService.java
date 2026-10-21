package com.krakedev.proyectos.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.krakedev.proyectos.entidades.Proyecto;
import com.krakedev.proyectos.repositories.ProyectoRepository;

@Service
public class ProyectoService {
	private final ProyectoRepository proyectoRepository;

	public ProyectoService(ProyectoRepository proyectoRepository) {
		super();
		this.proyectoRepository = proyectoRepository;
	}

	public Proyecto crear(Proyecto proyecto) {
		return proyectoRepository.save(proyecto);
	}

	public List<Proyecto> listar() {
		return proyectoRepository.findAll();
	}

	public Proyecto buscarPorId(int id) {
		return proyectoRepository.findById(id).orElse(null);
	}

	public Proyecto actualizar(Proyecto proyecto) {
		return proyectoRepository.save(proyecto);
	}

	public boolean eliminar(int id) {
		if (proyectoRepository.existsById(id)) {
			proyectoRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
