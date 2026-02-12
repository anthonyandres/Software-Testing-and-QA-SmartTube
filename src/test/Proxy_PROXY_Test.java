package test;
import static org.junit.Assert.*;
import org.junit.Test;

//import java.net.Proxy.Type;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.InetSocketAddress;

import main.ProxyPROXY;
import main.ProxyPROXY.Type;
import main.PasswdInetSocketAddress;
public class Proxy_PROXY_Test {
	
	@Test(expected = IllegalArgumentException.class)
	public void proxy_INVALID_TYPE_Test() {
		int port = 5500;
		String hostname = "hostname";
		String username = "username";
		String password = "password";
		PasswdInetSocketAddress PISA = new PasswdInetSocketAddress(hostname, port, username, password); 
		Type type = Type.DIRECT;//will throw exception
		ProxyPROXY proxy = new ProxyPROXY();
		proxy.Proxy(type, PISA);
		SocketAddress result = proxy.address();
		SocketAddress expected = PISA;
		assertEquals(expected, result);
	}
	
	@Test
	public void proxy_VALID_TYPE_Test() {
		 //Proxy proxy = new Proxy();
		int port = 5500;
		String hostname = "hostname";
		String username = "username";
		String password = "password";
		PasswdInetSocketAddress PISA = new PasswdInetSocketAddress(hostname, port, username, password); 
		Type type = Type.HTTP;
		ProxyPROXY proxy = new ProxyPROXY();
		proxy.Proxy(type, PISA);
		SocketAddress result = proxy.address();
		SocketAddress expected = PISA;
		assertEquals(expected, result);
	}
	
	@Test
	public void proxy_NULL_TYPE_Test() {
		int port = 5500;
		String hostname = "hostname";
		String username = "username";
		String password = "password";
		PasswdInetSocketAddress PISA = new PasswdInetSocketAddress(hostname, port, username, password); 
		Type type = null;//method does not check for null
		ProxyPROXY proxy = new ProxyPROXY();
		proxy.Proxy(type, PISA);
		SocketAddress result = proxy.address();
		SocketAddress expected = PISA;
		assertEquals(expected, result);
	}
}



//public int Proxy(Type type, SocketAddress sa) {
//    if ((type == Type.DIRECT) || !(sa instanceof PasswdInetSocketAddress))
//        throw new IllegalArgumentException("type " + type + " is not compatible with address " + sa);
//    this.type = type;
//    this.sa = sa;
//    return 1;
//}
