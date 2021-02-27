package com.broadtext.web.advice;

import com.broadtext.common.api.Result;
import com.broadtext.common.exception.BusinessException;
import com.broadtext.common.util.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

/**
 * 统一异常处理
 * @date 2020/12/5
 */
@RestControllerAdvice
@Slf4j
public class ControllerExceptionAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<String> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        log.error("出现MethodArgumentNotValidException", e);
        String message = e.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining());
        return Result.failed(message);
    }

    @ExceptionHandler(BusinessException.class)
    public Result<String> BusinessExceptionHandler(BusinessException e) {
        log.error("出现BusinessException", e);
        String message = Validator.isNullOrEmpty(e.getMessage()) ? "执行失败" : e.getMessage();
        return Result.failed(message);
    }
    
}
