/*
 * Copyright (C) 2015 R06564
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ninmore
 */
public class WinListener {
    public String program;
    
    public WinListener(String progName){
        program = progName;
    }
    /**
     * Checks if program is running or not.
     * If the program is running then return true else return false. This works
     * by executing an command line in windows tasklist to get a list of programs
     * that matches the given criteria for example 'thunderbird.exe', it 
     * will then using a buffered reader read the next line and check if the
     * index of the program is 0 which is the first line else get the next line.
     * Until it finds the program or there is no more lines left.
     * @return If the program is running then return true else return false
     */
    public boolean isRunning(){
        try {
            String data;
            Process p = Runtime.getRuntime().exec("TASKLIST /FI \"IMAGENAME eq " + program + "\" /NH");
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while((data = in.readLine()) != null) {
                System.out.println(data);
                if(data.indexOf(program) == 0) {
                    return true;
                }
            }
            return false;
        } catch (IOException ex) {
            Logger.getLogger(WinListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static void main(String args[]){
        WinListener l = new WinListener("thunderbird.exe");
        l.isRunning();
    }
}
