package domain.listen.service.impl;

import domain.listen.service.QureManagementService;
import domain.person.dao.ListenerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class QureManagementServiceImpl implements QureManagementService{
    private ListenerDao listenerDao;

    @Autowired
    public QureManagementServiceImpl(ListenerDao listenerDao){
        this.listenerDao = listenerDao;
    }
}
