package com.compdevbooks.business.product;

import com.compdevbooks.business.ABusiness;
import com.compdevbooks.dao.IDAO;
import com.compdevbooks.entity.IEntity;
import com.compdevbooks.entity.product.LotStock;
import com.compdevbooks.entity.product.Product;
import com.compdevbooks.entity.purchase.Purchase;
import com.compdevbooks.entity.purchase.PurchaseStatus;
import com.compdevbooks.util.RegularExpressions;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

public class LotStockBusiness extends ABusiness {
    
    public LotStockBusiness(IDAO dao) {
        super(dao);
    }

    @Override
    public Exception validate(IEntity entity) {
        LotStock lotStock = (LotStock) entity;
        StringBuilder str = new StringBuilder();

        try {
            String msg = RegularExpressions.validate("PRODUCT_NULL", String.valueOf(lotStock.getProduct()));
            str.append(msg==null?"":msg);

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (str.length()>0)
            return new Exception(str.toString());

        return null;
    }

    /*
        TODO: Deve registrar a atividade do gerente de estoque de registrar a entrada de quantidades e lotes dos produtos
     */
    public void checkReceipt(Purchase purchase) {
        purchase.setStatus(PurchaseStatus.RECEIVED);
        purchase.setReceivedDate(new Date());
        purchase.setProcessedDate(new Date());
    }
}
