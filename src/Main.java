import org.json.simple.JSONObject;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        //skapa ett json object

        JSONObject jsonOb = new JSONObject();

        //spara värde i json obejct

        jsonOb.put("namn", "Albin");
        jsonOb.put("age", 23);


        //skriva ut värden


        System.out.println("mitt namn är:" + jsonOb.get("namn"));
        System.out.println("jag är: " + jsonOb.get("age") + " år gammal");




    }

}

