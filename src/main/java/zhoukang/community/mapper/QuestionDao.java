package zhoukang.community.mapper;

import org.apache.ibatis.annotations.Mapper;
import zhoukang.community.model.Question;

import java.util.List;

@Mapper
public interface QuestionDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Question record);

    int insertSelective(Question record);

    Question selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKeyWithBLOBs(Question record);

    int updateByPrimaryKey(Question record);

    List<Question> selectList();
}