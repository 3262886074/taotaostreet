package com.tts.service.impl;

import com.tts.bean.*;
import com.tts.dao.UsersDao;
import com.tts.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public Users queryUserInfoByUid(long uid) {
        return usersDao.queryUserInfoByUid(uid);
    }

    @Override
    public Set<Order> queryOrdersByUid(long uid) {
        return usersDao.queryOrdersByUid(uid);
    }

    @Override
    public Set<User_Red_package> queryRedPackageByUid(long uid) {
        return usersDao.queryRedPackageByUid(uid);
    }

    @Override
    public Set<Discount_coupon> queryDiscountCouponByUid(long uid) {
        return usersDao.queryDiscountCouponByUid(uid);
    }

    @Override
    public Set<User_Collect> queryCollectsByUid(long uid) {
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
    public boolean updatePwd(String upwd, long uid) {
        if (usersDao.updatePwd(upwd, uid) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean addAuthentication(Long uid,String name,Long idcard) {
        if (usersDao.addAuthentication(uid, name, idcard) > 0) {
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
    public Users_Authentication queryAuthenticationByUid(Long uid) {
        Users_Authentication users_authentication = usersDao.queryAuthenticationByUid(uid);
        if (users_authentication != null) {
            return users_authentication;
        } else {
            return null;
        }
    }

    @Override
    public boolean updateSafetyQuestion(User_Safety_Question user_safety_question) {
        if (usersDao.updateSafetyQuestion(user_safety_question) > 0){
            return true;
        }
        return false;
    }

    @Override
    public User_Safety_Question querySafetyQuestionByUid(Long uid) {
        User_Safety_Question user_safety_question = usersDao.querySafetyQuestionByUid(uid);
        if (user_safety_question != null) {
            return user_safety_question;
        } else {
            return null;
        }
    }

    @Override
    public Set<User_address> getAddressesByUId(long uid) {
        return usersDao.getAddressesByUId(uid);
    }

    @Override
    public User_address queryAddressByUaId(Long uaid) {
        User_address userAddress = usersDao.queryAddressByUaId(uaid);
        if (userAddress != null){
            return userAddress;
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteAddressByUaId(Long uaid) {
        if (usersDao.deleteAddressByUaId(uaid) > 0){
            return true;
        } else {
            return false;
        }
    }

    @Transactional
    @Override
    public boolean updateDefaultAddress(long uid, long uaid) {
        if (usersDao.updateUnDefaultAddress(uid) > 0){
            if (usersDao.updateDefaultAddress(uaid) > 0){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addOneAddress(String uaname, long uatel, String location, String address, long uid) {
        if (usersDao.addOneAddress(uaname, uatel, location, address, uid) > 0) {
            return true;
        }
        return false;
    }
}
