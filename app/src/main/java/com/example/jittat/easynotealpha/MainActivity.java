package com.example.jittat.easynotealpha;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter<String> noteAdapter;

    ArrayList<String> items = new ArrayList<String>(Arrays.asList(new String[] {
            "Hello1",
            "hello2",
            "hello3"
    }));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initializeList();
    }

    private void initializeList() {
        noteAdapter = new ArrayAdapter<String>(this,
                R.layout.list_item_note,
                R.id.list_item_note_textview,
                items);

        ListView listView = (ListView) findViewById(R.id.listview_notes);
        listView.setAdapter(noteAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if((resultCode == Activity.RESULT_OK) && (requestCode == 1)) {
            String title = data.getStringExtra("title");
            noteAdapter.add(title);
            // Log.i("hello","" + items.size());
        }
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

    public void addNewNote(View view) {
        Intent intent = new Intent(this, NoteEditActivity.class);
        startActivityForResult(intent, 1);
    }
}
