package life.lih.community;

import life.lih.community.dto.QuestionDTO;
import life.lih.community.service.QuestionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommunityApplicationTests {
    @Autowired
    QuestionService questionService;
    @Test
    public void contextLoads() {

        List<QuestionDTO> list = questionService.list();
        String avatar_url = list.get(0).getUser().getAvatar_url();
        System.out.println(avatar_url);
    }

}
