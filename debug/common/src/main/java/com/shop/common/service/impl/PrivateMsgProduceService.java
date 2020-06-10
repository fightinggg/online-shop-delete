package com.shop.common.service.impl;

import com.shop.common.annotation.enable.EnableUidServiceFeignAutoConfiguration;
import com.shop.common.dao.PrivateMsgDao;
import com.shop.common.entity.PrivateMsg;
import com.shop.common.exception.FallbackException;
import com.shop.common.service.UidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;

/**
 * 私人消息生产者
 */
@Service
@Import(PrivateMsgDao.class)
@EnableUidServiceFeignAutoConfiguration
public class PrivateMsgProduceService {
    @Autowired
    PrivateMsgDao privateMsgDao;
    @Autowired
    UidService uidService;

    public void send(Integer userId, String head, String payload) throws FallbackException {
        PrivateMsg privateMsg = new PrivateMsg(
                null,
                (Long) uidService.getUid(),
                userId,
                false,
                System.currentTimeMillis(),
                head,
                payload);
        privateMsgDao. insert(privateMsg);
    }
}
