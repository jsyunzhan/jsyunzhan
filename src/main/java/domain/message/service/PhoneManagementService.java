package domain.message.service;

import domain.message.entity.PhoneEntity;
import domain.shiro.entity.PageQueryResult;

public interface PhoneManagementService {
    /**
     * 手机消息管理分页
     * @param phoneEntity 分页实体
     * @return PageQueryResult
     */
    PageQueryResult phoneMessInfo(PhoneEntity phoneEntity);
}
