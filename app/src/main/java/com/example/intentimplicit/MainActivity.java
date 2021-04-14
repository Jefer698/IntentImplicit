package com.example.intentimplicit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void firstActivity(View view){
        Intent firstIntent = new Intent(Intent.ACTION_SEND);
        firstIntent.setType("message/rfc822");
        firstIntent.putExtra(Intent.EXTRA_EMAIL, new String("equipo3@app.com"));
        firstIntent.putExtra(Intent.EXTRA_SUBJECT,"Correo de prueba");
        firstIntent.putExtra(Intent.EXTRA_TEXT,"Contenido de prueba de corroe ");

        try{
            startActivity(Intent.createChooser(firstIntent,"Enviar Email"));
        }
        catch (android.content.ActivityNotFoundException ex){
            Toast.makeText(getApplicationContext(),"No hay aplicacion instalada", Toast.LENGTH_LONG).show();
        }
    }
    public void secondActivity(View view){
        Intent secondIntent = new Intent(Intent.ACTION_DIAL);
        startActivity(secondIntent);
    }
    public void thirdActivity(View view){
        Intent thirdIntent = new Intent(Intent.ACTION_VIEW);
        thirdIntent.setData(Uri.parse("http://www.google.com"));
        startActivity(thirdIntent);
    }
}