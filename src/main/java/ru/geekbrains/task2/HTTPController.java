package ru.geekbrains.task2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/http")
@RequiredArgsConstructor
public class HTTPController {

    private final HttpHelper httpHelper;

    @GetMapping
    public String doRequest(Model model){
        model.addAttribute("message", httpHelper.doAction());
        return "http";
    }
}
