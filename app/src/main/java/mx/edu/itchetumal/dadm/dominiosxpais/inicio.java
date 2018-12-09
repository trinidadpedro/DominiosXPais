package mx.edu.itchetumal.dadm.dominiosxpais;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class inicio extends AppCompatActivity {

    private Pais[] datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ArrayAdapter<CharSequence> adaptadorPaises = ArrayAdapter.createFromResource(this,
                R.array.array_paises,
                android.R.layout.simple_spinner_item);

        Spinner spPaises = (Spinner) findViewById(R.id.cmbPaises);

        adaptadorPaises.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        spPaises.setAdapter(adaptadorPaises);

       /* ArrayAdapter<CharSequence> adaptadorListaPaises =
                ArrayAdapter.createFromResource(this,
                R.array.array_dominiosPaises,
                android.R.layout.simple_list_item_checked);
       */

       Pais miPais = new Pais(R.drawable.mexico, "México", ".mx");

       //Se usen los arreglos de nombres de países y dominio que están en recursos
        datos = new Pais[] {miPais,
                new Pais(R.drawable.alemania, "Alemania", ".de"),
                new Pais(R.drawable.canada, "Canadá", ".ca")};

        AdaptadorPaises adaptador = new AdaptadorPaises(this);

        ListView lstNombresPaises = (ListView) findViewById(R.id.lstPaises);

        lstNombresPaises.setAdapter(adaptador);

        lstNombresPaises.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected item text from ListView
                String selectedItem = (String) parent.getItemAtPosition(position);

                // Display the selected item text on TextView
                Toast.makeText(getBaseContext(),"Your favorite : " + selectedItem, Toast.LENGTH_LONG).show();
            }
        });
    }
    
    class AdaptadorPaises extends ArrayAdapter<Pais> {

        public AdaptadorPaises(Context context) {
            super(context, R.layout.lista_paises, datos);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.lista_paises, null);

            //Obtener Imagen y asignar a componente
            ImageView imgBand = (ImageView) findViewById(R.id.imgBandera);
            //imgBand = R.drawable.alemania;

            TextView lblNombre = (TextView)item.findViewById(R.id.lblNombre);
            lblNombre.setText(datos[position].getNombre());

            TextView lblDominio = (TextView)item.findViewById(R.id.lblDominio);
            lblDominio.setText(datos[position].getDominio());

            return(item);
        }
    }

    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_inicio, menu);
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
