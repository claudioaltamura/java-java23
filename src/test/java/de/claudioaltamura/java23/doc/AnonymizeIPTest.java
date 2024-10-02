package de.claudioaltamura.java23.doc;

import org.junit.jupiter.api.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

import static org.junit.jupiter.api.Assertions.*;

class AnonymizeIPTest {

    @Test
    void maskInet4Address() throws UnknownHostException {
        var myIpAddress = InetAddress.getByName("95.112.155.120");
        assertEquals("95.112.155.0", AnonymizeIP.maskInet4Address(myIpAddress));
    }

}