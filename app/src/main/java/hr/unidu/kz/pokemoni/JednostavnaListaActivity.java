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
public class JednostavnaListaActivity extends ListActivity {
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        // dohvaćamo primljeni parametar
        Intent intent = getIntent();
        // parametar je polje stringova
        String[] values = intent.getStringArrayExtra("punjenje");
        // simple_list_item_1 je ugrađeni oblik retkal iste koji prikazuje niz znakova u retku
        // adapter povezuje podatke u polju stringova "values"
         ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, values);
        // adapter prikazuje podatke iz polja stringova u listi
        setListAdapter(adapter);
    }
    // kada se klikne na redak liste između ostalog se dobiva podataka o rednom broju retka liste
    // na koji je kliknuto (treći parametar) - rb
    public void onListItemClick(ListView l, View v, int rb, long id) {
        // dohvaća se tekst iz rb-tog retka liste pomoću adaptera
        String izabrani = (String) getListAdapter().getItem(rb);
        Toast.makeText(this, izabrani, Toast.LENGTH_SHORT).show();
    }
}
