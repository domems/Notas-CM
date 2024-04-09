package com.example.labii.data.repository

import androidx.lifecycle.LiveData
import com.example.labii.data.dao.NoteDao
import com.example.labii.data.entities.Note

class NoteRepository(private  val noteDao: NoteDao) {
    val readAllNotes : LiveData<List<Note>> = noteDao.readAllNotes()

    suspend fun addNote(note: Note){
        noteDao.addNote(note)
    }

    suspend fun updateNote(note: Note) {
        noteDao.updateNote(note)
    }

    suspend fun deleteNote(note: Note) {
        noteDao.deleteNote(note)
    }
}