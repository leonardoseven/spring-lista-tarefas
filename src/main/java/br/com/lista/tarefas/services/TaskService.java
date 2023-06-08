package br.com.lista.tarefas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import br.com.lista.tarefas.domains.Task;
import br.com.lista.tarefas.dto.TaskDTO;
import br.com.lista.tarefas.repository.ITaskRepository;

@Service
public class TaskService {

	@Autowired
	private ITaskRepository iTaskRepository;
	
	
	public Task save(Task task) {
		return iTaskRepository.save(task);
	}

	public List<TaskDTO> list() {
		List<Task> listTask = iTaskRepository.findAll();
		if(CollectionUtils.isEmpty(listTask)) return null;
		return listTask.stream().map( task -> TaskDTO.convertDomain(task)).collect(Collectors.toList());
	}
	
	public void delete(Long id) {
		iTaskRepository.deleteById(id);
	}
}
