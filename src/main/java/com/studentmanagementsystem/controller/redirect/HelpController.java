package com.studentmanagementsystem.controller.redirect;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class HelpController {
    private String documentation = "https://www.postman.com/adityakalambe20/workspace/student-management-system/overview";
    @GetMapping
    public RedirectView redirectPage() {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(documentation);
        return redirectView;
    }
}
