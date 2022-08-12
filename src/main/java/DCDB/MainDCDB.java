/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DCDB;

import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import utils.JsonPOJOSerializer;

/**
 *
 * @author ddmm8625
 */
public class MainDCDB {

    public static void main(String[] args) {
        Protocol protocol = new Protocol();
        Properties prop = new Properties();
        prop.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        prop.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        prop.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonPOJOSerializer.class.getName());
        prop.put(ProducerConfig.ACKS_CONFIG, "0");
        Producer producer = new KafkaProducer<>(prop);

        ConsumerThread consumer = new ConsumerThread(protocol, producer);
        consumer.start();

    }
}
