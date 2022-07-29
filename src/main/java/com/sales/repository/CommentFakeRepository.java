package com.sales.repository;

import com.sales.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentFakeRepository extends JpaRepository<Comment, Long> {
}
