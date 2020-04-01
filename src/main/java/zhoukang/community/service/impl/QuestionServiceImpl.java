package zhoukang.community.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhoukang.community.dto.PaginationDTO;
import zhoukang.community.dto.QuestionDTO;
import zhoukang.community.mapper.QuestionDao;
import zhoukang.community.mapper.UserDao;
import zhoukang.community.model.Question;
import zhoukang.community.model.User;
import zhoukang.community.service.QuestionService;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    UserDao userDao;
    @Autowired
    QuestionDao questionDao;

    @Override
    public int insert(Question question) {
        return questionDao.insert(question);
    }

    @Override
    public PaginationDTO list(Integer currentPage, Integer size) {
        PageHelper.startPage(currentPage, size);
        List<Question> questionList = questionDao.selectList();

        List<QuestionDTO> questionDTOS = new ArrayList<>();
        for (Question question : questionList) {
            User user = userDao.selectByPrimaryKey(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOS.add(questionDTO);
        }
        PaginationDTO paginationDTO = new PaginationDTO();
        paginationDTO.setQuestions(questionDTOS);
        Integer totalCount = questionDao.count();
        paginationDTO.setPagination(totalCount,currentPage,size);
        return paginationDTO;
    }
}
