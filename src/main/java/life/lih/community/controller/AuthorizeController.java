package life.lih.community.controller;

import life.lih.community.dto.AccessTokenDTO;
import life.lih.community.dto.GithubUser;
import life.lih.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;
@GetMapping("/callback")
     public String callback(@RequestParam(name="code")String  code,@RequestParam(name="state")String state){


    AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
    accessTokenDTO.setClient_id("3a1d32ab34b393f234be");
    accessTokenDTO.setClient_secret("65867507987776be25c8d6ebb2c1ce359647f807");
    accessTokenDTO.setCode(code);
    http://localhost:8887/callback.setRedirect_uri("http://localhost:8887/callback");
    accessTokenDTO.setState(state);
    String accessToken = githubProvider.getAccessToken(accessTokenDTO);
    GithubUser user = githubProvider.getUser(accessToken);
    System.out.println(user.getName());
    return "index";
}
}
