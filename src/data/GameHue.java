/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import com.philips.lighting.hue.sdk.PHAccessPoint;
import com.philips.lighting.hue.sdk.PHHueSDK;
import com.philips.lighting.model.PHBridge;
import com.philips.lighting.model.PHLight;
import com.philips.lighting.model.PHLightState;
import java.util.List;

/**
 *
 * @author ninmore
 */
public class GameHue {
    private PHHueSDK phHueSDK = PHHueSDK.getInstance();
    PHLightState lightState = new PHLightState();
    PHBridge bridge;
    
    private final String AP_IP_ADDRESS = "192.168.1.25";
    private final String AP_USERNAME = "newdeveloper";
    public List<PHLight> lightList = null;

    public GameHue() {
        test();
    }

    private void test() {
        System.out.println("Create hue SDK");
        phHueSDK.setAppName("GameHue");
        System.out.println("Set app name as GameHue");
        PHAccessPoint ap = new PHAccessPoint();
        ap.setIpAddress(AP_IP_ADDRESS);
        ap.setUsername(AP_USERNAME);
        System.out.println("Connect to AP");
        phHueSDK.connect(ap);
        //End of code print
        System.out.println("End of test code!");
    }
    
    public String returnAccessPoint(){
        String aPoint = phHueSDK.getAllBridges().get(0).toString();
        return aPoint;
    }
    /**
     * Get lights on the bridge and put them in a list
     */
    public void getLights(){
        bridge = PHHueSDK.getInstance().getSelectedBridge();
        for(int c=0; c<bridge.getResourceCache().getAllLights().size(); c++){
            System.out.println(bridge.getResourceCache().getAllLights().get(c).toString());
            lightList = bridge.getResourceCache().getAllLights();
        }
    }
    
    public void lightOff(PHLight light){
        bridge = PHHueSDK.getInstance().getSelectedBridge();
        lightState.setBrightness(0);
        bridge.updateLightState(light, lightState);
    }
    
    public void lightOn(PHLight light){
        bridge = PHHueSDK.getInstance().getSelectedBridge();
        lightState.setBrightness(100);
        bridge.updateLightState(light, lightState);
    }
}
