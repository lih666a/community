package life.lih.community.mapper;

import life.lih.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    void insert(User user);
    User findByToken(@Param("token") String token);
}
