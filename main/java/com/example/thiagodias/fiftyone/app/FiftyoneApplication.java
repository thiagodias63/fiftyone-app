package com.example.thiagodias.fiftyone.app;

import android.app.Application;

import com.example.thiagodias.fiftyone.services.RestService;
import com.example.thiagodias.fiftyone.services.ServiceOrdem;
import com.example.thiagodias.fiftyone.services.ServiceRelatorio;
import com.example.thiagodias.fiftyone.services.ServiceUser;

public class FiftyoneApplication extends Application {
    private static String URLFifty = "https://limitless-hollows-91089.herokuapp.com/api/";
    private static String URLInsta = "http://apiteste.fourtime.com/api/";

    private static FiftyoneApplication instance;

    private ServiceRelatorio serviceRelatorio;
    private ServiceUser serviceUser;
    private ServiceOrdem serviceOrdem;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        createServices();
    }

    public void createServices() {
        serviceRelatorio = (new RestService(URLFifty)).getService(ServiceRelatorio.class);
        serviceOrdem = (new RestService(URLFifty)).getService(ServiceOrdem.class);
        serviceUser = (new RestService(URLFifty)).getService(ServiceUser.class);
    }

    public static FiftyoneApplication getInstance() {
        return instance;
    }

    public ServiceRelatorio getServiceRelatorio() {
        return serviceRelatorio;
    }
    public ServiceUser getServiceUser() {
        return serviceUser;
    }
    public ServiceOrdem getServiceOrdem() {
        return serviceOrdem;
    }
}
