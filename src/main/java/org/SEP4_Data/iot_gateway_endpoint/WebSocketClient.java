package org.SEP4_Data.iot_gateway_endpoint;

import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.*;

import org.SEP4_Data.service.AccountService;
import org.SEP4_Data.service.MeasurementService;
import org.SEP4_Data.service.PayLoadService;

import com.google.gson.Gson;


import org.SEP4_Data.service.model.source.PayLoad;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;


@Component
public class WebSocketClient extends TextWebSocketHandler
{

    @NonNull
    private PayLoadService service;


    @Getter
    private WebSocketSession clientSession;

    @Autowired
    public WebSocketClient(PayLoadService payLoadService) throws ExecutionException, InterruptedException
    {
        var webSocketClient = new StandardWebSocketClient();
        this.clientSession = webSocketClient.doHandshake(this, new WebSocketHttpHeaders(), URI.create("wss://iotnet.cibicom.dk/app?token=vnoTOQAAABFpb3RuZXQuY2liaWNvbS5kaxOhpkiCUsn0QwqoA8agq88=")).get();
        service = payLoadService;

        TextMessage textMessage = new TextMessage("{\"cmd\":\"gw\",\"seqno\":1102,\"EUI\":\"0004A30B00259D2C\",\"ts\":1608138185016,\"fcnt\":0,\"port\":1,\"freq\":867100000,\"toa\":0,\"dr\":\"SF12 BW125 4/5\",\"ack\":false,\"gws\":[{\"rssi\":-105,\"snr\":8,\"ts\":1608138185016,\"tmms\":50000,\"time\":\"2020-12-16T17:13:04.887116854Z\",\"gweui\":\"7076FFFFFF019BCE\",\"ant\":1,\"lat\":55.809815,\"lon\":9.623305999999957},{\"rssi\":-111,\"snr\":1,\"ts\":1608138185016,\"tmms\":50000,\"time\":\"2020-12-16T17:03:04.887116854Z\",\"gweui\":\"7076FFFFFF019BCE\",\"ant\":0,\"lat\":55.809815,\"lon\":9.623305999999957},{\"rssi\":-114,\"snr\":-5,\"ts\":1608138185035,\"tmms\":50000,\"time\":\"2020-12-16T17:13:04.887119205Z\",\"gweui\":\"7076FFFFFF019F64\",\"ant\":1,\"lat\":55.809815,\"lon\":9.623305999999957},{\"rssi\":-114,\"snr\":-6,\"ts\":1608138185035,\"tmms\":50000,\"time\":\"2020-12-16T17:03:04.887119205Z\",\"gweui\":\"7076FFFFFF019F64\",\"ant\":0,\"lat\":55.809815,\"lon\":9.623305999999957}],\"bat\":255,\"data\":\"23417352637000000000000000000000\"}");

        try {
            handleTextMessage(this.clientSession,textMessage);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws JsonProcessingException
    {
        System.out.println(message);
        System.out.println(message.getPayload());
        Gson gson = new Gson();
        PayLoadDTO value = gson.fromJson(message.getPayload(),PayLoadDTO.class);



        WebSocketHelper helper = new WebSocketHelper(value);
        PayLoad payLoad = helper.sendPayLoadValue();
        System.out.println("Payload is here " + payLoad.toString() + "########");
        System.out.println("Data is here " + payLoad.getData_ID().toString() + "########");
        System.out.println("Device is here " + payLoad.getDevice_id().toString() + "#######");
        if (payLoad!=null)
        service.addToDataBase(payLoad);


    }

    public  void sendMessage(boolean state)
    {
        try
        {
            clientSession.sendMessage(new TextMessage(state + ""));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


}
