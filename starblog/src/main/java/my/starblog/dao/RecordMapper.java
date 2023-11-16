package my.starblog.dao;

import my.starblog.entity.Record;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Record)表数据库访问层
 *
 * @author Chenzixin
 * @email 2212294009@qq.com
 * @github https://github.com/star-start
 * @since 2022-12-18 00:15:00
 */
public interface RecordMapper {

    Record selectLatestRecordByUserId(@Param("userId") Integer userId);

    int insertRecord(Record record);

    List<Record> selectScheduleRecordInLatestWeek();

}