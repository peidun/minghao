package wang.peidun.mhstudio.service.impl;

import org.springframework.stereotype.Service;
import wang.peidun.mhstudio.dao.ContactMapper;
import wang.peidun.mhstudio.entity.Contact;
import wang.peidun.mhstudio.service.IContactService;

import javax.annotation.Resource;

/**
 * @Author: wangpd
 * @Date: 2019-07-23 14:48
 */
@Service
public class ContactServiceImpl implements IContactService {

    @Resource
    private ContactMapper contactMapper;

    @Override
    public int save(Contact contact) {
        return contactMapper.save(contact);
    }
}
