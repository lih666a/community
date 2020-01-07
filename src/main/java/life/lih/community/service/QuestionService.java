package life.lih.community.service;

import life.lih.community.dto.QuestionDTO;
import life.lih.community.mapper.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface QuestionService {
     List<QuestionDTO> list();
}
