import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.plaf.synth.SynthSeparatorUI;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        System.out.println("Hello world!");

        //skapa ett json object

        JSONObject jsonOb = new JSONObject();

        //spara värde i json obejct

        jsonOb.put("namn", "Albin");
        jsonOb.put("age", 23);


        //skriva ut värden


        System.out.println("mitt namn är:" + jsonOb.get("namn"));
        System.out.println("jag är: " + jsonOb.get("age") + " år gammal");

        File path = new File("/Users/albinjonasson/IdeaProjects/jsonexample11/src/data.json");
        Object o = new JSONParser().parse(new FileReader(path));
        JSONObject jsonData = (JSONObject) o;

        JSONObject person = (JSONObject) jsonData.get("p1");
        String name= (String) person.get("name");
        System.out.println("p1 name :" + name);

        JSONObject person2 = (JSONObject) jsonData.get("p2");
        String  name2= (String) person2.get("name");
        System.out.println("p2 name: " + name2);




        //Hämtar data från json fil och gör de till ett obejct, sedan hämtar och skriver ut det datan










         //   static void fetchJsonFromApi () throws IOException{
          //          URL url = new URL("https://api.wheretheiss.at/v1/satellites/25544");
                                                                                                  
                //    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                //    if (conn.getResponseCode() == 200) System.out.println("Lyckades!");
               //     else System.out.println("Misslyckades!");
                                                                                                  
        try {
               URL url = new URL("https://api.wheretheiss.at/v1/satellites/25544");
               HttpURLConnection conn = (HttpURLConnection) url.openConnection();
               conn.setRequestMethod("GET");
               conn.connect();

               int responseCode = conn.getResponseCode();

               if (responseCode != 200){
                   throw new RuntimeException("HttpResponseCode: " + responseCode);

        }else {
                   StringBuilder informationString = new StringBuilder();
                   Scanner scanner = new Scanner(url.openStream());

                   while (scanner.hasNext()){
                       informationString.append(scanner.nextLine());
                   }
                   scanner.close();

                   System.out.println(informationString);
                   JSONObject issData = (JSONObject) new JSONParser().parse(String.valueOf(informationString));


                   System.out.println(issData.get("velocity") + "------" + issData.get("altitude"));


               }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

           

}

