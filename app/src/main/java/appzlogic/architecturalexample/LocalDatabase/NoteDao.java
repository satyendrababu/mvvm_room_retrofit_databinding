package appzlogic.architecturalexample.LocalDatabase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import appzlogic.architecturalexample.LocalDatabase.Note;

@Dao
public interface NoteDao {
    @Insert
    void insert(Note note);

    @Update
    void update(Note note);

    @Delete
    void delete(Note note);

    @Query("delete from note_table")
    void deleteAllNotes();

    @Query("select * from note_table order by priority desc")
    LiveData<List<Note>> getAllNotes();   //Live data user for observable if any value get updated data will be automatically reflect
}
