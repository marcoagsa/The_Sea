package com.msandroid.msa.thesea;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class seabegin extends AppCompatActivity implements View.OnClickListener {


    private ImageButton praia1, praia2, praia3, envia;
    private TextView t1,t2,t3;
    private EditText ed1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seabegin);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setTitle(R.string.app_name);
        actionBar.setIcon(R.mipmap.ic_launcher22);

        t1 = (TextView) findViewById(R.id.t1);
        t1.setText(R.string.t1);
        t2 = (TextView) findViewById(R.id.t2);
        t2.setText(R.string.t2);
        t3 = (TextView) findViewById(R.id.t3);
        t3.setText(R.string.t3);

        ed1 = (EditText) findViewById(R.id.Videoindividual);


        praia1 = (ImageButton) findViewById(R.id.praia1);
        praia2 = (ImageButton) findViewById(R.id.praia2);
        praia3 = (ImageButton) findViewById(R.id.praia3);
        envia = (ImageButton) findViewById(R.id.envia);

        praia1.setOnClickListener(this);
        praia2.setOnClickListener(this);
        praia3.setOnClickListener(this);
        envia.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {

        String[] VideoUrl = getResources().getStringArray(R.array.Url);
        String Video = String.valueOf(ed1.getText());

        switch (v.getId()) {
            case R.id.praia1:

                Intent i = new Intent(seabegin.this, video.class);
                i.putExtra("Data", VideoUrl[0]);
                startActivity(i);
                break;

            case R.id.praia2:

                Intent i1 = new Intent(seabegin.this, video.class);
                i1.putExtra("Data", VideoUrl[1]);
                startActivity(i1);
                break;

            case R.id.praia3:

                Intent i2 = new Intent(seabegin.this, video.class);
                i2.putExtra("Data", VideoUrl[2]);
                startActivity(i2);
                break;

            case R.id.envia:

                Intent i3 = new Intent(seabegin.this, video.class);
                setResult(RESULT_OK, i3);
                i3.putExtra("Data", Video);
                break;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_seabegin, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_search:
                openSearch();
                return true;
            case R.id.action_settings:
                openSettings();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void openSettings() {
        Toast.makeText(this,"Teste", Toast.LENGTH_LONG).show();
    }

    private void openSearch() {
        Toast.makeText(this, "Teste2", Toast.LENGTH_LONG).show();
    }

}