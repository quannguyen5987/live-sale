package com.sales.controller.thymeleaf;

import com.sales.model.Comment;
import com.sales.model.Level;
import com.sales.service.commentFake.ICommentFakeService;
import com.sales.service.level.ILevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Optional;

@Controller
@RequestMapping(value = "/manager/admin")
public class CommentFakeController {

    @Autowired
    private ICommentFakeService commentFakeService;

    @Autowired
    private ILevelService levelService;

    @ModelAttribute("levels")
    public Iterable<Level> levels(){
        return levelService.findAll();
    }


    @GetMapping("/create-comment")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/comment/create");
        modelAndView.addObject("comment", new Comment());
        return modelAndView;
    }

    @PostMapping("/create-comment")
    public ModelAndView saveUser(@ModelAttribute("comment") Comment comment) {
        commentFakeService.save(comment);
        ModelAndView modelAndView = new ModelAndView("/comment/create");
        modelAndView.addObject("comment", new Comment());
        modelAndView.addObject("message", "New comment created successfully");
        return modelAndView;
    }

    @GetMapping("/comments")
    public ModelAndView listUsers(Principal principal) {
        ModelAndView modelAndView = new ModelAndView("/comment/list");
        modelAndView.addObject("comments", commentFakeService.findAll());
        return modelAndView;
    }

    @GetMapping("/edit-comment/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Comment> comment = commentFakeService.findById(id);
        if (comment.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/comment/edit");
            modelAndView.addObject("comment", comment.get());
            return modelAndView;
        } else {
            return new ModelAndView("/error.404");
        }
    }

    @PostMapping("/edit-comment")
    public ModelAndView updateUser(@ModelAttribute("comment") Comment comment, Principal principal) {
        commentFakeService.save(comment);
        ModelAndView modelAndView = new ModelAndView("/comment/edit");
        modelAndView.addObject("comment", comment);
        modelAndView.addObject("message", "User updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-comment/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<Comment> comment = commentFakeService.findById(id);
        if (comment.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/comment/delete");
            modelAndView.addObject("comment", comment.get());
            return modelAndView;

        } else {
            return new ModelAndView("/error.404");
        }
    }

    @PostMapping("/delete-comment")
    public String deleteUser(@ModelAttribute("comment") Comment comment) {
        commentFakeService.remove(comment.getId());
        return "redirect:comments";
    }

}
