package zhoukang.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import zhoukang.community.model.Question;
import zhoukang.community.model.User;
import zhoukang.community.service.QuestionService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class publishController {
    @Autowired
    private QuestionService questionService;

    @GetMapping("/publish")
    public String publish() {
        return "publish";
    }

    @PostMapping("/publish")
    public String dopublish(
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("tag") String tag,
            HttpServletRequest request,
            Model model
    ) {
        model.addAttribute("title",title);
        model.addAttribute("description",description);
        model.addAttribute("tag",tag);

        if(title==null||title==""){
            model.addAttribute("error","标题不能为空");
            return "publish";
        }
        if(description==null||description==""){
            model.addAttribute("error","问题不能为空");
            return "publish";
        }
        if(tag==null||tag==""){
            model.addAttribute("error","标签不能为空");
            return "publish";
        }
        User user= (User) request.getSession().getAttribute("user");

        if(user==null){
            model.addAttribute("error","用户未登录");
            return "publish";
        }

        Question question=new Question();
        question.setTitle(title);
        question.setDescription(description);
        question.setTags(tag);
        question.setCreator(user.getAccount_id());
        question.setGmt_create(System.currentTimeMillis());
        question.setGmt_modified(question.getGmt_create());
        questionService.insert(question);

        return "redirect:/";
    }
}
