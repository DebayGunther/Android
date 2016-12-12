package be.heh.campus_technique.monprojet.Activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import be.heh.campus_technique.monprojet.R;

public class MainActivity extends AppCompatActivity {

    SharedPreferences prefs_datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
// Appelée à la création de l’activité (une seule fois)
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     //   Log.i("Mon projet", "  méthode OnCreate");
     //   Bundle extratxt = this.getIntent().getExtras();
        prefs_datas = PreferenceManager.getDefaultSharedPreferences(getApplication());
        if(prefs_datas != null) //faire ça car au début, le bundle est null donc ça ferait buguer le programme
        {
            Toast.makeText(getApplicationContext(), "votre login est : "
                    + (prefs_datas.getString("login","NULL")) + "\n"
                    + "votre password est : " + (prefs_datas.getString("pwd","NULL")) + "\n"
                    + "votre email est : " + (prefs_datas.getString("email","NULL") + "\n" ), Toast.LENGTH_SHORT)
                    .show();
        }
    }
    @Override // redéfinition des méthodes
    protected void onStart(){
// Appelée quand l’activité devient visible
        super.onStart();
        Log.i("Mon projet","  méthode OnStart");
    }
    @Override
    protected void onRestart(){
// Appelée quand l’activité a été arrêtée et redémarrée
        super.onRestart();
        Log.i("Mon projet","  méthode onRestart");
    }

    private static final int CODE_ACTIVITE=1; //créé constante

    public void onMainClickManager(View v) {
// Récupérer la vue et accéder au bouton
        switch (v.getId()) {
            case R.id.bt_main_children:

               // Toast.makeText(getApplicationContext(), "Clic sur bt : ==> Enfant", Toast.LENGTH_LONG).show();
               // Intent intent = new Intent(this,ChildrenActivity.class);
                //startActivity(intent);
                //startActivityForResult(intent, CODE_ACTIVITE);
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Alerte activité")
                        .setMessage("Voulez-vous afficher l'activité Children ?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(getApplicationContext(),
                                        ChildrenActivity.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        })
                        .create().show();


                break;

        }
    }
  /*  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case CODE_ACTIVITE:
                switch (resultCode) {
                    case RESULT_OK:
                        Toast.makeText(this,"Action validée depuis l'activité Children (Enfant)",Toast.LENGTH_LONG).show();
                        return;
                   /* case RESULT_CANCELED:
                        // etc...
                        break;
                    default:
                        return;
                }
                default:
                    return;
        }
    } */

    /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    */


}
