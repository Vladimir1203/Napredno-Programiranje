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
public class Trailer extends Vehicle implements Serializable, IGeneralEntity{
    private VehicleType vt;
    private double loadCapacity;

    public Trailer() {
        
    }

    public Trailer(VehicleType vt, double loadCapacity) {
        this.vt = vt;
        this.loadCapacity = loadCapacity;
    }

    public Trailer(VehicleType vt, double loadCapacity, String brand, int productYear, String registrationMark, double weight, String oznakaVozila) {
        super(brand, productYear, registrationMark, weight, oznakaVozila);
        this.vt = vt;
        this.loadCapacity = loadCapacity;
    }

    

    public VehicleType getVt() {
        return vt;
    }

    public void setVt(VehicleType vt) {
        this.vt = vt;
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    @Override
    public String getTableName() {
        return "vehicle";
    }
    
    @Override
    public String getAttributes() {
        return "loadcapacity, brand, productYear, registrationMark, weight, vehicletype, oznakavozila";
    }
    
    @Override
    public String getValues() {
         return "'"+loadCapacity + "'"  + ", '" + brand + "', '"+ productYear + "', '" + registrationMark + "', '" + weight + "'" + ",'" + vt.toString() + "'" + ",'"+"P'";
    }

    @Override
    public List<IGeneralEntity> getList(ResultSet resultSet) throws Exception {
        List<IGeneralEntity> list = new ArrayList<>();
        while (resultSet.next()) {
            String oznakaVozila = resultSet.getString("oznakavozila");
            if(oznakaVozila.equals("P")){
                int productYear = resultSet.getInt("productYear");
                String registrationMark = resultSet.getString("registrationMark");
                String brand = resultSet.getString("brand");
                double weight = resultSet.getDouble("weight");
                String vehicleType = resultSet.getString("vehicletype");
                double loadCapacity = resultSet.getDouble("loadcapacity");
                VehicleType vt = VehicleType.valueOf(vehicleType);
                list.add(new Trailer(vt, loadCapacity, brand, productYear, registrationMark, weight, oznakaVozila));
            }
        }        
        return list;
    }    

}
