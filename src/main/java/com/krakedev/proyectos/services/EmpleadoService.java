package com.krakedev.proyectos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.krakedev.proyectos.entidades.Empleado;
import com.krakedev.proyectos.repositories.EmpleadoRepository;

@Service
public class EmpleadoService {
	private final EmpleadoRepository empleadoRepository;

	public EmpleadoService(EmpleadoRepository empleadoRepository) {
		super();
		this.empleadoRepository = empleadoRepository;
	}

	public Empleado crear(Empleado empleado) {
		return empleadoRepository.save(empleado);
	}

	public List<Empleado> listar() {
		return empleadoRepository.findAll();
	}

	public Empleado buscarPorId(int id) {
		return empleadoRepository.findById(id).orElse(null);
	}

	public Empleado actualizar(Empleado empleado) {
		return empleadoRepository.save(empleado);
	}

	public boolean eliminar(int id) {
		if (empleadoRepository.existsById(id)) {
			empleadoRepository.deleteById(id);
			return true;
		}
		return false;
	}
}