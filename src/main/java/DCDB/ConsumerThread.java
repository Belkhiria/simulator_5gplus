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
import utils.Message;

public class ConsumerThread extends Thread {

    private final Protocol protocol;
    Properties props = new Properties();
    KafkaConsumer<String, Message> consumer;
    Producer producer;

    public ConsumerThread(Protocol protocol, Producer producer) {

        this.protocol = protocol;
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "dcdb-1");
        props.put("value.deserializer", "utils.MessageDeserializer");
        //props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("auto.offset.reset", "latest");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList("dcdb"));
    }

    @Override
    public void run() {
        while (true) {
            ConsumerRecords<String, Message> records = consumer.poll(Duration.ofMillis(10));
            for (ConsumerRecord<String, Message> record : records) {
                //System.out.println(record.value().toString());
                protocol.onReceiptOf(record.value(), producer);
            }
        }
    }

}
