package zhoukang.community.controller;

import javafx.scene.control.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import zhoukang.community.dto.PaginationDTO;
import zhoukang.community.model.User;
import zhoukang.community.service.QuestionService;
import javax.servlet.http.HttpServletRequest;

@Controller
public class profileController {
    @Autowired
    private QuestionService questionService;

    @RequestMapping("/profile/{action}")
    public String profile(@PathVariable(name = "action") String action,
                          @RequestParam(name="page",defaultValue ="1") Integer page,
                          @RequestParam(name="size",defaultValue = "5") Integer size,
                          Model model,
                          HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if(user==null){
            return "redirect:/";
        }
        if ("questions".equals(action)) {
            model.addAttribute("section", "questions");
            model.addAttribute("sectionName", "我的提问");
        } else if ("replies".equals(action)) {
            model.addAttribute("section", "replies");
            model.addAttribute("sectionName", "最新回复");
        }
        PaginationDTO pagination = questionService.listByAccount(user.getAccount_id());
        model.addAttribute("pagination",pagination);
        return "profile";
    }
}
