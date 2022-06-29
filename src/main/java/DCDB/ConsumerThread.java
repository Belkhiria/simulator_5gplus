/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DCDB;

/**
 *
 * @author ddmm8625
 */

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.Producer;



public class ConsumerThread extends Thread {

    private final MainDCDB dcdb;
    private final Producer producer;
    private final Protocol protocol;
    Properties props = new Properties();
    KafkaConsumer<String, String> consumer;

    public ConsumerThread(MainDCDB dcdb, Producer producer, Protocol protocol) {
        
        this.dcdb = dcdb;
        this.producer = producer;
        this.protocol = protocol;
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "consumer_dcdb");
        props.put("value.deserializer", "myapps.MessageGMEDeserializer");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("auto.offset.reset", "earliest");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("max.poll.records", "1");
        consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList("consumer_dcdb"));
    }
    
    @Override
    public void run() {
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(10));
            for (ConsumerRecord<String, String> record : records) {
                //System.err.println(record.value().toString());
                protocol.onReceiptOf(record.value(), dcdb, producer);
            }
        }
    }


}
