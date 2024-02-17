package com.lakhdharmedakrem.deepmetisinterview.repository;

import com.lakhdharmedakrem.deepmetisinterview.model.SandwichOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
@Repository
public interface SandwichOrderRepository extends JpaRepository<SandwichOrder,Long> {
}
