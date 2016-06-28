package es.upsa.mimo.espressoexamples.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import es.upsa.mimo.espressoexamples.R;

public class SecondActivity extends AppCompatActivity {

    private TextView textView;
    private String param;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textView = (TextView) findViewById(R.id.text);
        param = getIntent().getStringExtra("key");
        textView.setText(param);
    }
}
