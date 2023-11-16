package my.starblog.dao;

import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (ArticleTagRelation)表数据库访问层
 *
 * @author Chenzixin
 * @email 2212294009@qq.com
 * @github https://github.com/star-start
 * @since 2022-12-18 00:15:00
 */
public interface ArticleTagRelationMapper {

    void deleteByArticleId(@Param("articleId") Integer articleId);

    int insertByAidAndTid(@Param("articleId") Integer articleId, @Param("tagIds") List<Integer> tagIds);

    int deleteByArticleIds(@Param("articleIds") Integer[] articleIds);

}