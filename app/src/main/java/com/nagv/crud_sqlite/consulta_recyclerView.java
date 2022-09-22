package com.nagv.crud_sqlite;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class consulta_recyclerView extends AppCompatActivity {
    private RecyclerView recycler;
    private AdaptadorArticulos adaptadorArticulos;
    ConexionSQLite datos = new ConexionSQLite(consulta_recyclerView.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        recycler = (RecyclerView) findViewById(R.id.rview);
        recycler.setHasFixedSize(true);

        // Nuestro RecyclerView usará un linear layout manager
        recycler.setLayoutManager(new LinearLayoutManager(this));

        adaptadorArticulos = new AdaptadorArticulos(consulta_recyclerView.this, datos.mostrarArticulos());
        recycler.setAdapter(adaptadorArticulos);
    }

    //Este metodo se a creado para probar el funcionamiento sin obtener registros
    public List<Dto> obtenerArticulos(){
        List<Dto> articulos = new ArrayList<>();
        articulos.add(new Dto(1, "Laptop", 200.99));
        articulos.add(new Dto(2, "Impresora HP", 100.78));
        articulos.add(new Dto(3, "Disco Duro 1 TB", 100.19));
        return articulos;
    }
}