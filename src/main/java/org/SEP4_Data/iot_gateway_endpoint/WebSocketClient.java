package org.SEP4_Data.iot_gateway_endpoint;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

import org.SEP4_Data.service.PayLoadService;
import org.SEP4_Data.service.model.PayLoad;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

import org.springframework.web.socket.handler.TextWebSocketHandler;

import javax.annotation.PostConstruct;
import java.net.URI;
import java.util.concurrent.ExecutionException;


@Component
public class WebSocketClient extends TextWebSocketHandler implements ApplicationContextAware {

@NonNull
    private PayLoadService service;



    @Getter
    private WebSocketSession clientSession;

    @Autowired
    public WebSocketClient(PayLoadService payLoadService) throws ExecutionException, InterruptedException  {
        var webSocketClient = new StandardWebSocketClient();
       // this.clientSession = webSocketClient.doHandshake(this, new WebSocketHttpHeaders(), URI.create("wss://iotnet.cibicom.dk/app?token=vnoTOQAAABFpb3RuZXQuY2liaWNvbS5kaxOhpkiCUsn0QwqoA8agq88=")).get();
        System.out.println("////");
        service = payLoadService;

    } // link to IoT gateway here

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws JsonProcessingException {
        System.out.println(message.getPayload());

        //ObjectMapper mapper = new ObjectMapper();
        //PayLoadDTO value = mapper.readValue(message.getPayload(),PayLoadDTO.class);

        PayLoadDTO value = new ObjectMapper().readValue(message.getPayload(),PayLoadDTO.class);
        System.out.println(value);


        PayLoad payLoad = getPayLoadValue(value);

        service.addToDataBase(payLoad);




        // extract the message here(or somewhere else - S from SOLID) and make new measurementDTO, then parse it to DB
    }

    private PayLoad getPayLoadValue(PayLoadDTO value) {
        PayLoad payLoad = new PayLoad();
        payLoad.setTs(value.getTs());
        payLoad.setToa(value.getToa());
        payLoad.setSnr(value.getSnr());
        payLoad.setBat(value.getBat());
        payLoad.setTs(value.getTs());
        payLoad.setFreq(value.getFreq());
        payLoad.setRssi(value.getRssi());
        payLoad.setSeqno(value.getSeqno());
        payLoad.setPort(value.getPort());
        payLoad.setAck(value.getAck());
        payLoad.setOffline(value.getOffline());
        payLoad.setCmd(value.getCmd());
        payLoad.setDr(value.getDr());
        payLoad.setEUI(value.getEUI());
        return payLoad;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }
}
