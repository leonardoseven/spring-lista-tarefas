package br.com.lista.tarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lista.tarefas.domains.Task;

@Repository
public interface ITaskRepository extends JpaRepository<Task, Long>{

}
