package my.starblog.dao;

import my.starblog.entity.Category;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Category)表数据库访问层
 *
 * @author Chenzixin
 * @email 2212294009@qq.com
 * @github https://github.com/star-start
 * @since 2022-12-18 00:15:00
 */
public interface CategoryMapper {

    int selectCategoriesUsedCount();

    int selectCategoriesCount(@Param("userId") Integer userId);

    List<Category> selectCategories(@Param("userId") Integer userId,@Param("status") Byte status);

    List<Category> selectCategoriesUsed();

    int insertCategory(@Param("userId") Integer userId,@Param("categoryName") String categoryName, @Param("categoryDescribe") String categoryDescribe);



    int updateCategoryByCategoryId(@Param("categoryId") Integer categoryId,@Param("categoryName") String categoryName,@Param("categoryDescribe") String categoryDescribe);

    int deleteCategoryByCategoryId(@Param("categoryId") Integer categoryId);

}