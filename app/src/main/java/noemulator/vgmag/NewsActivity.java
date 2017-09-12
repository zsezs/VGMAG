package noemulator.vgmag;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import Handler.News;
import Handler.VolleySingleton;

public class NewsActivity extends AppCompatActivity {

    ArrayList<News> newsList = new ArrayList<>();
    private String url_getnews = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
    }

    //ARG
    private void getNewes()
    {
        final StringRequest request = new StringRequest(Request.Method.GET, url_getnews, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try
                {
                    JSONArray jsonArray = new JSONArray(response.trim());
                    populateNewsList(jsonArray);
                }
                catch (JSONException e)
                {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        VolleySingleton.getInstance(this).addToRequestQueue(request);
    }
    private void populateNewsList(JSONArray array)
    {
        newsList.clear();
        for (int i = 0 ; i < array.length() ; i++)
        {
            try
            {
                JSONObject object = array.getJSONObject(i);
                News news = new News();
                news.setId(object.getString("id"));
                news.setTitle(object.getString("title"));
                news.setContent(object.getString("content"));
                news.setAuthor(object.getString("author"));
                newsList.add(news);
            }
            catch (JSONException e)
            {
                e.printStackTrace();
            }
        }
    }

}
