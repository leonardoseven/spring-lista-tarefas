package br.com.lista.tarefas.domains;

import br.com.lista.tarefas.dto.TaskDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tbtask")
@Getter
@Setter
public class Task {
	
	public Task() {}
	
	public Task(Long id, String text, String category, int isCompleted) {
		super();
		this.id = id;
		this.text = text;
		this.category = category;
		this.isCompleted = isCompleted;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String text;
	
	private String category;
	
	private int isCompleted;

	public static Task convertDTO(TaskDTO taskDTO) {
		return new Task(taskDTO.getId(),taskDTO.getText(), taskDTO.getCategory(), taskDTO.isCompleted() ? 1 : 0);
	}
	
}
