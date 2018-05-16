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

    /**
     * 手机公告新增
     * @param phoneEntity 新增实体
     * @return Boolean
     */
    Boolean phoneMessAdd(PhoneEntity phoneEntity);

    /**
     * 手机公告修改
     * @param phoneEntity 修改实体
     * @return Boolean
     */
    Boolean phoneMessEdit(PhoneEntity phoneEntity);

    /**
     * 手机公告删除
     * @param id id
     * @param loginId 当前登录id
     * @return Boolean
     */
    Boolean phoneMessDelete(Long id, Long loginId);
}
