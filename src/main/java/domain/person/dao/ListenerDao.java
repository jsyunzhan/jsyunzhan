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

    /**
     * 听课人员新增
     * @param listenerEntity 新增实体
     * @return Integer
     */
    Integer addListener(ListenerEntity listenerEntity);

    /**
     * 听课人员修改
     * @param listenerEntity 修改实体
     * @return
     */
    Integer editListener(ListenerEntity listenerEntity);
}
