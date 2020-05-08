package org.astashonok.service.impl;

import org.astashonok.service.IpAddressService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class IpAddressServiceImpl implements IpAddressService {

    @Override
    public String determineIp(HttpServletRequest request, boolean filterPrivateAddresses) {
        String ipAddress = request.getHeader("X_FORWARDED_FOR");
        if (ipAddress == null) {
            ipAddress = request.getRemoteAddr();
        }
        return ipAddress;
    }
}