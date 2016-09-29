package com.example.varun.mynoteappp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.varun.mynoteappp.EditActivity;
import com.example.varun.mynoteappp.NoteConstants;
import com.example.varun.mynoteappp.R;
import com.example.varun.mynoteappp.data.NoteData;
import com.example.varun.mynoteappp.viewholder.NoteViewHolder;

import java.util.ArrayList;

/**
 * Created by varun on 29/9/16.
 */

public class NoteRecyclerAdapter extends RecyclerView.Adapter<NoteViewHolder> {

    private Context mContext;
    private ArrayList<NoteData> list;

    public NoteRecyclerAdapter(Context context, ArrayList<NoteData> items) {
        this.mContext = context;
        this.list = items;
    }

    @Override
    public NoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.note_item,parent);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NoteViewHolder holder, int position) {
        final NoteData data = list.get(position);
        holder.headerText.setText(data.title);
        holder.descriptionText.setText(data.description);
        holder.editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, EditActivity.class);
                intent.putExtra(NoteConstants.NOTE_ID_EXTRA_KEY,data.noteId);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
