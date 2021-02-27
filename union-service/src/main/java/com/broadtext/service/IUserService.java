package com.broadtext.service;

import com.broadtext.domain.repository.po.UserPO;

/**
 * @author swsm
 * @date 2021/2/27
 */
public interface IUserService {
    
    UserPO getUser(int id);
    
}
