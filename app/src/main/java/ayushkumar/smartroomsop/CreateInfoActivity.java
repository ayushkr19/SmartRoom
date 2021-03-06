package ayushkumar.smartroomsop;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

/**
 * @author Ayush Kumar
 *
 * Activity that allows the user to enter details for the Project
 * This activity is the precursor to Creating a project
 * The information(name, description, author etc) of this Project is passed
 * on to CreateActivity through the intent to it.
 */
public class CreateInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
         * Set up UI of this activity
         */
        setContentView(R.layout.activity_create_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*
         * Add a FAB to add a new Project with the entered information
         */
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                 * Validate inputs & then only start the next activity
                 */
                validateInputs();
            }
        });
    }

    /**
     * Validate inputs for the information entered by the user for the Project
     */
    private void validateInputs() {

        /*
         * Get references to required fields for validation
         */
        TextInputLayout til1 = (TextInputLayout) findViewById(R.id.til1);
        TextInputLayout til2 = (TextInputLayout) findViewById(R.id.til2);
        TextInputLayout til3 = (TextInputLayout) findViewById(R.id.til3);

        EditText name_et = (EditText) findViewById(R.id.name_et);
        EditText desc_et = (EditText) findViewById(R.id.desc_et);
        EditText author_et = (EditText) findViewById(R.id.author_et);

        String name = name_et.getText().toString();
        String desc = desc_et.getText().toString();
        String author = author_et.getText().toString();
        boolean validated = true;

        if(name.equals("")){
            til1.setError("Name cannot be blank");
            validated = false;
        }else {
            til1.setError(null);
        }
        if(desc.equals("")){
            til2.setError("Description cannot be blank");
            validated = false;
        }else {
            til2.setError(null);
        }
        if(author.equals("")){
            til3.setError("Author cannot be blank");
            validated = false;
        }else{
            til3.setError(null);
        }

        /*
         * If data is validated, then start CreateActivity, and pass all the information to it through the intent
         */
        if(validated){
            Intent i = new Intent(this, CreateActivity.class);
            i.putExtra("name", name);
            i.putExtra("author", author);
            i.putExtra("description", desc);
            startActivity(i);
            finish();
        }

    }

}
