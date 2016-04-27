package development.alberto.com.exerciseparsingjson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DisplayListView extends AppCompatActivity {
    String jsonString;
    JSONObject jsonObject;
    JSONArray jsonArray;
    Contacts_Adapter  contacts_adapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_listview_layout);
        jsonString = getIntent().getExtras().get("json_data").toString();
        contacts_adapter = new Contacts_Adapter(this, R.layout.row_layout);
        listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(contacts_adapter);
        String name, email, mobile;
        try {
//            jsonObject = new JSONObject(jsonString);
//            jsonArray = jsonObject.getJSONArray(jsonObject);
            jsonArray = new JSONArray(jsonString); //como nosotros no tenemos ningun objeto antes del array, parseamps el array del string
            int count =0;
            while( count < jsonArray.length() ) {
                JSONObject jsonObject = jsonArray.getJSONObject(count);
                name = jsonObject.getString("author");
                email = jsonObject.getString("title");
                mobile = jsonObject.getString("q");
                Contacts c = new Contacts(name, email, mobile);
                contacts_adapter.add(c);
                count++;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
