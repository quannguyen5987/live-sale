package com.sales.service.commentFake;

import com.sales.model.Comment;
import com.sales.repository.CommentFakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentFakeServiceImpl implements ICommentFakeService {

    @Autowired
    private CommentFakeRepository commentFakeRepository;

    @Override
    public Iterable<Comment> findAll() {
        return commentFakeRepository.findAll();
    }

    @Override
    public Optional<Comment> findById(Long id) {
        return commentFakeRepository.findById(id);
    }

    @Override
    public void save(Comment comment) {
        commentFakeRepository.save(comment);
    }

    @Override
    public void remove(Long id) {
        commentFakeRepository.deleteById(id);
    }
}
