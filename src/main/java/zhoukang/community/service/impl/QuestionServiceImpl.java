package zhoukang.community.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhoukang.community.mapper.QuestionDao;
import zhoukang.community.model.Question;
import zhoukang.community.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionDao questionDao;
    @Override
    public int insert(Question question) {
        return questionDao.insert(question);
    }
}
