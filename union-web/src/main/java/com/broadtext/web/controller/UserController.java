package com.broadtext.web.controller;

import com.broadtext.common.api.Result;
import com.broadtext.common.exception.BusinessException;
import com.broadtext.common.util.Validator;
import com.broadtext.domain.repository.po.UserPO;
import com.broadtext.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author swsm
 * @date 2021/2/27
 */
@RestController
@Slf4j
public class UserController {
    
    @Autowired
    private IUserService userService;
    
    @GetMapping("/v1/user/base/{id}")
    public Result<UserPO> get(@PathVariable("id") int id) {
        log.info("查询用户信息 params = {}", id);
        UserPO userPO = userService.getUser(id);
        if (Validator.isNullOrEmpty(userPO)) {
            throw new BusinessException("用户不存在");
        }
        log.info("查询用户信息 res = {}", userPO);
        return Result.ok(userPO);
    }
    
}
