/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.List;

/**
 *
 * @author ddmm8625
 */
public class Message {

    private String from;
    private String to;
    private String type;
    private List<String> value;

    public Message() {
    }

    public Message(String from, String to, String type, List<String> value) {
        this.from = from;
        this.to = to;
        this.type = type;
        this.value = value;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getValue() {
        return value;
    }

    public void setValue(List<String> value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Message{" + "from=" + from + ", to=" + to + ", type=" + type + ", value=" + value + '}';
    }

}
