package br.com.lista.tarefas.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lista.tarefas.domains.Task;
import br.com.lista.tarefas.dto.TaskDTO;
import br.com.lista.tarefas.services.TaskService;

@CrossOrigin("*")
@RestController
@RequestMapping("/task")
public class TaskRestController {

	@Autowired
	private TaskService taskService;
	
	
	@GetMapping
	public List<TaskDTO> listAll() {
		return taskService.list();
	}
	
	@PostMapping
	public TaskDTO save(@RequestBody TaskDTO taskDTO) {
		Task task = Task.convertDTO(taskDTO);
		task = taskService.save(task);
		taskDTO.setId(task.getId());
		return taskDTO;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable(name="id") Long id) {
		taskService.delete(id);
	}
	
	@PutMapping
	public TaskDTO update(@RequestBody TaskDTO taskDTO) {
		Task task = Task.convertDTO(taskDTO);
		task = taskService.save(task);
		return taskDTO;
	}
	
}
