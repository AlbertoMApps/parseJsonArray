package development.alberto.com.exerciseparsingjson;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    TextView txt1;
    String jsonString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt1 = (TextView) findViewById(R.id.txt1);
        new JSONTask().execute("http://albertomedrano.co.uk/myjson/myjson.json");
    }
    public void parseJSON(View v){
        //new JSONTask().execute("http://albertomedrano.co.uk/myjson/myjson.json");
        if(jsonString!=null){
            Intent intent = new Intent(this, DisplayListView.class);
            intent.putExtra("json_data",jsonString);
            startActivity(intent);
        }
    }
    public class JSONTask extends AsyncTask<String, String, String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {
            HttpURLConnection connection = null;
            BufferedReader reader = null;
            try{
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                InputStream stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));
                StringBuffer buffer = new StringBuffer();

                String line = "";
                while ((line = reader.readLine())!=null ){
                    buffer.append(line);
                }
                return buffer.toString();
            } catch (Exception ex){
                ex.printStackTrace();
            } finally {
                if(connection!=null){
                    connection.disconnect();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            txt1.setText(s);
            jsonString  = s;
        }
    }
}
