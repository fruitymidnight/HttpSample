package com.example.httpsample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ボタンを設定
        Button button = findViewById(R.id.button);
        final Commander commander = new Commander();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final String postJson = "{" +
                            "    \"person\": {" +
                            "        \"firstName\": \"John\"," +
                            "        \"lastName\": \"Doe\"," +
                            "        \"address\": \"NewYork\"," +
                            "        \"pets\": [" +
                            "            {\"type\": \"Dog\", \"name\": \"Jolly\"}," +
                            "            {\"type\": \"Cat\", \"name\": \"Grizabella\"}," +
                            "            {\"type\": \"Fish\", \"name\": \"Nimo\"}" +
                            "        ]" +
                            "    }" +
                            "}";
                    commander.doPost("http://httpbin.org/post", postJson);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
