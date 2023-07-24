package io.bootify.vsit_managment_system.repos;

import io.bootify.vsit_managment_system.domain.Visit;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VisitRepository extends JpaRepository<Visit, Long> {
}
