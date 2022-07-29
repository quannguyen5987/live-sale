package com.sales.repository;

import com.sales.model.Stupid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StupidRepository extends JpaRepository<Stupid, Long> {
}
