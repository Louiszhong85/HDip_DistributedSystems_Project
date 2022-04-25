package grpc.ca.server1.JMDNS;

		
import java.io.IOException;
import java.net.InetAddress;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;

public class JmdnsDiscovery {

    private JmDNS dns;
    // set service type
    private String serviceType = "_grpc._tcp.local";

    public JmdnsDiscovery() {
        try {
            this.dns = JmDNS.create(InetAddress.getLocalHost());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class MyServiceListener implements ServiceListener{

        @Override
        public void serviceAdded(ServiceEvent event) {
            // TODO Auto-generated method stub
        }

        @Override
        public void serviceRemoved(ServiceEvent event) {
            // TODO Auto-generated method stub
        }

        @Override
        public void serviceResolved(ServiceEvent event) {
            // TODO Auto-generated method stub
        }
    }

    // registry listener
    public void run() {
        // add listener
        dns.addServiceListener(serviceType, new MyServiceListener());
    }

    public ServiceInfo getService(String serviceName) {
        return dns.getServiceInfo(serviceType, serviceName);
    }
}