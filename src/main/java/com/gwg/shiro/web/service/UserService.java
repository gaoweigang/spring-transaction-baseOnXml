package com.gwg.shiro.web.service;

import com.github.pagehelper.PageInfo;
import com.gwg.shiro.web.dto.UserDto;
import com.gwg.shiro.web.exception.BusinessException;
import com.gwg.shiro.web.model.User;
import com.gwg.shiro.web.vo.UserVo;

/**
 * Created by
 */
public interface UserService{

    /**
     * 新增-用户
     */
    public void addUserInfo(UserDto dto);

    /**
     * 更新用户信息
     * @param dto
     * @throws BusinessException
     */
    public void updateUserInfo(UserDto dto) throws BusinessException;

}
