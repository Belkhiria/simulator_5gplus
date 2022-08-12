/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SRAN;

import java.util.ArrayList;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import utils.Message;

/**
 *
 * @author ddmm8625
 */
public class Initialisation extends Thread {

    Producer producer;

    public Initialisation(Producer producer) {
        this.producer = producer;
    }

    public void init() {
        ProducerRecord<String, Message> rec = new ProducerRecord<>("dcdb",
                new Message("sran", "dcdb", "handover_required", new ArrayList<>()));

        producer.send(rec);
        producer.flush();
        //producer.close();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
        }

        init();

    }

}
