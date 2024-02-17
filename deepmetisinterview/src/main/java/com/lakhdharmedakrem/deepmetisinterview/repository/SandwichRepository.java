package com.lakhdharmedakrem.deepmetisinterview.repository;

import com.lakhdharmedakrem.deepmetisinterview.model.Ingredient;
import com.lakhdharmedakrem.deepmetisinterview.model.Sandwich;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Repository
@RepositoryRestResource
public interface SandwichRepository extends JpaRepository<Sandwich,Long> {



    List<Sandwich> findByCreationDateBetween(
            LocalDateTime startOfDay,
            LocalDateTime endOfDay
    );

    default List<Sandwich> findByCreationDate(LocalDate date) {
        LocalDateTime startOfDay = date.atStartOfDay();
        LocalDateTime endOfDay = date.atTime(23, 59, 59);
        return findByCreationDateBetween(startOfDay, endOfDay);
    }
}
