package domain.person.dao;

import domain.person.entity.ListenerEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface ListenerDao {
    /**
     * 获取总数
     * @param listenerEntity 查询实体
     * @return Integer
     */
    Integer listenerCount(ListenerEntity listenerEntity);
}
