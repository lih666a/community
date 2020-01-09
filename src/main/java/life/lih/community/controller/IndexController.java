package life.lih.community.controller;

import life.lih.community.dto.QuestionDTO;
import life.lih.community.mapper.UserMapper;
import life.lih.community.model.User;
import life.lih.community.service.QuestionService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class IndexController {
    @Autowired(required = false)
    UserMapper userMapper;


    @GetMapping("/")
    public  String Index(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if (cookies!=null){
            User user = Arrays.stream(cookies).filter(cookie -> "token".equals(cookie.getName())).map(token -> userMapper.findByToken(token.getValue())).collect(Collectors.toList()).get(0);
            if (user!=null){
                request.getSession().setAttribute("user",user);
            }

        }


        return "index";
    }


}
