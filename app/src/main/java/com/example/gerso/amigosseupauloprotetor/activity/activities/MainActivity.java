package com.example.gerso.amigosseupauloprotetor.activity.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gerso.amigosseupauloprotetor.R;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.widget.LoginButton;

import org.json.JSONObject;

import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    AccessToken accessToken;
    TextView textViewNomePerfil;
    ImageView imageViewFotoPerfil;
    Button buttonContinuar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        accessToken = AccessToken.getCurrentAccessToken();

        textViewNomePerfil = (TextView) findViewById(R.id.textViewNomePerfil);
        imageViewFotoPerfil = (ImageView) findViewById(R.id.imageViewFotoPerfil);
        buttonContinuar = (Button) findViewById(R.id.buttonContinuar);

        getUserdata(accessToken);

        buttonContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main3Activity.class);
                startActivity(intent);
            }
        });


    }

    public void getUserdata(AccessToken accessToken){

        GraphRequest request = GraphRequest.newMeRequest(accessToken, new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(JSONObject jsonObject, GraphResponse graphResponse) {
                graphResponse.getError();

                try{

                    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                    StrictMode.setThreadPolicy(policy);
                    String profilePicUrl = jsonObject.getJSONObject("picture").getJSONObject("data").getString("url");
                    String profileName = jsonObject.getString("name");

                    URL fb_url = new URL(profilePicUrl);//small | noraml | large
                    HttpsURLConnection conn1 = (HttpsURLConnection) fb_url.openConnection();
                    HttpsURLConnection.setFollowRedirects(true);
                    conn1.setInstanceFollowRedirects(true);
                    Bitmap fb_img = BitmapFactory.decodeStream(conn1.getInputStream());

                    imageViewFotoPerfil.setImageBitmap(fb_img);
                    textViewNomePerfil.setText(profileName);

                } catch (Exception ex){

                    ex.printStackTrace();
                }
            }
        });

        Bundle params = new Bundle();
        params.putString("fields","id, picture.type(large), name");
        request.setParameters(params);
        request.executeAsync();
    }

}
