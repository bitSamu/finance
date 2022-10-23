/**
 * THIS CLASS IS NEEDED TO GET THE IP ADDRESS OF THE HOST
 */

package Server;

import java.net.Inet4Address;
import java.net.UnknownHostException;

public class IP {
    private String IP_Address = "";
    public IP(){}

    public String get_IP_Address() throws UnknownHostException {
        System.out.println(Inet4Address.getLocalHost().getHostAddress());
        return Inet4Address.getLocalHost().getHostAddress();
    }
}
