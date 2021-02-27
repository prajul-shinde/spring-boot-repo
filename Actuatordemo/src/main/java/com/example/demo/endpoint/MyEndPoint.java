package com.example.demo.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id="xAdmin",enableByDefault = true)
public class MyEndPoint {



    @ReadOperation
    public MyEndPointResponse getResponse() {
        return new MyEndPointResponse(1001,"xadmin-prajul","Active");
    }
}
