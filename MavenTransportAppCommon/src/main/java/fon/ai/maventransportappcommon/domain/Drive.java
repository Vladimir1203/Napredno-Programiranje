/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.ai.maventransportappcommon.domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author stackOverflow
 */
public class Drive implements Serializable, IGeneralEntity{
    private int id;
    private Costs cost;
    private Date date;
    private double facturePrice;
    private Trailer tr;
    private Truck t;
    private Driver d;
    private ArrayList<Cost> costs;
    
    public Drive() {
    }

    public Drive(Costs cost, Date date, double facturePrice, Trailer tr, Truck t, Driver d, ArrayList<Cost> costs) {
        this.cost = cost;
        this.date = date;
        this.facturePrice = facturePrice;
        this.tr = tr;
        this.t = t;
        this.d = d;
        this.costs = costs;
    }

    public Drive(Date date, double facturePrice, Trailer tr, Truck t, Driver d, ArrayList<Cost> costs) {
        this.date = date;
        this.facturePrice = facturePrice;
        this.tr = tr;
        this.t = t;
        this.d = d;
        this.costs = costs;
    }

    public Drive(int id, Date date, double facturePrice, Trailer tr, Truck t, Driver d, ArrayList<Cost> costs) {
        this.id = id;
        this.date = date;
        this.facturePrice = facturePrice;
        this.tr = tr;
        this.t = t;
        this.d = d;
        this.costs = costs;
    }
    

    public Drive(int id, Costs cost, Date date, double facturePrice, Trailer tr, Truck t, Driver d, ArrayList<Cost> costs) {
        this.id = id;
        this.cost = cost;
        this.date = date;
        this.facturePrice = facturePrice;
        this.tr = tr;
        this.t = t;
        this.d = d;
        this.costs = costs;
    }
    

    public Drive(int id, Date date, double facturePrice, Trailer tr, Truck t, Driver d) {
        this.id = id;
        this.date = date;
        this.facturePrice = facturePrice;
        this.tr = tr;
        this.t = t;
        this.d = d;
    }

    
    
    public Drive(int id, Costs cost, Date date, double facturePrice, Trailer tr, Truck t, Driver d) {
        this.id = id;
        this.cost = cost;
        this.date = date;
        this.facturePrice = facturePrice;
        this.tr = tr;
        this.t = t;
        this.d = d;
    }
    

    public Drive(Costs cost, Date date, double facturePrice, Trailer tr, Truck t, Driver d) {
        this.cost = cost;
        this.date = date;
        this.facturePrice = facturePrice;
        this.tr = tr;
        this.t = t;
        this.d = d;
    }

    public Driver getD() {
        return d;
    }

    public void setD(Driver d) {
        this.d = d;
    }

    public Costs getCost() {
        return cost;
    }

    public void setCost(Costs cost) {
        this.cost = cost;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getFacturePrice() {
        return facturePrice;
    }

    public void setFacturePrice(double facturePrice) {
        this.facturePrice = facturePrice;
    }

    public Trailer getTr() {
        return tr;
    }

    public void setTr(Trailer tr) {
        this.tr = tr;
    }

    public Truck getT() {
        return t;
    }
    
    

    public void setT(Truck t) {
        this.t = t;
    }

    @Override
    public String getTableName() {
        return "drive";
    }

    @Override
    public List<IGeneralEntity> getList(ResultSet resultSet) throws Exception {
        List<IGeneralEntity> list = new ArrayList<>();
        while (resultSet.next()) {
            double facturePrice = resultSet.getDouble("factureprice");
            Truck truck = new Truck();
            truck.setRegistrationMark(resultSet.getString("truck"));
            Trailer trailer = new Trailer();
            trailer.setRegistrationMark(resultSet.getString("trailer"));
            java.sql.Date datumsql = resultSet.getDate("date");
            Driver driver = new Driver();
            driver.setIDCard(resultSet.getInt("driver"));
            list.add(new Drive(resultSet.getInt("id"), datumsql, facturePrice, trailer, truck, driver));
        }
        return list;
    }    

    @Override
    public String getValues() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        sdf.format(date);
        Date date11 = new java.sql.Date(date.getTime());
        return "'" + id + "', '" + date11 + "'" + ", '" + facturePrice + "','" + t.getRegistrationMark() + "','" + tr.getRegistrationMark() + "', '" + d.getIDCard() + "'";
    }

    @Override
    public String getAttributes() {
         return "id, date, factureprice, truck, trailer, driver";
    }

    @Override
    public String setAttributes() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        sdf.format(date);
        Date d = new java.sql.Date(date.getTime());
        System.out.println(d);
        return "id=" + getId()
                + ", date='" + d
                + "', factureprice='" + getFacturePrice()
                + "', truck='" + getT().getRegistrationMark()
                + "', trailer='" + getTr().getRegistrationMark() + "'";
    }

    @Override
    public String getDeleteCondition() {
        return "id=" + getId();
    }

    @Override
    public String getUpdateCondition() {
        return "id = '" + getId() + "'";
    }

    @Override
    public String getSelectContidion() {
         return "id = '" + getId() + "'";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Cost> getCosts() {
        return costs;
    }

    public void setCosts(ArrayList<Cost> costs) {
        this.costs = costs;
    }

    @Override
    public String toString() {
        return id +"";
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Drive other = (Drive) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.facturePrice) != Double.doubleToLongBits(other.facturePrice)) {
            return false;
        }
        if (!Objects.equals(this.cost, other.cost)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.tr, other.tr)) {
            return false;
        }
        if (!Objects.equals(this.t, other.t)) {
            return false;
        }
        if (!Objects.equals(this.d, other.d)) {
            return false;
        }
        if (!Objects.equals(this.costs, other.costs)) {
            return false;
        }
        return true;
    }


    
    
    
}
