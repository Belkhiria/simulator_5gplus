/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.simulator_5gplus;

import java.util.Arrays;
import java.util.Properties;
import org.apache.kafka.clients.consumer.KafkaConsumer;

/**
 *
 * @author DDMM8625
 */
public class Simulator_5gplus {

    public static void main(String[] args) {
       Properties props = new Properties();
        props.put("bootstrap.servers", BOOTSTRAP_SERVERS);
        props.put("group.id", GROUP_ID);
        props.put("auto.offset.reset", AUTO_OFFSET_RESET);
        props.put("key.deserializer", KEY_DESERIALIZER);
        props.put("value.deserializer", VALUE_DESERIALIZER);

        final KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList(TOPIC));
        while (true) {
            consumer.poll(1000).spliterator().forEachRemaining(System.out::println);
        }
    }
    
    static final String BOOTSTRAP_SERVERS = "localhost:9092";
    static final String TOPIC = "quickstart-events";
    static final String AUTO_OFFSET_RESET = "earliest";
    static final String GROUP_ID = "group.id";
    static final String KEY_DESERIALIZER = "org.apache.kafka.common.serialization.StringDeserializer";
    static final String VALUE_DESERIALIZER = "org.apache.kafka.common.serialization.StringDeserializer";
}
