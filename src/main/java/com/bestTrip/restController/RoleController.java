package com.bestTrip.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bestTrip.entities.Role;
import com.bestTrip.services.interfaces.IRoleService;

@RestController
@CrossOrigin
public class RoleController {
	@Autowired
	IRoleService roleService;
	
	@GetMapping("/roles") 
	public List<Role> findAll() {
		return roleService.findAll();
	}

	@GetMapping("/roles/{idR}") 
	public Role findOne(@PathVariable("idR") Long id) {
		return roleService.findOne(id);
	}

	@PostMapping("/roles") 
	public Role saveRole(@RequestBody Role role) {
		return roleService.save(role);
	}

	@DeleteMapping("/roles/{idR}")
	public void deleteRole(@PathVariable("idR") Long id) {
		roleService.delete(id);
	}
	@PutMapping("/roles/{idR}") 
	public Role updateRole(@PathVariable("idR") Long id,@RequestBody Role role) {
		
		Role currentR=roleService.findOne(id);
		
		currentR.setNameRole(role.getNameRole());
		
		return roleService.save(currentR);
	}

}
