package com.example.appnoticias.rss;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class GetRss extends AppCompatActivity {

    private ArrayList<String> titulos = new ArrayList<>();
    private ArrayList<String> links = new ArrayList<>();
    private LinearLayout layoutPrincipal;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        layoutPrincipal = new LinearLayout(this);
        layoutPrincipal.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
        );
        layoutPrincipal.setGravity(Gravity.CENTER_HORIZONTAL);
        layoutPrincipal.setPadding(0, 0, 0, 0);
        layoutPrincipal.setOrientation(LinearLayout.VERTICAL);

        listView = new ListView(this);

        layoutPrincipal.addView(listView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Uri uri = Uri.parse(links.get(position));

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);

                GetRss.this.startActivity(intent);
            }
        });

        new ProcessaChamadaEmBackground().execute();

        setContentView(layoutPrincipal);


    }


    private InputStream getInputStream(URL url) {
        try {
            return url.openConnection().getInputStream();
        } catch (IOException e) {
            return null;
        }
    }

    public class ProcessaChamadaEmBackground extends AsyncTask<Integer, Void, String> {

        ProgressDialog progressDialog = new ProgressDialog(GetRss.this);

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog.setMessage("Busy loading rss feed... please wait...");
            progressDialog.show();
        }

        @Override
        protected String doInBackground(Integer... integers) {
            try {
                URL url = new URL("http://uirauna.net/feed/");

                XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                factory.setNamespaceAware(false);

                XmlPullParser xmlPullParser = factory.newPullParser();
                xmlPullParser.setInput(getInputStream(url), "UTF_8");

                boolean insideItem = false;

                int eventType = xmlPullParser.getEventType();

                while (eventType != XmlPullParser.END_DOCUMENT) {
                    if (eventType == XmlPullParser.START_TAG) {
                        if (xmlPullParser.getName().equalsIgnoreCase("item")) {
                            insideItem = true;

                        } else if (xmlPullParser.getName().equalsIgnoreCase("title")) {
                            if (insideItem) {
                                titulos.add(xmlPullParser.nextText());
                            }
                        } else if (xmlPullParser.getName().equalsIgnoreCase("link")) {
                            if (insideItem) {
                                links.add(xmlPullParser.nextText());
                            }
                        } else if (eventType == XmlPullParser.END_TAG && xmlPullParser.getName().equalsIgnoreCase("item")) {
                            insideItem = false;
                        }

                    }
                    eventType = xmlPullParser.next();
                }
//                for (int i = 0; i < 50; i++) {
//                    if (eventType != XmlPullParser.END_DOCUMENT) {
//                        if (eventType == XmlPullParser.START_TAG) {
//                            if (xmlPullParser.getName().equalsIgnoreCase("item")) {
//                                insideItem = true;
//
//                            } else if (xmlPullParser.getName().equalsIgnoreCase("title")) {
//                                if (insideItem) {
//                                    titulos.add(xmlPullParser.nextText());
//                                }
//                            } else if (xmlPullParser.getName().equalsIgnoreCase("link")) {
//                                if (insideItem) {
//                                    links.add(xmlPullParser.nextText());
//                                }
//                            } else if (eventType == XmlPullParser.END_TAG && xmlPullParser.getName().equalsIgnoreCase("item")) {
//                                insideItem = false;
//                            }
//
//                            eventType = xmlPullParser.next();
//                        }
//                    }else{
//                        Log.d("RAULD","FINAL DO DOC");
//                    }
//                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);


            ArrayAdapter<String> adapter = new ArrayAdapter<String>(GetRss.this, android.R.layout.simple_list_item_1, titulos);


            for (String title : titulos) {
                Log.d("RAULD", title);
            }

            listView.setAdapter(adapter);

            progressDialog.dismiss();

        }
    }
}
