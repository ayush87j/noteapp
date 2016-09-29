package com.example.varun.mynoteappp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        initUI();
    }

    private void initUI() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.note_recycler_view);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.add_note) {
            Toast.makeText(mContext,"Menu Clicked",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(mContext,EditActivity.class);
            mContext.startActivity(intent);
        }
        return true;
    }
}
