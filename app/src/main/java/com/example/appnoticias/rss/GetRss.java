package com.example.appnoticias.rss;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.Html;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.appnoticias.Componentes.CardViewNoticia;
import com.example.appnoticias.Componentes.GetNotice;
import com.example.appnoticias.Model.Noticia;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class GetRss extends AppCompatActivity {

//    private ArrayList<String> titulos = new ArrayList<>();
    private ArrayList<String> links = new ArrayList<>();
    private List<Noticia> noticias = new ArrayList<>();

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

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                Uri uri = Uri.parse(links.get(position));
//
//                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//
//                GetRss.this.startActivity(intent);
//            }
//        });

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

            progressDialog.setMessage("Buscando Noticias ... aguarde !");
            progressDialog.show();
        }

        @Override
        protected String doInBackground(Integer... integers) {

            String html = null;

            try {
                URL url = new URL("http://uirauna.net/feed/");

                XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                factory.setNamespaceAware(false);

                XmlPullParser xmlPullParser = factory.newPullParser();
                xmlPullParser.setInput(url.openConnection().getInputStream(), "utf_8");

                boolean insideItem = false;

                int eventType = xmlPullParser.getEventType();

                Noticia noticia = null;

                while (eventType != XmlPullParser.END_DOCUMENT) {
                    if (eventType == XmlPullParser.START_TAG) {
                        if (xmlPullParser.getName().equalsIgnoreCase("item")) {
                            noticia = new Noticia();
                            insideItem = true;

                        } else if (xmlPullParser.getName().equalsIgnoreCase("title")) {
                            if (insideItem) {
//                                titulos.add(xmlPullParser.nextText());
                                noticia.setTitulo(xmlPullParser.nextText());

                            }

                        } else if (xmlPullParser.getName().equalsIgnoreCase("pubdate")) {
                            if (insideItem) {
                                noticia.setData(xmlPullParser.nextText());

                            }

                        } else if (xmlPullParser.getName().equalsIgnoreCase("link")) {
                            if (insideItem) {
//                                links.add(xmlPullParser.nextText());
                                noticia.setLink(xmlPullParser.nextText());

                            }
                        }else if (xmlPullParser.getName().equalsIgnoreCase("description")) {
                                if (insideItem) {
                                    noticia.setDescricao(Html.fromHtml(xmlPullParser.nextText()).toString());

                                }
                        }
                    } else if (eventType == XmlPullParser.END_TAG && xmlPullParser.getName().equalsIgnoreCase("item")) {
                        insideItem = false;
                        noticias.add(noticia);
                    }

                eventType = xmlPullParser.next();
            }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return html;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);


            ArrayAdapter<Noticia> adapter = new ArrayAdapter<Noticia>(GetRss.this, android.R.layout.simple_list_item_1, noticias);

//            for (Noticia noticia : noticias) {
//                Log.d("RAULD", noticia.toString());
//            }

            GetNotice notice = new GetNotice(GetRss.this,noticias);


            listView.setAdapter(notice);

            progressDialog.dismiss();

        }
    }
}
