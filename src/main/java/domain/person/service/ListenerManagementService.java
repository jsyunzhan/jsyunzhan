package domain.person.service;

import domain.person.entity.ListenerEntity;
import domain.shiro.entity.PageQueryResult;

public interface ListenerManagementService {
    /**
     * 听课人员管理分页
     * @param listenerEntity 分页实体
     * @return PageQueryResult
     */
    PageQueryResult listenerList(ListenerEntity listenerEntity);

    /**
     * 听课人员新增
     * @param listenerEntity 新增实体
     * @return Boolean
     */
    Boolean addListener(ListenerEntity listenerEntity);

    /**
     * 听课人员修改
     * @param listenerEntity 修改实体
     * @return Boolean
     */
    Boolean editListener(ListenerEntity listenerEntity);

    /**
     * 听课人员删除
     * @param id id
     * @param loginId 当前登录id
     * @return Boolean
     */
    Boolean deleteListener(Long id, Long loginId);

    /**
     * 听课人员查看私有笔记授权
     * @param id id
     * @param loginId 当前登录id
     * @return Boolean
     */
    Boolean authorizationListener(Long id, Long loginId);

    /**
     * 查看私有笔记解除授权
     * @param id id
     * @param loginId 当前登录id
     * @return Boolean
     */
    Boolean authorizationListenerNot(Long id, Long loginId);

    /**
     * 机关进校园笔记提交授权
     * @param id id
     * @param loginId 当前登录id
     * @return Boolean
     */
    Boolean organListener(Long id, Long loginId);

    /**
     * 机关进校园笔记提交解除授权
     * @param id id
     * @param loginId 当前登录id
     * @return Boolean
     */
    Boolean organnotListener(Long id, Long loginId);
}
