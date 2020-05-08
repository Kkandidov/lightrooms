package org.astashonok.service;

import com.maxmind.geoip2.exception.GeoIp2Exception;

import java.io.IOException;

public interface GeoLocationService {
    String findCountryNameByIp(String ip) throws IOException, GeoIp2Exception;
}
