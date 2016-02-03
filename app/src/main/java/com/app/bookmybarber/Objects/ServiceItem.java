package com.app.bookmybarber.Objects;

/**
 * Created by Aditya Rathi on 03-Feb-16.
 */
public class ServiceItem {

    private String serviceName;

    public ServiceItem(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
}
