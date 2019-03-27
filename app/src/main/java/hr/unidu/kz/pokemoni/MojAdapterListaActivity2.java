package hr.unidu.kz.pokemoni;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

// aktivnost sadrži samo listu pa je najjednostavnije koristiti oblik klase koji
// nasljeđuje klasu ListActivity
public class MojAdapterListaActivity2 extends ListActivity {
    private Pokemon[] pokemoniObj = new Pokemon[25];

    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        Intent intent = getIntent();
        String[] values = intent.getStringArrayExtra("punjenje");
        napuniPolje(values);
        // s listom je povezan specifičan adapter MojAdapter koji smo sami izradili
        // Taj adapter prima povezuje podatke u obliku polja objekata tipa Pokemon s listom
        MojAdapter2 adapter = new MojAdapter2(this, pokemoniObj);
        // adapter se povezuje s listom
        setListAdapter(adapter);
    }
    public void onListItemClick(ListView l, View v, int position, long id) {
        Pokemon izabrani = (Pokemon) getListAdapter().getItem(position);
        Toast.makeText(this, "Ime: "+izabrani.getIme() + " Vrsta: "+ izabrani.getVrsta(), Toast.LENGTH_SHORT).show();
    }

    // Pomoćna metoda koja puni polje objekata - koristi se za testne podatke
    // jednostavnosti radi naziv slike jednak je imenu Pokemona
    // Imena su navedena u polju stringova pokemoni
    // Vrste su navedene upolju vrste
    private void napuniPolje(String[] punj){
        String[] vrste = {"Psihički", "Mračni", "Psihički", "Otrovni", "Arcanine", "Vatreni", "Zmaj", "Travnati", "Buba/otrovni", "Travnati", "Travnati/otrovni", "Vodeni", "Vatreni", "Travnati", "Travnati/otrovni", "Normalni", "Leteći", "Travnati", "Travnati/mračni", "Vatreni/zemljani", "Buba", "Travnati/psihički", "Vatreni/leteći", "Vatreni", "Vatreni"};
        for (int i = 0; i< 25; ++i){
            pokemoniObj[i] = new Pokemon(punj[i], vrste[i]);
        }
    }
}
