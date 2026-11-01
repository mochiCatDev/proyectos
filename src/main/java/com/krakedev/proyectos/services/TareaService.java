package com.krakedev.proyectos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.krakedev.proyectos.entidades.Tarea;
import com.krakedev.proyectos.repositories.TareaRepository;

@Service
public class TareaService {
	private final TareaRepository tareaRepository;

	public TareaService(TareaRepository tareaRepository) {
		super();
		this.tareaRepository = tareaRepository;
	}

	public Tarea crear(Tarea tarea) {
		return tareaRepository.save(tarea);
	}

	public List<Tarea> listar() {
		return tareaRepository.findAll();
	}

	public Tarea buscarPorId(int id) {
		return tareaRepository.findById(id).orElse(null);
	}
	
	public Tarea actualizar(Tarea tarea) {
		return tareaRepository.save(tarea);
	}

	public boolean eliminar(int id) {
		if (tareaRepository.existsById(id)) {
			tareaRepository.deleteById(id);
			return true;
		}
		return false;
	}
}