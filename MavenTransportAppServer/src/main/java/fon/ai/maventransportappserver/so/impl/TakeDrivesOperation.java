/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.ai.maventransportappserver.so.impl;

import fon.ai.maventransportappcommon.domain.Drive;
import fon.ai.maventransportappcommon.domain.IGeneralEntity;
import java.util.List;
import fon.ai.maventransportappserver.so.AbstractGenericOperation;

/**
 *
 * @author Windows HD
 */
public class TakeDrivesOperation extends AbstractGenericOperation{
    private List<IGeneralEntity> lista;

    @Override
    protected void validate(Object entity) throws Exception {
        if(!(entity instanceof Drive)) {
            throw new Exception("Objekat nije validan");
        }
    }

    @Override
    protected void execute(Object entity) throws Exception {
        lista = db.vratiSve((IGeneralEntity) entity);
        if(lista.isEmpty()) {
            throw new Exception("Sistem ne moze da nadje vozila, prvo dodaj vozila pa onda voznju!");
        }
    }
    public List<IGeneralEntity> getLista() {
        return lista;
    }
    
}
