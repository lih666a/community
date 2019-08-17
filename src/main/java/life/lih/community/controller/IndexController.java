package life.lih.community.controller;

import life.lih.community.mapper.UserMapper;
import life.lih.community.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {
    @Autowired
    UserMapper userMapper;
    @GetMapping("/")
    public  String Index(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if (cookies!=null){
            for (Cookie cookie : cookies) {
                if("token".equals(cookie.getName())){
                    String token=cookie.getValue();
                    User user =userMapper.findByToken(token);
                    if (user !=null)
                        request.getSession().setAttribute("user",user);
                    break;
                }
            }
        }



        return "index";
    }


}
