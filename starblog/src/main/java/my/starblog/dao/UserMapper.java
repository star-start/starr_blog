package my.starblog.dao;

import my.starblog.entity.Role;
import my.starblog.entity.User;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (User)表数据库访问层
 *
 * @author Chenzixin
 * @email 2212294009@qq.com
 * @github https://github.com/star-start
 * @since 2022-12-18 00:15:00
 */
public interface UserMapper {

    List<User> selectUsersByNicknameKeyword(@Param("nicknameKeyword") String nicknameKeyword,@Param("status") Byte status);

    User selectUserByUserId(@Param("userId") Integer userId);

    User selectUserByUsername(@Param("s") String s);

    int insertRegisterUser(User user);

    int insertRegisterURR(@Param("userId") Integer userId);

    int updateUserByStatus(@Param("userId") Integer userId,@Param("status") Byte status);

    List<Role> selectRoles();

    int deleteURRByUserId(@Param("userId") Integer userId);

    int insertURRByUserIdAndRoleIds(  @Param("roleIds") Integer[] roleIds, @Param("userId") Integer userId);

    int deleteUserByUserId(@Param("userId") Integer userId);

}