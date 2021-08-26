import java.io.BufferedReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Connection;
import java.util.ArrayList;


public class DataBaseConn {
    static Connection connection = null;
    static String databaseName = "";
    static String url = "jdbc:mysql://localhost:3306/camunda_java";
    static String userName = "root";
    static String password = "1234";


    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
      BufferedReader reader;
        ArrayList ar= new ArrayList();
        String line;
        StringBuffer responseContent=new StringBuffer();
        URL apiUrl=new URL("https://inspiredemo2.appiancloud.com/suite/webapi/taheel-apis-records-GetCenterTypesTree");
        HttpURLConnection conn= (HttpURLConnection) apiUrl.openConnection();
        conn.setRequestProperty("Authorization","Bearer "+"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI2YWUxNjY4OC1kMjMxLTRmZTQtYWYyMy0yYjQ5MWUyMjk2NDkifQ.sVfHaN8hSbxpZuuhIjq1Dd9YOEh_ckc2Qk9pCrX_3Sw");
        //Request setup
        conn.setRequestMethod("GET");
        conn.setConnectTimeout(5000);
        conn.setReadTimeout(5000);

        /*try {

            //Request setup
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            //------------
            int status=conn.getResponseCode();
            //System.out.println(status);
            if (status>299){
                reader=new BufferedReader(new InputStreamReader(conn.getErrorStream()));
                while ((line=reader.readLine())!=null){
                    responseContent.append( line+"\n");
                   System.out.println(line);
                }
                reader.close();
            }else{
                reader=new BufferedReader(new InputStreamReader(conn.getInputStream()));
                while ((line=reader.readLine())!=null){
                    ar.add(line);
                    responseContent.append(line);

                }
                System.out.println(responseContent);
                reader.close();*/

              /*  JSONArray albums=new JSONArray(responseContent.toString());
                for (int i = 0; i < albums.length(); i++) {
                    JSONObject album=albums.getJSONObject(i);
                    int Userid=album.getInt("id");
                    String tiitle=album.getString("title");
                    System.out.println("id :   "+Userid+"--- Title "+tiitle);
                }
                System.out.println(ar.get(1));

            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }finally {
            conn.disconnect();
        }*/
        //call a[i using Http client
       HttpClient client= HttpClient.newHttpClient();
        HttpRequest request= HttpRequest.newBuilder().uri(URI.create("0https://jsonplaceholder.typicode.com/todos")).build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        

    }}

