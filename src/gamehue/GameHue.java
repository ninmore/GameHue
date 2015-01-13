/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamehue;

import com.philips.lighting.hue.sdk.PHAccessPoint;
import com.philips.lighting.hue.sdk.PHBridgeSearchManager;
import com.philips.lighting.hue.sdk.PHHueSDK;
import com.philips.lighting.hue.sdk.PHMessageType;
import com.philips.lighting.hue.sdk.PHSDKListener;
import com.philips.lighting.model.PHBridge;
import com.philips.lighting.model.PHHueParsingError;
import java.util.List;

/**
 *
 * @author R06564
 */
public class GameHue {

    PHHueSDK phHueSDK = PHHueSDK.getInstance();

    public GameHue() {

    }

    private PHSDKListener listener = new PHSDKListener() {

        @Override
        public void onCacheUpdated(List<Integer> list, PHBridge phb) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void onBridgeConnected(PHBridge phb) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void onAuthenticationRequired(PHAccessPoint phap) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void onAccessPointsFound(List<PHAccessPoint> list) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void onError(int i, String string) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void onConnectionResumed(PHBridge phb) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void onConnectionLost(PHAccessPoint phap) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void onParsingErrors(List<PHHueParsingError> list) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    };

    public void test() {
        System.out.println("Create hue SDK");
        phHueSDK.setAppName("GameHue");
        System.out.println("Set app name as Game Hue");
        System.out.println("Start search for bridge!");
        PHBridgeSearchManager sm = (PHBridgeSearchManager) phHueSDK.getSDKService(PHHueSDK.SEARCH_BRIDGE);
        sm.search(true, true); 

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GameHue t = new GameHue();
        t.test();
    }

}
