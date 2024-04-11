package org.example;

import com.google.gson.Gson;
import com.sun.net.httpserver.Request;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    //public static String targetUrl = "https://api.ipify.org";
    public final static String apiKey = "518063b4d68266f6983aa3c8858ac5ba";


    public static String requestShow = "{\n" +
                        "  \"type\": \"all\",\n" +
                        "  \"proxy_type\": \"resident\",\n" +
                        "  \"page\": 1,\n" +
                        "  \"page_size\": 100,\n" +
                        "  \"sort\": 1\n" +
                        "}";


    public static void proxyCreate(String url,String requestBody){
        HttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);

        httpPost.setEntity(new StringEntity(requestBody, "UTF-8"));
        httpPost.setHeader("Content-Type", "application/json");

//        HttpGet httpGet = new HttpGet(url);
//        System.out.println(httpGet);
        try {
            HttpResponse response = httpClient.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();

            if (statusCode == 200) { // Проверка успешности ответа
                String responseBody = EntityUtils.toString(response.getEntity());
                //System.out.println(responseBody);
//                    Gson gson = new Gson();
//
//                    System.out.println(gson.fromJson(responseBody, Map.class));

            } else {
                System.out.println("Ошибка: " + statusCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        String insertUrl ="https://api.dashboard.proxy.market/dev-api/v2/package/create-proxy/" + apiKey;
        String showUrl ="https://api.dashboard.proxy.market/dev-api/list/" + apiKey;
//
//        proxyCreate(showUrl,requestShow);
//        ArrayList<String> arrayList = getArrayList();
//
//        for(String str : arrayList) {
//            //System.out.println(str);
//            Pattern pattern = Pattern.compile("^(.*?):(.*?)@(.*):(\\d+)$");
//            Matcher matcher = pattern.matcher(str);
//            if (matcher.matches()) {
//                String login = matcher.group(1);
//                String pass = matcher.group(2);
//                String host = matcher.group(3);
//                String port = matcher.group(4);
//                new Main().proxyCheck(login, pass, host, Integer.parseInt(port),targetUrl);
////                thread.start();
//
//            } else {
//                System.out.println("Неверный формат строки");
//            }
//        }
        String[] arr = {"3814","3815","3816","3817","3818","3819","3820","3821","3822","3830"};
        String requestInsert;
        for (String s : arr) {

            requestInsert = "{\n" +
                    "  \"packageId\": " + s + ",\n" +
                    "  \"country\": \"de\",\n" +
                    "  \"rotation\": -1,\n" +
                    "  \"regionId\": 417,\n" +
                    "  \"cityId\": 6838\n" +
                    "}";
            System.out.println("hi");
            //System.out.println(requestInsert);
            for (int i = 0; i <= 200; i++) {

                proxyCreate(insertUrl, requestInsert);
                System.out.println(i);
            }
        }


    }



//    public static ArrayList<String> getArrayList(){
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        ArrayList<String> arrayList = new ArrayList<>();
//        //String str = "";
//        try {
//            String temp = "";
//            while (!(temp = reader.readLine()).equals(""))
//                arrayList.add(temp);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        finally {
//            try {
//                reader.close();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        return arrayList;
//    }
//
//    public static void sleep(){
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public void proxyCheck(String login, String password, String host, int port, String targetUrl){
//
//        Authenticator.setDefault(new Authenticator() {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                //System.out.println(new PasswordAuthentication(login,password.toCharArray()));
//                return new PasswordAuthentication(login,password.toCharArray());
//            }
//        });
//        Proxy proxy = new Proxy(Proxy.Type.SOCKS,new InetSocketAddress(host,port));
////        System.out.println(Thread.currentThread().getName());
//        try {
//            URL url = new URL(targetUrl);
//            URLConnection connection = url.openConnection(proxy);
//            sleep();
//            BufferedReader reader1 = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//
//            String ipAddress = reader1.readLine();
//            System.out.println(login);
//            System.out.println("Мой IP-адрес: " + ipAddress);
//            reader1.close();
//
//        } catch (IOException e) {
//            System.out.println("Нерабочий прокси: "+login);
//        }
//    }
}


