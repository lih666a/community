package life.lih.community.mapper;

import life.lih.community.dto.QuestionDTO;
import life.lih.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuestionMapper {
    void  create(Question question);
    List<QuestionDTO> list();
}
