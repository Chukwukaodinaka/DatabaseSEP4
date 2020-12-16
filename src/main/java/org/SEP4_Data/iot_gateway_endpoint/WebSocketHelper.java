package org.SEP4_Data.iot_gateway_endpoint;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.SEP4_Data.service.model.source.Data;
import org.SEP4_Data.service.model.source.Device;
import org.SEP4_Data.service.model.source.PayLoad;


@AllArgsConstructor
@NoArgsConstructor
public class WebSocketHelper {
    PayLoadDTO payLoadDTO;


    public PayLoad sendPayLoadValue()
    {
        PayLoad payLoad = null;
        if(payLoadDTO.getCmd().equals("gw")) {
        MeasurementDTO measurementDTO = changeToMeasurement(payLoadDTO.getData());
         payLoad = getPayLoadValue(payLoadDTO);
        payLoad.setData_ID(getData(measurementDTO));
         }
        return payLoad;
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
        String light_String = data.substring(12,16);

        int temp = Integer.parseInt(temp_string, 16);
        double temperature = temp/(double) 10;
        int hum = Integer.parseInt(hum_String, 16);
        double humidity = hum/(double) 10;
        int co2 = Integer.parseInt(co2_String, 16);
        int light = Integer.parseInt(light_String, 16);

        MeasurementDTO measurementDTO = new MeasurementDTO();

        measurementDTO.setTemperature(temperature);
        measurementDTO.setHumidity(humidity);
        measurementDTO.setCo2(co2);
        if(light<=100)
            measurementDTO.setLight(false);
        else
            measurementDTO.setLight(true);

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
        payLoad.setDevice_id(getEUI(value.getEUI()));
        return payLoad;
    }

    public Device getEUI(String EUI)
    {
        Device device = new Device();
        device.setEui(EUI);
       //  device.setLocation(location);
        device.setName(EUI.substring(0, 9));

        return device;
    }


}
