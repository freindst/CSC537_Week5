package com.example.frein.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;


public class MainActivity extends AppCompatActivity {
    private EditText inputTF;
    private TextView setsTV;
    private TextView returnCheckTV;
    private TextView falseCheckTV;
    private Stack sets;
    private boolean[] hashs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.inputTF = (EditText) this.findViewById(R.id.inputTF);
        this.setsTV = (TextView) this.findViewById(R.id.setsTV);
        this.returnCheckTV = (TextView) this.findViewById(R.id.returnCheckTV);
        this.falseCheckTV = (TextView) this.findViewById(R.id.falseCheckTV);
        this.sets = new Stack();
        this.hashs = new boolean[]{false, false, false, false, false, false, false, false, false, false};

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void addStringIntoSet(View v)
    {
        String temp = this.inputTF.getText().toString();
        this.inputTF.setText("");
        addBloomFilter(temp);
        this.sets.push(temp);
        this.setsTV.setText(this.sets.toString());
    }

    public void checkString(View v)
    {
        String temp = this.inputTF.getText().toString();
        if (checkBloomFilter(temp))
        {
            this.returnCheckTV.setText("The input passes Bloom Filter Test.");
        }
        else
        {
            this.returnCheckTV.setText("This input fails Bloom Filter Test.");
        }
        if (checkSets(temp))
        {
            this.falseCheckTV.setText("This input is in the set.");
        }
        else
        {
            this.falseCheckTV.setText("This input is not in the set.");
        }
    }

    private boolean checkBloomFilter(String value)
    {
        int index = Math.abs(MurmurHash.hash32(value) % 10);
        if (this.hashs[index] == true)
        {
            return true;
        }
        return false;
    }

    private boolean checkSets(String value)
    {
        String[] setsArray = this.sets.toArray();
        for (int i = 0; i < setsArray.length; i++)
        {
            if (setsArray[i].equals(value))
            {
                return true;
            }
        }
        return false;
    }

    private void addBloomFilter(String value)
    {
        int index = Math.abs(MurmurHash.hash32(value) % 10);
        this.hashs[index] = true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
