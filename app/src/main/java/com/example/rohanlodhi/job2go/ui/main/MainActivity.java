package com.example.rohanlodhi.job2go.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rohanlodhi.job2go.R;
import com.example.rohanlodhi.job2go.adapters.NotesAdapter;
import com.example.rohanlodhi.job2go.database.LocalCacheManager;
import com.example.rohanlodhi.job2go.models.Note;
import com.example.rohanlodhi.job2go.ui.activity.BaseActivity;
import com.example.rohanlodhi.job2go.ui.add_note.AddNoteActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends BaseActivity implements MainViewInterface {

    @BindView(R.id.rvNotes)
    RecyclerView rvNotes;

    @BindView(R.id.tvNoData)TextView tvNoData;

    RecyclerView.Adapter adapter;
    List<Note> notesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initViews();
        loadNotes();

    }

    private void initViews() {

        rvNotes.setLayoutManager(new LinearLayoutManager(this));
    }

    private void loadNotes(){

        //Call Method to get Notes
        LocalCacheManager.getInstance(this).getNotes(this);


    }

    @OnClick(R.id.fabAddNote)
    public void addNote(){
        Intent i = new Intent(MainActivity.this,AddNoteActivity.class);
        startActivity(i);
    }

    @Override
    public void onNotesLoaded(List<Note> notes) {
        notesList = notes;

        if(notesList.size() == 0){
            onDataNotAvailable();
        }else {
            tvNoData.setVisibility(View.GONE);
            rvNotes.setVisibility(View.VISIBLE);
            adapter = new NotesAdapter(this, notes);
            rvNotes.setAdapter(adapter);
        }
    }

    @Override
    public void onNoteAdded() {

        Toast.makeText(this,"Note Added", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDataNotAvailable() {
        tvNoData.setVisibility(View.VISIBLE);
        rvNotes.setVisibility(View.GONE);
    }
}

