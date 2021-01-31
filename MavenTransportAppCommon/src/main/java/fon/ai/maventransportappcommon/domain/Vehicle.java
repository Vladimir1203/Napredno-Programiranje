package fon.ai.maventransportappcommon.domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author stackOverflow
 */

public class Vehicle implements Serializable, IGeneralEntity{
    
    protected String brand;
    protected int productYear;
    protected String registrationMark;
    protected double weight;
    protected String oznakaVozila;

    public Vehicle(String brand, int productYear, String registrationMark, double weight, String oznakaVozila) {
        this.brand = brand;
        this.productYear = productYear;
        this.registrationMark = registrationMark;
        this.weight = weight;
        this.oznakaVozila = oznakaVozila;
    }
    
    

    public Vehicle(String brand, int productYear, String registrationMark, double weight) {
        this.brand = brand;
        this.productYear = productYear;
        this.registrationMark = registrationMark;
        this.weight = weight;
    }

    public Vehicle() {
    }

   

    @Override
    public String getTableName() {
        return "vehicle";
    }

    @Override
    public List<IGeneralEntity> getList(ResultSet resultSet) throws Exception {
        List<IGeneralEntity> list = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("idcard");
            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");
            
            //list.add(new Driver(IDCard,name,surname));
        }
        return list;
    }

    @Override
    public String getValues() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getAttributes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getProductYear() {
        return productYear;
    }

    public void setProductYear(int productYear) {
        this.productYear = productYear;
    }

    public String getRegistrationMark() {
        return registrationMark;
    }

    public void setRegistrationMark(String registrationMark) {
        this.registrationMark = registrationMark;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return brand + " - " + productYear;
    }

    public String getOznakaVozila() {
        return oznakaVozila;
    }

    public void setOznakaVozila(String oznakaVozila) {
        this.oznakaVozila = oznakaVozila;
    }
    
    
    
}
