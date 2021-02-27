package com.broadtext.service.impl;

import com.broadtext.domain.repository.mapper.UserPOMapper;
import com.broadtext.domain.repository.po.UserPO;
import com.broadtext.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author swsm
 * @date 2021/2/27
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserPOMapper userPOMapper;

    @Override
    public UserPO getUser(int id) {
        return userPOMapper.selectById(id);
    }
}
