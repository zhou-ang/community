package zhoukang.community.service;

import zhoukang.community.dto.QuestionDTO;
import zhoukang.community.model.Question;

import java.util.List;

public interface QuestionService {
    int insert(Question question);

    List<QuestionDTO> list();
}
