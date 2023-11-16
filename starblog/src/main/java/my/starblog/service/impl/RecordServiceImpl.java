package my.starblog.service.impl;

import my.starblog.dao.ArticleMapper;
import my.starblog.dao.CommentMapper;
import my.starblog.dao.RecordMapper;
import my.starblog.entity.Record;
import my.starblog.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * (Record)表服务实现类
 *
 * @author Chenzixin
 * @email 2212294009@qq.com
 * @github https://github.com/star-start
 * @since 2022-12-18 00:33:57
 */
@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    RecordMapper recordMapper;

    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    CommentMapper commentMapper;

    @Override
    public Record getLoginRecord(Integer userId) {
        return recordMapper.selectLatestRecordByUserId(userId);
    }

    @Override
    public int setRecord(Integer userId) {

        Record latestLoginRecord = recordMapper.selectLatestRecordByUserId(userId);
        int commentsCount = commentMapper.selectCommentsCount(userId);
        Object vc = articleMapper.selectViewsCount(userId);
        long viewsCount = vc != null ? (long) vc : 0;

        Record record = new Record();
        record.setCommentsCount(commentsCount);
        record.setViewsCount(viewsCount);
        record.setNewComments(commentsCount - latestLoginRecord.getCommentsCount());
        record.setNewViews(viewsCount - latestLoginRecord.getViewsCount());
        record.setRecordCreateTime(new Timestamp(System.currentTimeMillis()));
        record.setUserId(userId);
        int res = recordMapper.insertRecord(record);
        return res;
    }


    @Override
    public List<Record> getScheduleRecordsInLatestWeek() {
        return recordMapper.selectScheduleRecordInLatestWeek();
    }

    /**
     * 每天凌晨0点日常记录,可选择开启,
     * 12为系统日程记录的用户id
     * 若开启在LovecanflyApplication开启注解@EnableSchedule
     */
//    @Scheduled(cron = "0 0 0 * * *")
    public void setScheduleRecord() {
        int res = this.setRecord(12);
        System.out.println(res == 1 ? "定时记录插入成功" : "失败");
    }


}