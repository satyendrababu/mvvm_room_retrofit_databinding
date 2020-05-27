package appzlogic.architecturalexample.LocalDatabase;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Note.class}, version = 1)
public abstract class NoteDatabase extends RoomDatabase {

    private static NoteDatabase noteDatabaseInstance;

    public abstract NoteDao noteDao();//Once we create instance of NoteDatabase rooms auto generates codes for this method

    public static synchronized NoteDatabase getInstance(Context context){
        if (noteDatabaseInstance == null){

            noteDatabaseInstance = Room.databaseBuilder(context.getApplicationContext(),
                    NoteDatabase.class,"note_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return noteDatabaseInstance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAyncTask(noteDatabaseInstance).execute();
        }

    };
    private static class PopulateDbAyncTask extends AsyncTask<Void, Void, Void>{

        private NoteDao noteDao;

        public PopulateDbAyncTask(NoteDatabase db) {
            noteDao = db.noteDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            noteDao.insert(new Note("title 1","description 1",1));
            noteDao.insert(new Note("title 2","description 2",2));
            noteDao.insert(new Note("title 3","description 3",3));
            noteDao.insert(new Note("title 4","description 4",4));
            noteDao.insert(new Note("title 5","description 5",5));
            noteDao.insert(new Note("title 6","description 6",6));
            return null;
        }
    }
}
