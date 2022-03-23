package com.threeclear.pollution.exception;

import cn.hutool.core.collection.CollUtil;
import com.threeclear.baseweb.vo.ServerResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;

/**
 * @author 邵海楠
 */
@RestControllerAdvice
public class CommonException {
    private final static Logger logger = LoggerFactory.getLogger(CommonException.class);


    @ExceptionHandler(ConstraintViolationException.class)
    public ServerResponse resolveConstraintViolationException(ConstraintViolationException ex) {
        Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
        StringBuffer stringBuffer = new StringBuffer();
        if (!CollUtil.isEmpty(constraintViolations)) {
            for (ConstraintViolation constraintViolation : constraintViolations) {
                stringBuffer.append(constraintViolation.getMessage()).append(",");
            }
        }
        if (stringBuffer.length() > 1) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        return ServerResponse.createByErrorMessage(stringBuffer.toString());
    }

    @ExceptionHandler(BindException.class)
    public ServerResponse resolveConstraintViolationException(BindException ex) {
        List<FieldError> fieldErrors = ex.getFieldErrors();
        StringBuilder stringBuffer = new StringBuilder();
        fieldErrors.forEach(p -> {
                    stringBuffer.append(p.getDefaultMessage() + ",");
                }
        );
        if (stringBuffer.length() > 1) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }

        return ServerResponse.createByErrorMessage(stringBuffer.toString());
    }


    @ExceptionHandler(value = Exception.class)
    ServerResponse handleExcection(Exception e, HttpServletRequest httpServletRequest) {
        String error = e.getMessage();
        logger.error(error, e);
        return ServerResponse.createByErrorMessage(error);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ServerResponse handleExcection(MethodArgumentNotValidException e, HttpServletRequest httpServletRequest) {
        BindingResult bindingResult = e.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        StringBuilder stringBuffer = new StringBuilder();

        fieldErrors.forEach(p -> {
                    stringBuffer.append(p.getDefaultMessage() + ",");
                }
        );
        if (stringBuffer.length() > 1) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }

        return ServerResponse.createByErrorMessage(stringBuffer.toString());
    }

}
