package grpc.ca.server3.JMDNS;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.IOException;
import java.net.InetAddress;

public class JmdnsRegistration {

    private JmDNS dns;
    private String serviceType = "_grpc._tcp.local";

    public JmdnsRegistration() {
        try {
            this.dns = JmDNS.create(InetAddress.getLocalHost());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // register the service
    public void run(int servicePort, String serviceName) {
        try {
            // create ServiceInfo
            ServiceInfo serviceInfo = ServiceInfo.create(serviceType, serviceName, servicePort, "");
            // register the service
            dns.registerService(serviceInfo);

            System.out.printf("registering service with type: %s and name: %s on port %d ", serviceType, serviceName, servicePort);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}