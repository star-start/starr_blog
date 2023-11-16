package my.starblog.service.impl;

import my.starblog.common.UserUtils;
import my.starblog.dao.CategoryMapper;
import my.starblog.entity.Category;
import my.starblog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Category)表服务实现类
 *
 * @author Chenzixin
 * @email 2212294009@qq.com
 * @github https://github.com/star-start
 * @since 2022-12-18 00:33:57
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<Category> getCategories(Integer userId, Byte status) {
        return categoryMapper.selectCategories(userId,status);
    }

    @Override
    public List<Category> getCategoriesUsed() {
        return categoryMapper.selectCategoriesUsed();
    }


    @Override
    public int addCategory(String categoryName, String categoryDescribe) {
        return categoryMapper.insertCategory(UserUtils.getCurrentUser().getUserId(), categoryName,categoryDescribe);
    }

    @Override
    public int setCategoryName(Integer categoryId, String categoryName, String categoryDescribe) {
        return categoryMapper.updateCategoryByCategoryId(categoryId, categoryName,categoryDescribe);
    }

    @Override
    public int deleteCategory(Integer categoryId) {
        return categoryMapper.deleteCategoryByCategoryId(categoryId);
    }
}