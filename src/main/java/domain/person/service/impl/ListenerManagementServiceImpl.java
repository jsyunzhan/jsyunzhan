package domain.person.service.impl;

import domain.person.dao.ListenerDao;
import domain.person.entity.ListenerEntity;
import domain.person.service.ListenerManagementService;
import domain.shiro.entity.PageQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ListenerManagementServiceImpl implements ListenerManagementService{

    private ListenerDao listenerDao;

    @Autowired
    public ListenerManagementServiceImpl(ListenerDao listenerDao){
        this.listenerDao = listenerDao;
    }

    @Override
    public PageQueryResult listenerList(ListenerEntity listenerEntity) {
        final PageQueryResult pageQueryResult = new PageQueryResult();

        final Integer count = listenerDao.listenerCount(listenerEntity);
        return null;
    }
}
