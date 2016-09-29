package com.example.varun.mynoteappp.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.varun.mynoteappp.R;

/**
 * Created by varun on 29/9/16.
 */

public class NoteViewHolder extends RecyclerView.ViewHolder {

    public TextView headerText;
    public TextView descriptionText;
    public TextView editButton;

    public NoteViewHolder(View itemView) {
        super(itemView);
        headerText = (TextView) itemView.findViewById(R.id.note_title);
        descriptionText = (TextView) itemView.findViewById(R.id.note_description);
        editButton = (TextView) itemView.findViewById(R.id.edit_button);

    }
}
