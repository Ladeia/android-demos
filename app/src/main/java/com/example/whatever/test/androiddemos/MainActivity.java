package com.example.whatever.test.androiddemos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView txv_network;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txv_network = (TextView) findViewById(R.id.info1);

        getNetworkInformations();
    }

    public void getNetworkInformations() {
        String networkvalues = new String();
        try {
            List<NetworkInterface> interfaces = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface intf : interfaces) {
                List<InetAddress> addrs = Collections.list(intf.getInetAddresses());
                byte[] mac = intf.getHardwareAddress();

                if(mac != null) {
                    StringBuilder buf = new StringBuilder();
                    for (int i=0; i<mac.length; i++)
                        buf.append(String.format("%02X:", mac[i]));
                    if (buf.length()>0){
                        buf.deleteCharAt(buf.length()-1);
                    }
                    //String buf = new String(mac);
                    networkvalues += "\n" + intf.getName() + " MAC: " + buf.toString() + "\n";
                }

                for (InetAddress addr : addrs) {

                    if (!addr.isLoopbackAddress()) {
                        String sAddr = addr.getHostAddress();
                        networkvalues += sAddr + "\n";

                        boolean isIPv4 = sAddr.indexOf(':')<0;

                    }
                }
            }
        } catch (SocketException ex) {
            ex.printStackTrace();
        }
        txv_network.setText(networkvalues);
    }
}
