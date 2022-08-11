/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Map;
import org.apache.kafka.common.serialization.Deserializer;


/**
 *
 * @author ddmm8625
 */
public class MessageDeserializer implements Deserializer {

    @Override
    public void close() {
    }

    @Override
    public Message deserialize(String arg0, byte[] arg1) {
        ObjectMapper mapper = new ObjectMapper();
        Message message = null;
        try {
            message = mapper.readValue(arg1, Message.class);
        } catch (IOException e) {
        }
        return message;
    }

    @Override
    public void configure(Map map, boolean bln) {

    }

}
