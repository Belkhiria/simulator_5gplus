/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DCDB;

import DCDB.MainDCDB;
import org.apache.kafka.clients.producer.Producer;
import utils.Message;

/**
 *
 * @author ddmm8625
 */
public class Protocol {

    public void onReceiptOf(Message value, Producer producer) {
        //throw new UnsupportedOperationException("Not supported yet."); 
        System.out.println(value.toString());
    }

}
