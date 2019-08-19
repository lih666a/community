package life.lih.community.controller;

import life.lih.community.mapper.QuestionMapper;
import life.lih.community.mapper.UserMapper;
import life.lih.community.model.Questtion;
import life.lih.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class PublishController {
    @Autowired
    QuestionMapper questionMapper;
    @Autowired
    UserMapper userMapper;


    @GetMapping("/publish")
    public  String publish(){

        return "publish";
    }
@PostMapping("/publish")
    public  String doPublish(
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("tag") String tag,
            HttpServletRequest request,
            Model model
            ){
    User user=null;
    Cookie[] cookies = request.getCookies();
    if (cookies!=null){
        for (Cookie cookie : cookies) {
            if("token".equals(cookie.getName())){
                String token=cookie.getValue();
                 user =userMapper.findByToken(token);
                if (user !=null)
                    request.getSession().setAttribute("user",user);
                break;
            }
        }
    }
    if(user==null){
        model.addAttribute("error","用户未登录");
        return "publish";

    }
    Questtion questtion = new Questtion();
    questtion.setTitle(title);
    questtion.setDescription(description);
    questtion.setTag(tag);
    questtion.setCreator(user.getId());
    questtion.setGmtCreate(System.currentTimeMillis());
    questtion.setGmtModified(questtion.getGmtCreate());
    questionMapper.create(questtion);

    return "redirect:/";
    }
}
