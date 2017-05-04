package com.tts.service.impl;

import com.tts.bean.*;
import com.tts.dao.UsersDao;
import com.tts.dto.PayExecution;
import com.tts.exception.BalanceNotEnoughException;
import com.tts.exception.PayException;
import com.tts.exception.UnderStockException;
import com.tts.service.UsersService;
import com.tts.utils.StringUtils;
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
    public Set<Commodity_items> queryItemsByScid(long scid) {
        return usersDao.queryItemsByScid(scid);
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
    public boolean addAuthentication(Long uid, String name, Long idcard) {
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
        if (usersDao.updateSafetyQuestion(user_safety_question) > 0) {
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
        if (userAddress != null) {
            return userAddress;
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteAddressByUaId(Long uaid) {
        if (usersDao.deleteAddressByUaId(uaid) > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public User_Account getAccountMoney(long uid) {
        return usersDao.getAccountMoney(uid);
    }

    @Override
    public Integer okOrder(long oid) {
        return usersDao.okOrder(oid);
    }

    @Override
    public String addComment(String content, Integer type, long uid, long cid) {
        if (usersDao.addComment(content, type, uid, cid) > 0) {
            return StringUtils.success;
        } else {
            return StringUtils.fail;
        }
    }

    @Override
    public String confirmOrder(long oid) {
        Integer integer = usersDao.confirmOrder(oid);
        if (integer > 0) {
            return StringUtils.success;
        } else {
            return StringUtils.fail;
        }
    }

    @Transactional
    @Override
    public String cancelOrder(long oid, long uid) {
        Order order = usersDao.queryOrderInfoByOid(oid);
        Set<Commodity_items> commodityItems = usersDao.queryItemsByScid(order.getShoppingCart().getScId());
        Integer reduceCommodityNumber = 0;
        for (Commodity_items items : commodityItems) {
            reduceCommodityNumber = usersDao.addCommodityNumber(items.getNumber(), items.getCommodity().getCid());
        }
        if (reduceCommodityNumber > 0) {
            if (order.getStatus() != -1) { //如果为-1未支付状态就不退款
                usersDao.returnMoney(order.getMoney(), uid);
                Integer j = usersDao.cancelOrder(oid);
                if (j > 0) {
                    return StringUtils.success;
                } else {
                    return StringUtils.fail;
                }
            } else {
                Integer j = usersDao.cancelOrder(oid);
                if (j > 0) {
                    return StringUtils.success;
                } else {
                    return StringUtils.fail;
                }
            }
        } else {
            return StringUtils.fail;
        }
    }

    @Transactional
    @Override
    public PayExecution executePay(long oid, long uid) {
        Order order = usersDao.queryOrderInfoByOid(oid);
        Set<Commodity_items> commodityItems = usersDao.queryItemsByScid(order.getShoppingCart().getScId());
        try {
            Integer reduceCommodityNumber = 0;
            for (Commodity_items item : commodityItems) {
                reduceCommodityNumber = usersDao.reduceCommodityNumber(item.getNumber(), item.getCommodity().getCid());
            }
            if (reduceCommodityNumber <= 0) {
                throw new UnderStockException("库存不足");
            } else {
                Integer updateMoney = usersDao.updateAccountMoney(order.getMoney(), uid);
                if (updateMoney <= 0) {
                    throw new BalanceNotEnoughException("余额不足");
                } else {
                    //支付成功
                    Integer orderStatus = usersDao.updateOrderStatus(oid);
                    if (orderStatus > 0) {
                        //拿到订单中的地址 以及 支付的金额进行页面回显
                        User_address userAddress = usersDao.queryAddressByUaId(order.getUserAddress().getUaId());
                        return new PayExecution(order.getMoney(), userAddress, "支付成功");
                    }
                }
            }
        } catch (UnderStockException e) {
            throw e;
        } catch (BalanceNotEnoughException b) {
            throw b;
        } catch (Exception e) {
            throw new PayException("内部错误");
        }
        return null;
    }


    @Override
    public Order queryOrderInfoByOid(long oid) {
        return usersDao.queryOrderInfoByOid(oid);
    }

    @Transactional
    @Override
    public boolean updateDefaultAddress(long uid, long uaid) {
        usersDao.updateUnDefaultAddress(uid);
        if (usersDao.updateDefaultAddress(uaid) > 0) {
            return true;
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
