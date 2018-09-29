package club.small.dao;

import club.small.entity.Messenger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestDao extends BaseDao {
    @Autowired
    private MessengerDao messengerDao;

    @Test
    public void selectOne() throws Exception{
        Messenger messenger = messengerDao.isMessangerLogin("20151943");
        System.out.println(messenger);
    }
}
