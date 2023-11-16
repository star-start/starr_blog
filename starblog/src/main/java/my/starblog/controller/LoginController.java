package my.starblog.controller;

import my.starblog.common.UserUtils;
import my.starblog.entity.RepMsg;
import my.starblog.entity.Record;
import my.starblog.entity.User;
import my.starblog.service.RecordService;
import my.starblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author Chenzixin
 * @email 2212294009@qq.com
 * @github https://github.com/star-start
 * @since 2022-12-18 1:28 下午
 */

@RestController
public class LoginController {
    @Autowired
    UserService userService;

    @Autowired
    RecordService recordService;


    //未登录的 重定向页 返回json回复
    @RequestMapping("/login_p")
    public RepMsg Login(){
        return new RepMsg("error","尚未登录哦 ");
    }


    @GetMapping("/record")
    public Record getRecord(){
        Integer userId = UserUtils.getCurrentUser().getUserId();
        Date LastLoginTime = recordService.getLoginRecord(userId).getRecordCreateTime();
        recordService.setRecord(userId);
        Record record = recordService.getLoginRecord(userId);
        record.setRecordCreateTime(LastLoginTime);
        return record;
    }

    @GetMapping("/currentUser")
    public User getCurrentUser(){
        return UserUtils.getCurrentUser();
    }

}
