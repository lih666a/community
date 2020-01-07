package life.lih.community.service.impl;

import life.lih.community.dto.QuestionDTO;
import life.lih.community.mapper.QuestionMapper;
import life.lih.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionMapper questionMapper;
    @Override
    public List<QuestionDTO> list() {
        return questionMapper.list();
    }
}
