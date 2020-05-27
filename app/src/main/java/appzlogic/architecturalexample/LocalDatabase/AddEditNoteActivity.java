package appzlogic.architecturalexample.LocalDatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import appzlogic.architecturalexample.R;

public class AddEditNoteActivity extends AppCompatActivity {
    public static final String EXTRA_ID = "appzlogic.architecturalexample.EXTRA_ID";
    public static final String EXTRA_TITLE = "appzlogic.architecturalexample.EXTRA_TITLE";
    public static final String EXTRA_DESCRIPTION = "appzlogic.architecturalexample.EXTRA_DESCRIPTION";
    public static final String EXTRA_PRIORITY = "appzlogic.architecturalexample.EXTRA_PRIORITY";
    private EditText etTitle, etDescription;
    private NumberPicker numberPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        etTitle = findViewById(R.id.etTitle);
        etDescription = findViewById(R.id.etDescription);
        numberPicker = findViewById(R.id.numberPicker);
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(10);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        Intent intent = new Intent();
        if (intent.hasExtra(EXTRA_ID)){
            setTitle("Edit Note");
            etTitle.setText(intent.getStringExtra(EXTRA_TITLE));
            etDescription.setText(intent.getStringExtra(EXTRA_DESCRIPTION));
            numberPicker.setValue(intent.getIntExtra(EXTRA_PRIORITY,1));
        }else {
            setTitle("Add Note");
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.add_note_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.save_note) {
            saveNote();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void saveNote() {
        String title = etTitle.getText().toString();
        String description = etDescription.getText().toString();
        int priority = numberPicker.getValue();
        if (title.trim().isEmpty() || description.trim().isEmpty()){
            Toast.makeText(this, "Please enter title and description", Toast.LENGTH_SHORT).show();
        }
        //for sending data from this activity to main activity
        Intent data = new Intent();
        data.putExtra(EXTRA_TITLE,title);
        data.putExtra(EXTRA_DESCRIPTION,description);
        data.putExtra(EXTRA_PRIORITY,priority);

        int id = getIntent().getIntExtra(EXTRA_ID, -1);
        if (id !=-1){
            data.putExtra(EXTRA_ID, id);
        }

        setResult(RESULT_OK, data);
        finish();
    }
}
