package grpc.ca.clientGUI;

import grpc.ca.loginService.StaffClient;
import grpc.ca.mail.MailClient;
import grpc.ca.order.OrderClient;
import grpc.ca.order.OrderServer;
import grpc.ca.server1.JMDNS.JmdnsDiscovery;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import javax.jmdns.ServiceInfo;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Client{

    private JTextField entry1, reply1;
    private JTextField entry2, reply2;
    private JTextField entry3, reply3;
    private JmdnsDiscovery discovery;

    public Client() {
        this.discovery = new JmdnsDiscovery();
    }

    public static void main(String[] args) {

        Client gui = new Client();

        gui.build();
    }

    private void build() {

        JFrame frame = new JFrame("Service Controller Sample");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the panel to add buttons
        JPanel panel = new JPanel();

        // Set the BoxLayout to be X_AXIS: from left to right
        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);

        panel.setLayout(boxlayout);

        // Set border for the panel
        panel.setBorder(new EmptyBorder(new Insets(50, 100, 50, 100)));

        panel.add( getService1JPanel() );
        panel.add( getService2JPanel() );
        panel.add( getService3JPanel() );

        // Set size for the frame
        frame.setSize(800, 700);

        // Set the window to be visible as the default to be false
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    private JPanel getService1JPanel() {

        JPanel panel = new JPanel();

        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

        JLabel label = new JLabel("Enter value")	;
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        entry1 = new JTextField("",10);
        panel.add(entry1);

        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        JButton button = new JButton("login");
        button.addActionListener((event) -> {
            System.out.println("login invoked ...");
            ServiceInfo staffServer = discovery.getService("staffServer");

            if (staffServer == null) {
                reply1.setText("Service not started");
                return;
            }
            StaffClient staffClient = new StaffClient(staffServer.getHostAddresses()[0], staffServer.getPort());
            String text = entry1.getText();
            if (text == null || text.trim().equals("")) {
                reply1.setText("please input value");
            } else {
                String[] split = text.split(",");
                String response = staffClient.login(split[0], split[1]);
                reply1.setText(response);
            }
        });
        panel.add(button);

        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        JButton button2 = new JButton("stampIn");
        button2.addActionListener((event) -> {
            System.out.println("stampIn to be invoked ...");
            ServiceInfo staffServer = discovery.getService("staffServer");

            if (staffServer == null) {
                reply1.setText("Service not started");
                return;
            }
            StaffClient staffClient = new StaffClient(staffServer.getHostAddresses()[0], staffServer.getPort());
            String text = entry1.getText();
            if (text == null || text.trim().equals("")) {
                reply1.setText("please input value");
            } else {
                String response = staffClient.stampIn(text);
                reply1.setText(response);
            }
        });
        panel.add(button2);

        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        JButton button3 = new JButton("stampOut");
        button3.addActionListener((event) -> {
            System.out.println("stampOut to be invoked ...");
            ServiceInfo staffServer = discovery.getService("staffServer");

            if (staffServer == null) {
                reply1.setText("Service not started");
                return;
            }
            StaffClient staffClient = new StaffClient(staffServer.getHostAddresses()[0], staffServer.getPort());
            String text = entry1.getText();
            if (text == null || text.trim().equals("")) {
                reply1.setText("please input value");
            } else {
                String response = staffClient.stampOut(text);
                reply1.setText(response);
            }
        });
        panel.add(button3);

        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        reply1 = new JTextField("", 10);
        reply1 .setEditable(false);
        panel.add(reply1);

        panel.setLayout(boxlayout);

        return panel;

    }

    private JPanel getService2JPanel() {

        JPanel panel = new JPanel();

        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

        JLabel label = new JLabel("Enter value")	;
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        entry2 = new JTextField("",10);
        panel.add(entry2);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        JButton button = new JButton("queryAgenda");
        button.addActionListener((event) -> {
            ServiceInfo mailServer = discovery.getService("mailServer");

            if (mailServer == null) {
                reply2.setText("Service not started");
                return;
            }

            String text = entry2.getText();
            if (text == null || text.trim().equals("")) {
                reply2.setText("please input username");
                return;
            }
            MailClient mailClient = new MailClient(mailServer.getHostAddresses()[0], mailServer.getPort());
            try {
                String s = mailClient.staffAgenda(text);
                reply2.setText(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        panel.add(button);

        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        JButton button2 = new JButton("query mail");
        button2.addActionListener((event) -> {
            ServiceInfo mailServer = discovery.getService("mailServer");

            if (mailServer == null) {
                reply2.setText("Service not started");
                return;
            }

            String text = entry2.getText();
            if (text == null || text.trim().equals("")) {
                reply2.setText("please input username");
                return;
            }
            MailClient mailClient = new MailClient(mailServer.getHostAddresses()[0], mailServer.getPort());
            String s = mailClient.staffMail(text);
            reply2.setText(s);
        });

        panel.add(button2);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        reply2 = new JTextField("", 10);
        reply2 .setEditable(false);
        panel.add(reply2);

        panel.setLayout(boxlayout);

        return panel;

    }

    private JPanel getService3JPanel() {

        JPanel panel = new JPanel();

        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

        JLabel label = new JLabel("Enter value")	;
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        entry3 = new JTextField("",10);
        panel.add(entry3);

        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        JButton button = new JButton("queryOrder");
        button.addActionListener((event) -> {
            ServiceInfo orderServer = discovery.getService("orderServer");

            if (orderServer == null) {
                reply3.setText("Service not started");
                return;
            }
            OrderClient orderClient = new OrderClient(orderServer.getHostAddresses()[0], orderServer.getPort());
            String response = orderClient.queryOrders();
            reply3.setText(response);
        });
        panel.add(button);

        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        JButton button2 = new JButton("updateOrder");
        button2.addActionListener((event) -> {
            System.out.println("service order to be invoked ...");
            ServiceInfo orderServer = discovery.getService("orderServer");

            if (orderServer == null) {
                reply3.setText("Service not started");
                return;
            }
            OrderClient orderClient = new OrderClient(orderServer.getHostAddresses()[0], orderServer.getPort());
            String text = entry3.getText();
            if (entry3.getText() == null || entry3.getText().trim().equals("")) {
                reply3.setText("please input value");
            } else {
                String[] split = text.split(",");
                int[] ids = new int[split.length];
                float[] prices = new float[split.length];

                for (int i = 0; i < split.length; i++) {
                    String[] order = split[i].split(":");
                    ids[i] = Integer.parseInt(order[0]);
                    prices[i] = Float.parseFloat(order[1]);
                }
                try {
                    orderClient.updateOrder(ids, prices);
                    reply1.setText("update success");
                } catch (InterruptedException e) {
                    reply1.setText(e.getMessage());
                }
            }
        });
        panel.add(button2);

        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        reply3 = new JTextField("", 10);
        reply3 .setEditable(false);
        panel.add(reply3);

        panel.setLayout(boxlayout);

        return panel;

    }

}
