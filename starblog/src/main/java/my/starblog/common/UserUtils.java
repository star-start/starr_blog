package my.starblog.common;

import my.starblog.entity.User;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author Chenzixin
 * @email 2212294009@qq.com
 * @github https://github.com/star-start
 * @since 2022-12-18 12:38 上午
 */
public class UserUtils {
    public static User getCurrentUser(){
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
