package grpc.ca.server1.JMDNS;

		
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import java.io.IOException;
import java.net.InetAddress;

public class JmdnsDiscovery {

    private JmDNS dns;
    // set service type
    private String serviceType = "_grpc._tcp.local";

    public JmdnsDiscovery() {
        try {
            this.dns = JmDNS.create(InetAddress.getLoopbackAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class MyServiceListener implements ServiceListener{

        private JmDNS dns;

        public MyServiceListener(JmDNS dns) {
            this.dns = dns;
        }

        @Override
        public void serviceAdded(ServiceEvent event) {
            // TODO Auto-generated method stub
            try {
                dns.registerService(event.getInfo());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void serviceRemoved(ServiceEvent event) {
            // TODO Auto-generated method stub
            dns.unregisterService(event.getInfo());
        }

        @Override
        public void serviceResolved(ServiceEvent event) {
            // TODO Auto-generated method stub
            System.out.println("....");
        }
    }

    // registry listener
    public void run() {
        // add listener
        dns.addServiceListener(serviceType, new MyServiceListener(dns));
    }

    public ServiceInfo getService(String serviceName) {
        return dns.getServiceInfo(serviceType, serviceName);
    }
}