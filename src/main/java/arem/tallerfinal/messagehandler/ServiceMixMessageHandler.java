/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arem.tallerfinal.messagehandler;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 *
 * @author 2122825
 */
public class ServiceMixMessageHandler {

    private static StringBuilder MESSAGES = new StringBuilder();

    public static void main(String[] args) throws JMSException {
        ServiceMixMessageHandler.run();
    }

    public static void run() throws JMSException {
        // Create a ConnectionFactory
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://34.214.141.194:61616?jms.useAsyncSend=true");

        // Create a Connection
        Connection connection = connectionFactory.createConnection("smx", "smx");
        connection.start();

        // Create a Session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // Create the destination (Topic or Queue)
        Destination destination = session.createQueue("salida");

        // Create a MessageConsumer from the Session to the Topic or Queue
        MessageConsumer consumer = session.createConsumer(destination);

        // Wait for a message
        Message message = consumer.receive(1000);

        MESSAGES = new StringBuilder();

        if (message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;
            String text = textMessage.getText();
            MESSAGES.append(text);
            System.out.println("Received: " + text);
        } else {
            System.out.println("Received: " + message);
        }

        consumer.close();
        session.close();
        connection.close();
    }

    public static String getMessage() {
        String msg = MESSAGES.toString();
        return msg.isEmpty() ? "No message found" : msg;
    }
}
