package mx.edu.tesoem.isc.riclr.proyecto1_r;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetalleActivity extends AppCompatActivity {

    TextView lblMatricula, lblNombre, lblCorreo, lblPromedio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);


        lblNombre =findViewById(R.id.dlblNombre);
        lblMatricula =findViewById(R.id.dlblMatricula);
        lblCorreo =findViewById(R.id.dlblCorreo);
        lblPromedio =findViewById(R.id.dlblPromedio);

        String nombre = getIntent().getExtras().get("Nombre").toString();
        DatosParcerable dato = getIntent().getParcelableExtra("DatosParcerable");

        lblNombre.setText(dato.getNombre());
        lblMatricula.setText(dato.getMatricula());
        lblCorreo.setText(dato.getCorreo());
        lblPromedio.setText(dato.getPromedio());

        getSupportActionBar().setTitle(nombre);
    }
}
