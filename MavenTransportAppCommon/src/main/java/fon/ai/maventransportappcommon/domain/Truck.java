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
public class Truck extends Vehicle implements Serializable, IGeneralEntity{
    private String transmission;

    public Truck() {
    }

    public Truck(String transmission, String brand, int productYear, String registrationMark, double weight, String oznakaVozila) {
        super(brand, productYear, registrationMark, weight, oznakaVozila);
        this.transmission = transmission;
    }

    
    

    public Truck(String transmission) {
        this.transmission = transmission;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    @Override
    public String getSelectContidion() {
        return "registrationMark='" + getRegistrationMark() +"'";
    }

    @Override
    public String getTableName() {
        return "vehicle";
    }

    @Override
    public String getAttributes() {
        return "transmission, brand, productYear, registrationMark, weight, oznakavozila";
    }
    
    @Override
    public String getValues() {
         return "'"+transmission + "'"  + ", '" + brand + "', '"+ productYear + "', '" + registrationMark + "', '" + weight + "'"  + ",'"+"K'";
    }

    @Override
    public List<IGeneralEntity> getList(ResultSet resultSet) throws Exception {
        List<IGeneralEntity> list = new ArrayList<>();
        while (resultSet.next()) {
            String oznakaVozila = resultSet.getString("oznakavozila");
            if(oznakaVozila.equals("K")){
                int productYear = resultSet.getInt("productYear");
                String registrationMark = resultSet.getString("registrationMark");
                String brand = resultSet.getString("brand");
                double weight = resultSet.getDouble("weight");
                String transmission = resultSet.getString("transmission");
                list.add(new Truck(transmission, brand, productYear, registrationMark, weight, oznakaVozila));
            }
        }
        return list;
    }    
    
}
