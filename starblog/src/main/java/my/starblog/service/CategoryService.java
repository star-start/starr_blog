package my.starblog.service;

import my.starblog.entity.Category;
import java.util.List;

/**
 * (Category)表服务接口
 *
 * @author Chenzixin
 * @email 2212294009@qq.com
 * @github https://github.com/star-start
 * @since 2022-12-18 00:33:57
 */
public interface CategoryService {

    List<Category> getCategories(Integer userId, Byte status);

    List<Category> getCategoriesUsed();

    int addCategory(String categoryName,String categoryDescribe);

    int setCategoryName(Integer categoryId, String categoryName,String categoryDescribe);

    int deleteCategory(Integer categoryId);

}