package com.tts.service.impl;

import com.tts.bean.*;
import com.tts.dao.UsersDao;
import com.tts.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("usersService")
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersDao usersDao;

    @Override
    public Users userLogin(String nickname, String pwd) {
        if (nickname != null && !"".equals(nickname)) {
            if (pwd != null && !"".equals(pwd)) {
                Users users = usersDao.userLogin(nickname, pwd);
                return users;
            }
        }
        return null;
    }

    @Override
    public boolean userRegister(String nickname, String pwd) {
        if (usersDao.userRegister(nickname, pwd) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Users queryUserInfoByUid(Integer uid) {
        return usersDao.queryUserInfoByUid(uid);
    }

    @Override
    public Set<Order> queryOrdersByUid(Integer uid) {
        return usersDao.queryOrdersByUid(uid);
    }

    @Override
    public Set<User_Red_package> queryRedPackageByUid(Integer uid) {
        return usersDao.queryRedPackageByUid(uid);
    }

    @Override
    public Set<Discount_coupon> queryDiscountCouponByUid(Integer uid) {
        return usersDao.queryDiscountCouponByUid(uid);
    }

    @Override
    public Set<User_Collect> queryCollectsByUid(Integer uid) {
        return usersDao.queryCollectsByUid(uid);
    }

    @Override
    public boolean updateInfo(Users users) {
        if (usersDao.updateInfo(users) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updatePwd(String upwd, Integer uid) {
        if (usersDao.updatePwd(upwd, uid) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean addAuthentication(Users_Authentication users_authentication) {
        if (usersDao.addAuthentication(users_authentication) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean addSafetyQuestion(User_Safety_Question user_safety_question) {
        if (usersDao.addSafetyQuestion(user_safety_question) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Set<User_address> getAddressesByUId(Integer uid) {
        return usersDao.getAddressesByUId(uid);
    }

    @Override
    public boolean updateUnDefaultAddress(Integer uid) {
        if (usersDao.updateDefaultAddress(uid) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updateDefaultAddress(Integer uaid) {
        if (usersDao.updateDefaultAddress(uaid) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean addOneAddress(String uaname, long uatel, String location, String address, Integer uid) {
        if (usersDao.addOneAddress(uaname, uatel, location, address, uid) > 0) {
            return true;
        }
        return false;
    }
}
