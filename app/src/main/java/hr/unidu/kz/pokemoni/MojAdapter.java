package hr.unidu.kz.pokemoni;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

// specifičan vlastiti adapter
public class MojAdapter extends ArrayAdapter<Pokemon> {
    private final Context context;
    private final Pokemon[] pokemoni;
    // adapter s listom povezuje podatke u obliku polja objekata tipa Pokemon
    // izgled retka liste je opisan u layout datoteci moj_redak_liste_2.xml
    public MojAdapter(Context context, Pokemon[] pokemoni) {
        super(context, R.layout.moj_redak_liste_2, pokemoni);
        this.context = context;
        this.pokemoni = pokemoni;
    }
    @Override
    // ova metoda puni svaki redak liste podacima i vraća popunjeni redak listi
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // izgled retka liste je opisan u layout datoteci moj_redak_liste_2.xml
        View rowView = inflater.inflate(R.layout.moj_redak_liste_2, parent, false);
        // redak liste sadrži sliku i dva tekstualna polja
        TextView naziv = (TextView) rowView.findViewById(R.id.label);
        TextView vrsta = (TextView) rowView.findViewById(R.id.vrsta);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        // polje naziva se puni imenom Pokemona pročitanom iz objekta tipa Pokemon odgovarajućeg retka
        naziv.setText(pokemoni[position].getIme());
        // polje vrste se puni tekstom "Vrsta: " i vrstom Pokemona pročitanom iz objekta tipa
        // Pokemon odgovarajućeg retka
        vrsta.setText("Vrsta: " + pokemoni[position].getVrsta());
        // Slika se dohvaća na temelju naziva slike dohvaćene iz objekta tipa
        // Pokemon odgovarajućeg retka
        String uri = "@drawable/" + pokemoni[position].getSlika();
        int imageResource = context.getResources().getIdentifier(uri, null, context.getPackageName());
        Drawable res = context.getResources().getDrawable(imageResource);
        imageView.setImageDrawable(res);
        // metoda vraća u listu popunjeni redak
        return rowView;
    }
    @Override
    // ova metoda se odrađuje kada korisnik klikne na redak liste - vraća objekt tipa Pokemon
    // iz retka liste na koji je korisnik kliknuo
    public Pokemon getItem(int position) {
        return pokemoni[position];
    }
}
