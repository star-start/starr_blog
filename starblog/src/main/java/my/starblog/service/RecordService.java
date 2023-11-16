package my.starblog.service;

import my.starblog.entity.Record;

import java.util.List;

/**
 * (Record)表服务接口
 *
 * @author Chenzixin
 * @email 2212294009@qq.com
 * @github https://github.com/star-start
 * @since 2022-12-18 00:33:57
 */
public interface RecordService {

    Record getLoginRecord(Integer userId);

    List<Record> getScheduleRecordsInLatestWeek();

    int setRecord(Integer userId);

}