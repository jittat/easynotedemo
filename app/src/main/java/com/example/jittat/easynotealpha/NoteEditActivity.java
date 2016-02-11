package com.example.jittat.easynotealpha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NoteEditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_edit);
    }

    public void saveNote(View view) {
        EditText noteTitleEditText = (EditText) findViewById(R.id.note_title_edittext);
        String title = noteTitleEditText.getText().toString();

        Intent data = new Intent().putExtra("title",title);
        setResult(RESULT_OK,data);
        finish();
    }
}
