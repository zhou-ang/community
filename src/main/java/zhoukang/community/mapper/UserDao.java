package zhoukang.community.mapper;

import org.apache.ibatis.annotations.Mapper;
import zhoukang.community.model.User;

@Mapper
public interface UserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByToken(String token);

}