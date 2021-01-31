/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.ai.maventransportappcommon.domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author stackOverflow
 */
public class Cost implements Serializable, IGeneralEntity{
    private CostType costType;
    private double amount;
    private Drive drive;

    public Cost(CostType costType, double amount, Drive drive) {
        this.costType = costType;
        this.amount = amount;
        this.drive = drive;
    }
    

    public Cost() {
    }

    public Cost(CostType costType, double amount) {
        this.costType = costType;
        this.amount = amount;
    }
    
    @Override
    public String getTableName() {
        return "cost";
    }

    @Override
    public List<IGeneralEntity> getList(ResultSet resultSet) throws Exception {
        List<IGeneralEntity> list = new ArrayList<>();
        
        
        while (resultSet.next()) {
            Drive dr = new Drive();
            CostType ct = CostType.valueOf(resultSet.getString("costtype"));
            dr.setId(resultSet.getInt("voznja"));
            list.add(new Cost(ct, resultSet.getDouble("amount"), dr));
        }
        return list;
    }

    @Override
    public String getValues() {
        return "'" + drive.getId() + "'" + ", '" + costType+ "', '" + amount + "'";
    }

    @Override
    public String getAttributes() {
        return "voznja, costtype, amount";
    }

    @Override
    public String setAttributes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getDeleteCondition() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getUpdateCondition() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSelectContidion() {
        return "voznja = '" + drive.getId() + "'";
    }

    public CostType getCostType() {
        return costType;
    }

    public void setCostType(CostType costType) {
        this.costType = costType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Drive getDrive() {
        return drive;
    }

    public void setDrive(Drive drive) {
        this.drive = drive;
    }
    
}
