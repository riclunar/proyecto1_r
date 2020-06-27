package mx.edu.tesoem.isc.riclr.proyecto1_r;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    GridView gvDatos;
    EditText txtMatricula, txtNombre, txtCorreo, txtPromedio;
    List<Datos> datos = new ArrayList<>();
    AdaptadorBase adaptadorBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gvDatos = findViewById(R.id.gvDatos);
        txtNombre =findViewById(R.id.txtNombre);
        txtMatricula = findViewById(R.id.txtMatricula);
        txtCorreo = findViewById(R.id.txtCorreo);
        txtPromedio = findViewById(R.id.txtPromedio);

        Verifica();
        gvDatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Datos dato = (Datos) adaptadorBase.getItem(position);
                DatosParcerable datosParcelable = new DatosParcerable(dato.getNombre(), dato.getMatricula(), dato.getCorreo(),dato.getPromedio());
                Intent intent = new Intent(MainActivity.this, DetalleActivity.class);
                intent.putExtra("Nombre", dato.getNombre());
                intent.putExtra("DatosParcerable", datosParcelable);
                startActivity(intent);
            }
        });
    }

    private void Verifica (){
        Almacen conexion = new Almacen();

        if(conexion.Existe(this)){
            if(conexion.Leer(this)){
                datos = conexion.getDatos();
                adaptadorBase = new AdaptadorBase(datos, this);
                gvDatos.setAdapter(adaptadorBase);
            }else {
                Toast.makeText(this,"No se pudo leer la información", Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(this,"Favor de grabar información", Toast.LENGTH_SHORT).show();
        }
    }

    public void Graba(View v){
        Datos dato = new Datos();
        Almacen conexion = new Almacen();
        dato.setNombre(txtNombre.getText().toString());
        dato.setMatricula(txtMatricula.getText().toString());
        dato.setCorreo(txtCorreo.getText().toString());
        dato.setPromedio(txtPromedio.getText().toString());

        datos.add(dato);
        if(conexion.Escribir(this, datos)){
            Toast.makeText(this," Se Escribieron correctamente", Toast.LENGTH_SHORT).show();
            Verifica();
        }else {
            Toast.makeText(this,"***Error al escribir***", Toast.LENGTH_SHORT).show();
        }
    }

}
