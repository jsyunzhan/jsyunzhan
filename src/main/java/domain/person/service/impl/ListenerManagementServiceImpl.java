package domain.person.service.impl;

import domain.person.dao.ListenerDao;
import domain.person.entity.ListenerEntity;
import domain.person.service.ListenerManagementService;
import domain.shiro.entity.PageQueryResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Service
@Transactional
public class ListenerManagementServiceImpl implements ListenerManagementService{
    private static final Logger LOGGER = LoggerFactory.getLogger(ListenerManagementServiceImpl.class);

    private ListenerDao listenerDao;

    @Autowired
    public ListenerManagementServiceImpl(ListenerDao listenerDao){
        this.listenerDao = listenerDao;
    }

    @Override
    public PageQueryResult listenerList(ListenerEntity listenerEntity) {
        final PageQueryResult pageQueryResult = new PageQueryResult();

        final Integer count = listenerDao.listenerCount(listenerEntity);

        List<ListenerEntity> listenerEntities = newArrayList();

        if (count > 0){
            listenerEntities = listenerDao.listenerListInof(listenerEntity);
        }

        pageQueryResult.setRows(listenerEntities);
        pageQueryResult.setTotal(count);
        return pageQueryResult;
    }

    @Override
    public Boolean addListener(ListenerEntity listenerEntity) {
        final Boolean flag = listenerDao.addListener(listenerEntity) > 0;
        if (LOGGER.isDebugEnabled()){
            LOGGER.debug("听课人员新增结果:",flag);
        }
        return flag;
    }

    @Override
    public Boolean editListener(ListenerEntity listenerEntity) {
        final Boolean flag = listenerDao.editListener(listenerEntity) > 0;
        if (LOGGER.isDebugEnabled()){
            LOGGER.debug("听课人员修改结果:",flag);
        }
        return flag;
    }

    @Override
    public Boolean deleteListener(Long id, Long loginId) {
        final Boolean flag = listenerDao.deleteListener(id,loginId) > 0;
        if (LOGGER.isDebugEnabled()){
            LOGGER.debug("听课人员删除结果:",flag);
        }
        return flag;
    }

    @Override
    public Boolean authorizationListener(Long id, Long loginId) {
        final Boolean flag = listenerDao.authorizationListener(id,loginId) >0;
        if (LOGGER.isDebugEnabled()){
            LOGGER.debug("听课人员授权结果:",flag);
        }
        return flag;
    }

    @Override
    public Boolean authorizationListenerNot(Long id, Long loginId) {
        final Boolean flag = listenerDao.authorizationListenerNot(id,loginId) >0;

        if (LOGGER.isDebugEnabled()){
            LOGGER.debug("听课人员解除授权结果:",flag);
        }
        return flag;
    }
}
