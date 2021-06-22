package com.gilbertogavioli.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gilbertogavioli.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
