package com.examen.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Login extends AppCompatActivity {

    private EditText editTextNombre;
    private EditText editTextApellidos;
    private EditText editTextCorreo;
    private EditText editTextContrasena;

    private AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        appDatabase = AppDatabase.getDatabase(getApplicationContext());

        editTextNombre = findViewById(R.id.editTextNombre);
        editTextApellidos = findViewById(R.id.editTextApellidos);
        editTextCorreo = findViewById(R.id.editTextCorreo);
        editTextContrasena = findViewById(R.id.editTextContrasena);

        Button buttonCrearCuenta = findViewById(R.id.buttonCrearCuenta);
        buttonCrearCuenta.setOnClickListener(v -> crearCuenta());
    }

    private void crearCuenta() {
        String nombre = editTextNombre.getText().toString().trim();
        String apellidos = editTextApellidos.getText().toString().trim();
        String correo = editTextCorreo.getText().toString().trim();
        String contrasena = editTextContrasena.getText().toString().trim();

        if (nombre.isEmpty() || apellidos.isEmpty() || correo.isEmpty() || contrasena.isEmpty()) {
            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        User user = new User();
        user.nombre = nombre;
        user.apellidos = apellidos;
        user.correo = correo;
        user.contrasena = contrasena;

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            appDatabase.userDao().insert(user);
            runOnUiThread(() -> Toast.makeText(Login.this, "Cuenta creada exitosamente", Toast.LENGTH_SHORT).show());
        });
    }
}
