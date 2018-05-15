package domain.person.dao;

import domain.person.entity.ListenerEntity;
import org.apache.ibatis.annotations.Param;
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
     * @return Integer
     */
    Integer editListener(ListenerEntity listenerEntity);

    /**
     * 听课人员删除
     * @param id id
     * @param loginId 当前登录id
     * @return Integer
     */
    Integer deleteListener(@Param("id") Long id,@Param("updateUserId") Long loginId);

    /**
     * 听课人员授权
     * @param id id
     * @param loginId 当前登录id
     * @return 当前登录id
     */
    Integer authorizationListener(@Param("id") Long id,@Param("updateUserId") Long loginId);

    /**
     * 听课人员解除授权
     * @param id id
     * @param loginId 当前登录id
     * @return 当前登录id
     */
    Integer authorizationListenerNot(@Param("id") Long id,@Param("updateUserId") Long loginId);
}
