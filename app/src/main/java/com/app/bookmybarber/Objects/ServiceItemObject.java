package com.app.bookmybarber.objects;

/**
 * Created by Aditya Rathi on 03-Feb-16.
 */
public class ServiceItemObject {

    private String serviceName;

    public ServiceItemObject(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
}
