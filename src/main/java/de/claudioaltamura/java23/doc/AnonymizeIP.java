package de.claudioaltamura.java23.doc;

import java.net.InetAddress;
import java.util.Objects;

/// Mask Ip Addresses.
public class AnonymizeIP {

    private AnonymizeIP() {}

    /// Returns the masked internet address.
    ///
    /// The IPv4 addresses consists of 32 bits, i.e. 4 octets (bytes).
    /// In dotted decimal notation, the 4 octets are written as four whole numbers
    /// separated by dots in decimal notation in the range from 0 to 255.
    ///
    /// ```
    /// Example: `203.0.113.195`.
    /// ```
    ///
    /// **The implementation masked only the fourth octet, so with our example
    //  we get as a result `203.0.113.195`.***
    ///
    /// @param inet4Address InetAddress to be masked
    /// @return the masked internet address
    public static String maskInet4Address(final InetAddress inet4Address) {
        Objects.requireNonNull(inet4Address);
        final String ipV4Address = inet4Address.getHostAddress();
        return ipV4Address.replaceAll("\\.\\d+$",".0");
    }
}
