package org.SEP4_Data.iot_gateway_endpoint;

import com.fasterxml.jackson.core.JsonProcessingException;
<<<<<<< HEAD
//import com.google.gson.Gson;
import lombok.*;

import org.SEP4_Data.service.PayLoadService;
import org.SEP4_Data.service.model.Data;
import org.SEP4_Data.service.model.Device;
import org.SEP4_Data.service.model.PayLoad;
=======
import com.google.gson.Gson;
import lombok.*;

import org.SEP4_Data.service.PayLoadService;
import org.SEP4_Data.service.model.source.Data;
import org.SEP4_Data.service.model.source.Device;
import org.SEP4_Data.service.model.source.PayLoad;
>>>>>>> second_database_datasource
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

import java.net.URI;
import java.util.concurrent.ExecutionException;


@Component
public class WebSocketClient extends TextWebSocketHandler implements ApplicationContextAware
{

    MeasurementDTO dto;
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

    } // link to IoT gateway here

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws JsonProcessingException
    {
        System.out.println("Hamboshdkdkifijdkfkfoskjdjde" + message.getPayload());

<<<<<<< HEAD
        //ObjectMapper mapper = new ObjectMapper();
        //PayLoadDTO value = mapper.readValue(message.getPayload(),PayLoadDTO.class);

        //Gson gson = new Gson();
        //PayLoadDTO value = gson.fromJson(message.getPayload(),PayLoadDTO.class);
=======
        Gson gson = new Gson();
        PayLoadDTO value = gson.fromJson(message.getPayload(),PayLoadDTO.class);

//        System.out.println(value.toString());
        MeasurementDTO measurementDTO = changeToMeasurement(value.getData());


      //  PayLoadDTO value = new ObjectMapper().readValue(message.getPayload(),PayLoadDTO.class);
        System.out.println(value);
>>>>>>> second_database_datasource

        //        System.out.println(value.toString());
        //MeasurementDTO measurementDTO = changeToMeasurement(value.getData());


<<<<<<< HEAD
        //  PayLoadDTO value = new ObjectMapper().readValue(message.getPayload(),PayLoadDTO.class);
        //System.out.println(value);


        //PayLoad payLoad = getPayLoadValue(value);

        //payLoad.setData_ID(getData(measurementDTO));
        //        System.out.println(payLoad);

        //if(value.getCmd().equals("gw"))
        //service.addToDataBase(payLoad);
=======
        payLoad.setData_ID(getData(measurementDTO));

        if(value.getCmd().equals("gw"))
        service.addToDataBase(payLoad);
>>>>>>> second_database_datasource

    }


    private Data getData(MeasurementDTO measurementDTO)
    {
        Data measurements = new Data();
        measurements.setTemperature(measurementDTO.getTemperature());
        measurements.setHumidity(measurementDTO.getHumidity());
        measurements.setCo2(measurementDTO.getCo2());
        measurements.setLight(measurementDTO.isLight());

        return measurements;
    }

    // Changes String to DTO object
    //6e7394e78
    private MeasurementDTO changeToMeasurement(String data)
    {
        if (data == null)
        {
            return null;
        }
        System.out.println("The String of Data " + data);
        String temp_string = data.substring(0, 4);
        String hum_String = data.substring(4, 8);
        String co2_String = data.substring(8, 12);
        //String light_String = data

        int temp = Integer.parseInt(temp_string, 16);
        int hum = Integer.parseInt(hum_String, 16);
        int co2 = Integer.parseInt(co2_String, 16);
        //  boolean light

        MeasurementDTO measurementDTO = new MeasurementDTO();
        measurementDTO.setTemperature(temp);
        measurementDTO.setHumidity(hum);
        measurementDTO.setCo2(co2);

        // Change to light
        measurementDTO.setLight(false);

        return measurementDTO;
    }

    private PayLoad getPayLoadValue(PayLoadDTO value)
    {
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
        payLoad.setDevide_id(getEUI(value.getEUI()));
        return payLoad;
    }

    public Device getEUI(String EUI)
    {
        Device device = new Device();
        device.setEui(EUI);
        // device.setLocation(location);
        device.setName(EUI.substring(0, 9));

        return device;
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
    {

    }
}
