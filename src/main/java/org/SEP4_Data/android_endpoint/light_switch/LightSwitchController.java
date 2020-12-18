package org.SEP4_Data.android_endpoint.light_switch;

import lombok.RequiredArgsConstructor;
import org.SEP4_Data.iot_gateway_endpoint.WebSocketClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LightSwitchController
{
    @Autowired
    private ApplicationContext context;

    @GetMapping("/onOfflightSwitch")
    public void onOffLighSwitch(@RequestParam Boolean stateOfTheSwitch)
    {
        System.out.println(stateOfTheSwitch);
        WebSocketClient client = context.getBean(WebSocketClient.class);
        client.sendMessage(stateOfTheSwitch);
    }


}
