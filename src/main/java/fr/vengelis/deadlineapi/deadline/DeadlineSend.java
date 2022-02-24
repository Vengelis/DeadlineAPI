/**
 * Created by Vengelis_.
 * Date: 2/24/2022
 * Time: 1:59 AM
 * Project: DeadlineAPI
 */

package fr.vengelis.deadlineapi.deadline;

import com.google.common.net.HttpHeaders;
import org.apache.commons.codec.binary.Base64;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class DeadlineSend {

    public static String send(String address, String message, String requestType, String body, Boolean useAuth,
                              String username, String password, Boolean useTls, String caCert,Boolean insecure){

        try{

//            System.out.println("1");
            String httpString;
            if(useTls){
                httpString = "https://";
            } else {
                httpString = "http://";
            }
            if(!address.startsWith(httpString)){
                address = httpString + address;
            }

//            System.out.println("2");
            URL url = new URL(address + message);
            HttpURLConnection connexion = (HttpURLConnection) url.openConnection();

            connexion.setRequestMethod(requestType);

//            System.out.println("3");
            if(useAuth){
                String userPassword = username + ":" + password;
                byte[] userPasswordEncoded = Base64.encodeBase64(userPassword.getBytes(StandardCharsets.UTF_8));
                String authHeader = "Basic " + new String(userPasswordEncoded);
                connexion.setRequestProperty(HttpHeaders.AUTHORIZATION, authHeader);
            }

//            System.out.println("4");
            if(!(body == null)){
                connexion.setRequestProperty("Content-Type", "application/json");
                connexion.setDoOutput(true);
                OutputStream os = connexion.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os, StandardCharsets.UTF_8);
                osw.write(body);
                osw.close();
                os.close();
            }

//            System.out.println("5");
            if(useTls){
                // TODO: Implement
                return "Error: The protocol TLS was not supported on this version of DeadlineAPI";
            }

            connexion.connect();

//            System.out.println("6");
            InputStream is = connexion.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            StringBuilder response = new StringBuilder();
            String line;
            while((line = rd.readLine()) != null){
                response.append(line);
                response.append('\r');
            }
            rd.close();
            return response.toString();

//        } catch (Exception e) {
//            if(e.getStatusCode() == 401) {
//                return "Error: HTTP Status Code 401. Authentication with the Web Service failed. Please ensure that the authentication credentials are set, are correct, and that authentication mode is enabled.";
//            } else {
//                e.printStackTrace();
//                return e.getStatusCode() + " : " + e.getMessage();
//            }
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }

    }

}
