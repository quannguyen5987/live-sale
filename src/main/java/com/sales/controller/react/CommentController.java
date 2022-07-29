package com.sales.controller.react;

import com.sales.model.Comment;
import com.sales.service.commentFake.ICommentFakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/store")
public class CommentController {

    @Autowired
    private ICommentFakeService commentFakeService;


    @GetMapping(value = "/comments")
    public ResponseEntity<Iterable<Comment>> getComments() {
        Iterable<Comment> comments = commentFakeService.findAll();
        return new ResponseEntity<Iterable<Comment>>(comments, HttpStatus.OK);
    }
}
