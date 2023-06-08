package br.com.lista.tarefas.dto;

import br.com.lista.tarefas.domains.Task;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TaskDTO {
	
	public TaskDTO () {}

	public TaskDTO(Long id, String text, String category, boolean isCompleted) {
		super();
		this.id = id;
		this.text = text;
		this.category = category;
		this.completed = isCompleted;
	}
	
	private Long id;
	private String text;
	private String category;
	private boolean completed;
	
	
	public static TaskDTO convertDomain(Task task) {
		return new TaskDTO(task.getId(), task.getText(), task.getCategory(),task.getIsCompleted() == 1 ? true : false);
	}

}
