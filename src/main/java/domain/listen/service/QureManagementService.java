package domain.listen.service;

import domain.listen.entity.NoteEntity;
import domain.shiro.entity.PageQueryResult;

/**
 * 按听课人员查询Service
 */
public interface QureManagementService {
    PageQueryResult noteListInfo(NoteEntity noteEntity);
}
