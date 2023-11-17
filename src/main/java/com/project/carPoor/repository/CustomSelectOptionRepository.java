package com.project.carPoor.repository;

import com.project.carPoor.domain.SelectOption;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomSelectOptionRepository extends JpaRepository<SelectOption, Long> {

    Optional<SelectOption> findTopByOrderByIdDesc();
}
