package test;

import main.PasswdInetSocketAddress;
import main.ProxyEQUALS;
import main.ProxyEQUALS.Type;
import static org.junit.Assert.*;


import org.junit.Test;

public class Proxy_EQUALS_TEST {
	@Test
	public void equals_VALID_FALSE_test() {
		ProxyEQUALS proxy = new ProxyEQUALS();
		PasswdInetSocketAddress PISA = new PasswdInetSocketAddress("hostname", 5500, "username", "password");
		Type type = Type.HTTP;
		ProxyEQUALS proxy2 = new ProxyEQUALS();
		proxy2.Proxy(type, PISA);//set Type of proxy2 to HTTP
		boolean result = proxy2.equals(proxy);//compare proxy2 to proxy that has a different Type Direct =/= HTTP
		boolean expected = false;
		assertEquals(expected, result);
	}
	
	@Test
	public void equals_VALID_TRUE_test() {
		ProxyEQUALS proxy = new ProxyEQUALS();
		PasswdInetSocketAddress PISA = new PasswdInetSocketAddress("hostname", 5500, "username", "password");
		Type type = Type.HTTP;
		ProxyEQUALS proxy2 = new ProxyEQUALS();
		proxy2.Proxy(type, PISA);//set Type of proxy2 to HTTP
		boolean result = proxy2.equals(proxy2);//compare proxy2 to itself HTTP = HTTP
		boolean expected = true;
		assertEquals(expected, result);
	}
	
	@Test
	public void equals_NULL_test() {
		ProxyEQUALS proxy = null;
		PasswdInetSocketAddress PISA = new PasswdInetSocketAddress("hostname", 5500, "username", "password");
		Type type = Type.HTTP;
		ProxyEQUALS proxy2 = new ProxyEQUALS();
		proxy2.Proxy(type, PISA);//set Type of proxy2 to HTTP
		boolean result = proxy2.equals(proxy);//compare proxy2 to null instance of Proxy HTTP =/= null
		boolean expected = false;
		assertEquals(expected, result);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void equals_portOutOfRange_test() {
		ProxyEQUALS proxy = new ProxyEQUALS();
		PasswdInetSocketAddress PISA = new PasswdInetSocketAddress("hostname", -5500, "username", "password");
		Type type = Type.HTTP;
		ProxyEQUALS proxy2 = new ProxyEQUALS();
		proxy2.Proxy(type, PISA);//set Type of proxy2 to HTTP
		boolean result = proxy2.equals(proxy2);//compare proxy2 to itself HTTP = HTTP
		boolean expected = true;
		assertEquals(expected, result);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void equals_nullHostName_test() {
		ProxyEQUALS proxy = new ProxyEQUALS();
		String nullString = null;
		PasswdInetSocketAddress PISA = new PasswdInetSocketAddress(nullString, 5500, "username", "password");
		Type type = Type.HTTP;
		ProxyEQUALS proxy2 = new ProxyEQUALS();
		proxy2.Proxy(type, PISA);//set Type of proxy2 to HTTP
		boolean result = proxy2.equals(proxy2);//compare proxy2 to itself HTTP = HTTP
		boolean expected = true;
		assertEquals(expected, result);
	}
	
}

//TEST THIS
//public final boolean equals(Object obj) {
//    if (obj == null || !(obj instanceof Proxy))
//        return false;
//    Proxy p = (Proxy) obj;
//    if (p.type() == type()) {
//        if (address() == null) {
//            return (p.address() == null);
//        } else
//            return address().equals(p.address());
//    }
//    return false;
//}
