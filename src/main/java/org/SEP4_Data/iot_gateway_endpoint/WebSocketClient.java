package org.SEP4_Data.iot_gateway_endpoint;

import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.*;


import org.SEP4_Data.service.PayLoadService;

import com.google.gson.Gson;


import org.SEP4_Data.service.model.source.PayLoad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.net.URI;
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
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws JsonProcessingException
    {

        Gson gson = new Gson();
        PayLoadDTO value = gson.fromJson(message.getPayload(),PayLoadDTO.class);



        WebSocketHelper helper = new WebSocketHelper(value);
        PayLoad payLoad = helper.sendPayLoadValue();

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
