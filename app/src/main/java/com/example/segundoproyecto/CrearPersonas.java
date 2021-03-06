package com.example.segundoproyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Person;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CrearPersonas extends AppCompatActivity {
    private EditText cedula, nombre, apellido;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_personas);
        cedula = findViewById(R.id.txtCedula);
        nombre = findViewById(R.id.txtNombre);
        apellido = findViewById(R.id.txtApellido);

    }

    public void guardar(View v){
        String ced, nom, ape, mensaje_guardado;
        mensaje_guardado = getResources().getString(R.string.mensaje_guardado);
        Persona persona;

        if(validar()){
            ced = cedula.getText().toString();
            nom = nombre.getText().toString();
            ape = apellido.getText().toString();
            persona = new Persona(ced,nom,ape);
            persona.guardar();
            Toast.makeText(this, mensaje_guardado, Toast.LENGTH_SHORT).show();
            limpiar();
        }
    }

    public boolean validar(){
        String error_cedula, error_apellido, error_nombre;
        error_cedula = getResources().getString(R.string.error_cedula);
        error_nombre = getResources().getString(R.string.error_nombre);
        error_apellido = getResources().getString(R.string.error_apellido);

        if(cedula.getText().toString().isEmpty()){
            cedula.setError(error_cedula);
            return false;
        }else if(nombre.getText().toString().isEmpty()) {
            nombre.setError(error_nombre);
            return false;
        }if(apellido.getText().toString().isEmpty()) {
            apellido.setError(error_apellido);
            return false;
        }
        return true;
    }

    public void limpiar(View v){
        cedula.setText("");
        nombre.setText("");
        apellido.setText("");
        cedula.requestFocus();
    }

    public void limpiar(){
        cedula.setText("");
        nombre.setText("");
        apellido.setText("");
        cedula.requestFocus();
    }
}
