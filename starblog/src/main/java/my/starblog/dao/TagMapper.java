package my.starblog.dao;

import my.starblog.entity.Tag;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Tag)表数据库访问层
 *
 * @author Chenzixin
 * @email 2212294009@qq.com
 * @github https://github.com/star-start
 * @since 2022-12-18 00:15:00
 */
public interface TagMapper {

    int selectTagsUsedCount();

    List<Tag> selectTagsUsed();

    int insertBytagNames(@Param("tagNames") String[] tagNames);

    List<Integer> selectTagIdsByTagNames(@Param("tagNames") String[] tagNames);

}