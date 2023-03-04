package com.example.note_homework

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main2.view.*
import kotlinx.android.synthetic.main.note_card.view.*

class adapter(var activity: MainActivity,var noteModel:ArrayList<noteModel>):BaseAdapter() {
    override fun getCount(): Int {
       return noteModel.size
    }

    override fun getItem(p0: Int): Any {
        return noteModel[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var notes =LayoutInflater.from(activity).inflate(R.layout.note_card,null,false)
        notes.notetitle.text = noteModel[p0].notetitle
        notes.notedescription.text = noteModel[p0].notedescription
        notes.noteletter.text = noteModel[p0].noteletter
        return notes
    }
}