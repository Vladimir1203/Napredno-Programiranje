/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.ai.maventransportappserver.so.impl;

import fon.ai.maventransportappcommon.domain.IGeneralEntity;
import fon.ai.maventransportappcommon.domain.User;
import fon.ai.maventransportappserver.so.AbstractGenericOperation;

/**
 *
 * @author Windows HD
 */
public class LoginOperation extends AbstractGenericOperation {

    IGeneralEntity object;

    @Override
    protected void validate(Object entity) throws Exception {
        if(!(entity instanceof User)) {
            throw new Exception("Objekat nije validan");
        }
    }

    @Override
    protected void execute(Object entity) throws Exception {
        object = db.vratiPoId((IGeneralEntity)entity);
    }

    public IGeneralEntity getObject() {
        return object;
    }
    
}
