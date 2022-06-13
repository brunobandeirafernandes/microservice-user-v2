package com.dev.user.resources;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dev.user.repositories.userRepository;
import com.dev.user.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResources {
	
	@Autowired
	private userRepository repository;
	
	//Salvar um usuário no sistema
	@PostMapping(value ="/add")
	public User saveUser(@RequestBody User user) {
		return repository.save(user);
	}
	
	//Editar um usuário no sistema
	@PutMapping(value ="/edit/{id}")
	public void editUser(@PathVariable("id") Long id, @RequestBody User user) throws Exception {
		var u = repository.findById(id);
		if(u.isPresent()) {
			var uSave = u.get();
			uSave.setNome(user.getNome());
			uSave.setCpf(user.getCpf());
			uSave.setEmail(user.getEmail());
			uSave.setFoto(user.getFoto());
			uSave.setNascimento(user.getNascimento());
			
			//return repository.save(uSave);
		}else {
			throw new Exception("Pessoa não encontrada"); 
		}
		
	}
		
	
	//Lista todos os usuários do sistema
	@GetMapping
	public List<User> getAllUsers(){
		return repository.findAll();
	}
	/*@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = repository.findAll();
		return ResponseEntity.ok(list);
	}*/
	

	//Retorna apenas o usuário por id
	@GetMapping(value = "/{id}")
	public User getUserById(@PathVariable Long id) {
		return repository.findById(id).get();
	}
	/*public ResponseEntity<User> findById(@PathVariable Long id) {
		User obj = repository.findById(id).get();
		return ResponseEntity.ok(obj);
	}*/
	
	
	/*//Retorna apenas o usuário por cpf - String completa
	@GetMapping(value = "/busca")
	public ResponseEntity<User> findByCpf(@RequestParam String cpf) {
		User obj = repository.findByCpf(cpf);
		return ResponseEntity.ok(obj);
	}
	
	//Retorna apenas o usuário por email
	@GetMapping(value = "/busca")
	public ResponseEntity<User> findByEmail(@RequestParam String email) {
		User obj = repository.findByEmail(email);
		return ResponseEntity.ok(obj);
	}
	
	//Retorna apenas o usuário por nome
	@GetMapping(value = "/busca")
	public ResponseEntity<User> findByNome(@RequestParam String nome) {
		User obj = repository.findByNome(nome);
		return ResponseEntity.ok(obj);
	}*/
	
	
	@DeleteMapping(value = "/user/{id}")
	public void deleteUsuario(@PathVariable Long id){
		repository.deleteById(id);
    }
	

}
