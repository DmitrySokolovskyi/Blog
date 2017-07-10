package com.sokoldevpro.blog.web;

import com.sokoldevpro.blog.domain.entity.Post;
import com.sokoldevpro.blog.service.NotificationService;
import com.sokoldevpro.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private NotificationService notificationService;

    @RequestMapping(value = "/posts/view/{id}", method = GET)
    public String showPost(@PathVariable("id") Long id, Model model) {
        Post post = postService.findById(id);
        if (post == null) {
            notificationService.addErrorMessage("Cannot find post: " + id);
            return "redirect:/";
        }

        model.addAttribute("post", post);
        return "/posts/index";
    }
}
