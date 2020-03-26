package hr.unidu.kz.pokemoni;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    // polje s testnim podacima
    private String[] pokemoni = {"Abra", "Absol", "Alakazam", "Arbok", "Arcanine", "Articuno", "Bagon", "Bayleef", "Beedrill", "Bellossom", "Bellsprout", "Blastoise", "Blaziken", "Breloom", "Bulbasaur", "Buneary", "Butterfree", "Cacnea", "Cacturne", "Camerupt", "Caterpie", "Celebi", "Charizard", "Charmander", "Charmeleon"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void jednostavna(View v) {
        Intent intent = new Intent(this, JednostavnaListaActivity.class);
        intent.putExtra("punjenje", pokemoni);
        startActivity(intent);
    }
    public void nestandardni(View v) {
        Intent intent = new Intent(this, ListaSpecificniRedakActivity.class);
        intent.putExtra("punjenje", pokemoni);
        startActivity(intent);
    }
    public void vlastitiAdapter2(View v) {
        Intent intent = new Intent(this, MojAdapterListaActivity2.class);
        intent.putExtra("punjenje", pokemoni);
        startActivity(intent);
    }
    public void vlastitiAdapter(View v) {
        Intent intent = new Intent(this, MojAdapterListaActivity.class);
        intent.putExtra("punjenje", pokemoni);
        startActivity(intent);
    }

}
