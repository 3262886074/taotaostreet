package com.tts.service.impl;

import com.tts.bean.*;
import com.tts.dao.Shopping_CartDao;
import com.tts.service.Shopping_CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

@Service("shopping_CartService")
public class Shopping_CartServiceImpl implements Shopping_CartService {

    @Autowired
    private Shopping_CartDao shopping_cartDao;

    // 查询 购物车 表 数据
    @Override
    public Shopping_Cart getShopping_Cart(long scId) {
        Shopping_Cart shopping_Carts = shopping_cartDao.getShopping_CartByscId(scId);
        HashSet<Commodity_items> commodity_items = shopping_cartDao.getCommodity_items(scId);
        shopping_Carts.setCommodityItems(commodity_items);
        return shopping_Carts;
    }

    // 通过用户ID添加购物车，或查询
    @Override
    public Shopping_Cart addShopping_Cart(long uid) {

        if (shopping_cartDao.getShopping_Cart(uid) == null) {

            Integer add = shopping_cartDao.addShopping_Cart(uid);
        }
        return shopping_cartDao.getShopping_Cart(uid);

    }

    //添加购物车并查询
    @Override
    public Shopping_Cart addShopping_CartSp(long uid) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date now = new Date();
        String hehe = dateFormat.format(now);

        Integer add = shopping_cartDao.addShopping_Cart(uid);

        return shopping_cartDao.getShopping_CartSp(uid, hehe);
    }

    // 通过商品条目Id 删除商品条目表的商品
    @Override
    public Integer deleteCommodity_items(long ciId) {

        return shopping_cartDao.deleteCommodity_items(ciId);
    }

    // 添加商品到商品条目表 num ct cc c sc

    @Override
    public Integer addCommodity_items(long cid, long ct_id, long ccid, Integer number, long scId) {
        return shopping_cartDao.addCommodity_items(cid, ct_id, ccid, number, scId);
    }

    // 添加订单
    @Override
    public Integer addOrder(Order order) {

        return shopping_cartDao.addOrder(order);
    }

    // 查询订单
    @Override
    public Order getOders(long oid) {
        Order order = shopping_cartDao.getOrder(oid);
        System.out.println(order);
        long scId = order.getShoppingCart().getScId();
        Shopping_Cart shoppingCart = shopping_cartDao.getShopping_CartByscId(scId);

        order.setShoppingCart(shoppingCart);
        return order;
    }

    // 根据scid购物车ID 查询商品条目表内的商品
    @Override
    public HashSet<Commodity_items> getCommodity_items(long scId) {

        return shopping_cartDao.getCommodity_items(scId);
    }

    // 修改订单表订单状态
    @Override
    public Integer updateOrder(Order order, long uid) {
        User_Account userAccount = shopping_cartDao.getUserAccount(uid);
        if (userAccount.getUaMoney() < order.getMoney()) {
            order.setStatus(-1);
            return shopping_cartDao.updateOrder(order);
        }
        shopping_cartDao.updateuaMoney(userAccount.getUaId(), order.getMoney());
        shopping_cartDao.updateDcst(order.getDiscountCoupon().getDcId());
        shopping_cartDao.updateUrpst(order.getUserRedPackage().getUrpId());
        return shopping_cartDao.updateOrder(order);
    }

    // 通过时间和用户ID获取刚添加的订单
    @Override
    public long getOid(long uid, String now) {

        return shopping_cartDao.getOid(uid, now);
    }

    //修改商品条目表的商品数量
    @Override
    public Integer updateShoppingCart(Commodity_items commodity_items) {

        long ciId = commodity_items.getCiId();
        Integer number = commodity_items.getNumber();
        Integer ups = shopping_cartDao.updateCommodity_items(ciId, number);

        return ups;
    }


    //修改购物车用户ID
    @Override
    public Integer updateShopping_CartUid(long scId) {

        return shopping_cartDao.updateShopping_CartUid(scId);
    }

    //添加商品到收藏夹
    @Override
    public Integer addUser_Collect(long cid, long uid) {

        return shopping_cartDao.addUser_Collect(cid, uid);
    }

    //立即购买添加订单
    @Override
    public Integer addOrderSp(long scId, long uid) {

        return shopping_cartDao.addOrderSp(scId, uid);
    }

    //查询用户默认的地址
    @Override
    public User_address getUser_address(long uid) {
        // TODO Auto-generated method stub
        return shopping_cartDao.getUser_address(uid);
    }

    //查询订单 带地址
    @Override
    public Order getOder(long oid) {
        Order order = shopping_cartDao.getOrderUa(oid);
        System.out.println(order);
        long scId = order.getShoppingCart().getScId();
        Shopping_Cart shoppingCart = shopping_cartDao.getShopping_CartByscId(scId);

        order.setShoppingCart(shoppingCart);
        return order;
    }


}
