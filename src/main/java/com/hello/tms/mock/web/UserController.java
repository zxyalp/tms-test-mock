package com.hello.tms.mock.web;

import com.hello.tms.mock.model.BpUser;
import com.hello.tms.mock.service.BpUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author alp.zxy
 * @date 2019/3/31
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private BpUserService bpUserService;

    @ResponseBody
    @PostMapping("/add")
    public int addUser(BpUser user){
        return bpUserService.addUser(user);
    }

    @ResponseBody
    @GetMapping("/all")
    public Object findAllUser(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize
    ){
                return bpUserService.findAllUser(pageNum, pageSize);
    }
}
