package zhoukang.community.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhoukang.community.dto.GithubUser;
import zhoukang.community.mapper.UserDao;
import zhoukang.community.model.User;
import zhoukang.community.service.UserService;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public int insert(User user) {
        return userDao.insert(user);
    }

    @Override
    public User selectByToken(String token) {
        return userDao.selectByToken(token);
    }

    public String SetUserFromGitUser(GithubUser githubuser){
        User user=new User();
        String token = UUID.randomUUID().toString();
        user.setToken(token);
        user.setName(githubuser.getName());
        user.setAccount_id(String.valueOf(githubuser.getId()));
        user.setAvatar_url(githubuser.getAvatar_url());
        user.setGmt_create(System.currentTimeMillis());
        user.setGmt_modify(user.getGmt_create());
        if(userDao.selectByAccountID(String.valueOf(githubuser.getId()))==null){
            userDao.insert(user);
        }else{
            userDao.updateByAccountID(user);
        }

        return token;
    }
}
