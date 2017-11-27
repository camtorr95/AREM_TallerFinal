/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arem.tallerfinal.controller;

import arem.tallerfinal.messagehandler.ServiceMixMessageHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.JMSException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rami
 */
@RestController
public class Controller {

    @RequestMapping(value = "/messages", method = RequestMethod.GET)
    public ResponseEntity<?> getMessage() {
        try {
            ServiceMixMessageHandler.run();
            return new ResponseEntity<>(ServiceMixMessageHandler.getMessage(), HttpStatus.OK);
        } catch (JMSException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
}
