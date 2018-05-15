package domain.person.dao;

import domain.person.entity.ListenerEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListenerDao {
    /**
     * 获取总数
     * @param listenerEntity 查询实体
     * @return Integer
     */
    Integer listenerCount(ListenerEntity listenerEntity);

    /**
     * 分页集合
     * @param listenerEntity 查询实体
     * @return List<ListenerEntity>
     */
    List<ListenerEntity> listenerListInof(ListenerEntity listenerEntity);
}
