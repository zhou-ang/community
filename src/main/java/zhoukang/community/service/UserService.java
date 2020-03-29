package zhoukang.community.service;

import zhoukang.community.model.User;

public interface UserService {
    public int insert(User user);

    public User selectByToken(String token);
}
