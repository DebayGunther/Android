package be.heh.campus_technique.monprojet.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import be.heh.campus_technique.monprojet.BDD.User;
import be.heh.campus_technique.monprojet.BDD.UserAccessDB;
import be.heh.campus_technique.monprojet.R;

public class ChildrenActivity extends AppCompatActivity {

    EditText et_children_login;
    EditText et_children_pwd;
    EditText et_children_email;
    SharedPreferences prefs_datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_children);

        et_children_login = (EditText) findViewById(R.id.et_children_login); //récumerer les variables
        et_children_pwd = (EditText) findViewById(R.id.et_children_pwd);
        et_children_email = (EditText) findViewById(R.id.et_children_email);

        prefs_datas = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_children, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void onChildrenClickManager(View v) {
// Récupérer la vue et accéder au bouton
        switch (v.getId()) {
            case R.id.bt_children_main:
              //  Toast.makeText(getApplicationContext()
               //         ," Login : " + et_children_login.getText().toString() + "\n Password : " + et_children_pwd.getText().toString() + "\n Email : "
              //      + et_children_email.getText().toString()
               //     , Toast.LENGTH_SHORT).show();
             //   Intent intent = new Intent(this,MainActivity.class);
              //  startActivity(intent);
            //    setResult(RESULT_OK);
             //   finish();
                if(et_children_login.getText().toString().isEmpty()
                        || et_children_pwd.getText().toString().isEmpty()
                        || et_children_email.getText().toString().isEmpty())

                {
                    Toast.makeText(getApplicationContext(), "Complétez tous les champs !",
                            Toast.LENGTH_SHORT).show();
                }
                else
                {
                /*    Intent intxt = new Intent(this, MainActivity.class);
                    intxt.putExtra("login", et_children_login.getText().toString());
                    intxt.putExtra("pwd", et_children_pwd.getText().toString());
                    intxt.putExtra("email", et_children_email.getText().toString());
                    startActivity(intxt); */

                    SharedPreferences.Editor editeur = prefs_datas.edit();
                    editeur.putString("login", et_children_login.getText().toString());
                    editeur.putString("pwd", et_children_pwd.getText().toString());
                    editeur.putString("email", et_children_email.getText().toString());
                    editeur.commit();
                    Intent intent = new Intent (this,MainActivity.class);
                    startActivity(intent);

                }
                break;

            case R.id.bt_children_liste:
           //     Toast.makeText(getApplicationContext()
             //           ," Login : " + et_children_login.getText().toString() + "\n Password : " + et_children_pwd.getText().toString() + "\n Email : "
               //         + et_children_email.getText().toString()
                 //       , Toast.LENGTH_SHORT).show();
                Intent intentListe = new Intent(this,ListeActivity.class);
                startActivity(intentListe);
                break;

            case R.id.bt_children_sauvegarde:
                String str = et_children_login.getText().toString() + "#" +
                        et_children_pwd.getText().toString() + "#" +
                        et_children_email.getText().toString()+ "#";

                User user1 = new User(et_children_login.getText().toString(),
                        et_children_pwd.getText().toString(),
                        et_children_email.getText().toString());

                UserAccessDB userDB = new UserAccessDB(this);
                userDB.openForWrite();
                userDB.insertUser(user1);
                userDB.Close();
                /*
                try {
                    FileOutputStream fous = openFileOutput("monfichier.txt", MODE_APPEND); //MODE_APPEND = On rajoute du texte, on ne supprime pas le fichier à chaque fois
                    byte[] tab;
                    tab = str.toString().getBytes();
                    fous.write(tab);
                    fous.close();
                }
                catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                */
                break;

            case R.id.bt_children_lecture:
                Intent intent = new Intent(this,LectureActivity.class);
                startActivity(intent);
                break;

        }
    }
}
