package com.lq.web;


import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liangq8
 * @since 2018-12-23
 */
@Api(value = "UserController", description = "用户模块 REST API")
@RestController
@RequestMapping("/user")
public class UserController {

}

