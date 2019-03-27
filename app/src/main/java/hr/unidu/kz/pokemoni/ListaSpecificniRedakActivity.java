package hr.unidu.kz.pokemoni;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

// aktivnost sadrži samo listu pa je najjednostavnije koristiti oblik klase koji
// nasljeđuje klasu ListActivity
public class ListaSpecificniRedakActivity extends ListActivity {
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        Intent intent = getIntent();
        String[] values = intent.getStringArrayExtra("punjenje");
        // redak liste je opisan u layout datoteci moj_redak_liste_1.xml
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.moj_redak_liste_1, R.id.label, values);
        setListAdapter(adapter);
    }
    public void onListItemClick(ListView l, View v, int rb, long id) {
        String izabrani = (String) getListAdapter().getItem(rb);
        Toast.makeText(this, izabrani, Toast.LENGTH_SHORT).show();
    }
}
