package com.example.varun.mynoteappp.data;

import java.util.Comparator;

/**
 * Created by varun on 29/9/16.
 */

public class NoteData implements Comparable<NoteData>{


    public String title;
    public String description;
    public long time;
    public int noteId;

    public NoteData(int noteId,String title,String description, long time) {
        this.time = time;
        this.description = description;
        this.title = title;
        this.noteId = noteId;
    }

    @Override
    public int compareTo(NoteData noteData) {
        if(this.time > noteData.time)
            return 1;
        if(this.time < noteData.time)
            return -1;
        return 0;
    }
}
