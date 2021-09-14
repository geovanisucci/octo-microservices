package com.br.octo.hrworker.repositories;

import com.br.octo.hrworker.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository  extends JpaRepository<Worker, Long> {
}
