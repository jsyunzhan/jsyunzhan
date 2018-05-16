package domain.message.dao;

import domain.message.entity.PhoneEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhoneDao {
    /**
     * 手机消息管理总数
     * @param phoneEntity 分页总是
     * @return Integer
     */
    Integer phoneMessCount(PhoneEntity phoneEntity);

    /**
     * 手机消息管理，分页集合
     * @param phoneEntity 分页实体
     * @return List<PhoneEntity>
     */
    List<PhoneEntity> phoneMessList(PhoneEntity phoneEntity);
}
