package be.heh.campus_technique.monprojet.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import be.heh.campus_technique.monprojet.BDD.User;
import be.heh.campus_technique.monprojet.BDD.UserAccessDB;
import be.heh.campus_technique.monprojet.R;

public class LectureActivity extends AppCompatActivity {

    TextView tv_lecture_datas;
    ListView lv_lecture_liste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecture);

        tv_lecture_datas = (TextView) findViewById(R.id.tv_lecture_datas);
        tv_lecture_datas.setText("Contenu de la table Utilisateurs : \n");

        lv_lecture_liste = (ListView) findViewById(R.id.lv_lecture_liste);

        UserAccessDB userDB = new UserAccessDB(this);
        userDB.openForRead();
        ArrayList<User> tab_user = userDB.getAllUser();
        userDB.Close();
        ArrayAdapter<User> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, tab_user);
        lv_lecture_liste.setAdapter(adapter);
    }

        /*
        try{
            FileInputStream fins = openFileInput("monfichier.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(fins));
            StringBuilder out = new StringBuilder();
            String line;

            while((line = reader.readLine()) != null){
                out.append(line);
            }
            reader.close(); //on ferme le flux de lecture
            fins.close();
            String[] items = out.toString().split("#"); //on va éclater les chaines de caractère
            int i=0;
            for (String item : items) //on parcours le tableau
            {
                tv_lecture_datas.setText(tv_lecture_datas.getText().toString() +
                        "item " + Integer.toString(i+1) + " = " + item+"\n");
                i++;
            }
        }catch (FileNotFoundException e) { e.printStackTrace();}
        catch (IOException e) {e.printStackTrace();}

    }
    */
}
