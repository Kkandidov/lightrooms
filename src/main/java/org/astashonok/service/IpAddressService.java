package org.astashonok.service;

import javax.servlet.http.HttpServletRequest;

public interface IpAddressService {
    String determineIp(HttpServletRequest request, boolean filterPrivateAddresses);
}
