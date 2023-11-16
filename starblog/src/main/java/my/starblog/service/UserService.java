package my.starblog.service;

import my.starblog.entity.Role;
import my.starblog.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * (User)表服务接口
 *
 * @author Chenzixin
 * @email 2212294009@qq.com
 * @github https://github.com/star-start
 * @since 2022-12-18 00:33:57
 */
public interface UserService extends UserDetailsService {

    List<User> getUsersByNicknameKeyword(String nicknameKeyword, Byte status);

    User getUserByUserId(Integer userId);

    int register(User user);

    int setStatusByUserId(Integer userId, Byte status, Boolean isNewUser);

    List<Role> getRoles();

    int resetRolesByUserId(Integer[] roleIds, Integer userId);

    int deleteUserByUserId(Integer userId);

}