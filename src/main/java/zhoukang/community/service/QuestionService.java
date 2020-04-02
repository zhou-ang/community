package zhoukang.community.service;

import zhoukang.community.dto.PaginationDTO;
import zhoukang.community.model.Question;

public interface QuestionService {
    int insert(Question question);

    PaginationDTO list(Integer page, Integer size);

    PaginationDTO listByAccount(String account_id);
}
