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
}
