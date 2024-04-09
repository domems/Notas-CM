package com.example.labii.data.vm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.labii.data.db.NoteDatabase
import com.example.labii.data.entities.Note
import com.example.labii.data.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel {
    class NoteViewModel(application: Application) : AndroidViewModel(application){
        val readAllNotes: LiveData<List<Note>>
        private val repository: NoteRepository

        init {
            val noteDao = NoteDatabase.getDatabase(application).noteDao()
            repository = NoteRepository(noteDao)
            readAllNotes = repository.readAllNotes
        }

        fun  addNote(note: Note){
            viewModelScope.launch(Dispatchers.IO) {
                repository.addNote(note)
            }
        }

        fun updateNote(note: Note) {
            viewModelScope.launch(Dispatchers.IO) {
                repository.updateNote(note)
            }
        }

        fun  deleteNote(note: Note) {
            viewModelScope.launch(Dispatchers.IO) {
                repository.deleteNote(note)
            }
        }
    }
}