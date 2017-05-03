package com.tts.service.impl;

import com.tts.bean.*;
import com.tts.dao.ShoppingDao;
import com.tts.dao.UsersDao;
import com.tts.service.ShoppingService;
import com.tts.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * Created by joe on 17/4/27.
 */
@Service("shoppingService")
public class ShoppingServiceImpl implements ShoppingService {

    @Autowired
    private ShoppingDao shoppingDao;
    @Autowired
    private UsersDao usersDao;

    /**
     * 单纯的新建购物车
     */
    @Override
    public void addShopCart(long uid) {
        //先判断该用户是否有可用的购物车
        Set<Shopping_Cart> shoppingCarts = shoppingDao.queryShoppingCartsByUid(uid);
        //如果为空则新建购物车
        if (shoppingCarts.isEmpty() || shoppingCarts.size() <= 0) {
            shoppingDao.addShopCartByUid(uid);
        }
    }

    /**
     * 根据用户id查找用户可用状态的购物车的商品条目
     */
    @Transactional
    @Override
    public Set<Commodity_items> showItems(long uid) {
        //如果有则查出状态不为0的最大id
        long maxSCIdByUid = shoppingDao.queryMaxSCIdByUid(uid);
        Set<Commodity_items> commodityItems = usersDao.queryItemsByScid(maxSCIdByUid);
        return commodityItems;
    }

    /**
     * 删除购物车中的商品
     */
    @Override
    public String deleteByCid(long cid, long ciid) {
        if (shoppingDao.deleteByCid(cid, ciid) > 0) {
            return StringUtils.success;
        } else {
            return StringUtils.fail;
        }
    }

    /**
     * 将购物车中的商品添加到购物车
     */
    @Override
    public String addOneCollect(long cid, long uid) {
        if (shoppingDao.addOneCollect(cid, uid) > 0) {
            return StringUtils.success;
        } else {
            return StringUtils.fail;
        }
    }

    /**
     * 往购物车中添加商品
     */
    @Transactional
    @Override
    public String addItemsBySCId(long cid, long ctid, long ccid, Integer number, long scid) {
        //如果某个商品的id、套餐和类型都一样 则相同的商品数量相加
        Set<Commodity_items> commodityItems = usersDao.queryItemsByScid(scid);
        for (Commodity_items items : commodityItems) {
            if (items.getCommodity().getCid() == cid &&
                    items.getCommodityCombo().getCcid() == ccid &&
                    items.getCommodityType().getCtid() == ctid) {
                Integer integer = shoppingDao.updateComNumber(number, items.getCiId());
                if (integer > 0) {
                    return StringUtils.success;
                } else {
                    return StringUtils.fail;
                }
            }
        }
        Integer integer = shoppingDao.addItemsBySCId(cid, ctid, ccid, number, scid);
        if (integer > 0) {
            return StringUtils.success;
        } else {
            return StringUtils.fail;
        }
    }

    @Override
    public long getMaxOIdByUid(long uid) {
        return shoppingDao.getMaxOIdByUid(uid);
    }

    /**
     * 将购物车转化为订单 同时将该购物车设置为不可用状态
     */
    @Transactional
    @Override
    public String addOneOrder(long scid, double money, long dcid, long urpid, long uaid, long uid) {
        if (shoppingDao.addOneOrder(scid, money, dcid, urpid, uaid, uid) > 0) {
            //将此购物车设置为不可用状态
            shoppingDao.updateSCStatusBySCid(scid);
            return StringUtils.success;
        } else {
            return StringUtils.fail;
        }
    }

    @Override
    public Set<User_Red_package> queryRedPackageByUid(long uid) {
        return shoppingDao.queryRedPackageByUid(uid);
    }

    @Override
    public Set<Discount_coupon> queryDiscountCouponByUid(long uid) {
        return shoppingDao.queryDiscountCouponByUid(uid);
    }

    /**
     * 根据订单id查找订单信息
     */
    @Override
    public Order getOrderInfoByOid(long uid) {
        //获取该用户的最新的订单
        long maxOIdByUid = shoppingDao.getMaxOIdByUid(uid);
        Order order = usersDao.queryOrderInfoByOid(maxOIdByUid);
        return order;
    }

    /**
     * 根据用户id获取该用户最新的购物车id
     */
    @Override
    public long getMaxScidByUid(long uid) {
        //先判断该用户是否有可用的购物车
        Set<Shopping_Cart> shoppingCarts = shoppingDao.queryShoppingCartsByUid(uid);
        if (!shoppingCarts.isEmpty() && shoppingCarts.size() > 0) {
            long maxSCIdByUid = shoppingDao.queryMaxSCIdByUid(uid);
            return maxSCIdByUid;
        }
        return 0;
    }
}
