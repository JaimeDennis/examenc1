package com.example.examenc1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText txtUser;
    private EditText txtpass;
    private Button btnEntrar, btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        iniciarComponentes();

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = txtUser.getText().toString().trim();
                String password = txtpass.getText().toString().trim();

                // Aquí puedes agregar la lógica de validación del usuario
                if (username.equals("admin") && password.equals("1234")) {
                    Toast.makeText(MainActivity.this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, cuentabancoActivity.class);
                    // No sé qué es Trabajador, así que lo he comentado por ahora
                    intent.putExtra("USUARIO", username);
                    startActivity(intent);
                } else {
                    // Usuario inválido, muestra un mensaje de error o realiza otras acciones
                    Toast.makeText(MainActivity.this, "Nombre de usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void iniciarComponentes(){
        txtUser = findViewById(R.id.txtuser);
        txtpass = findViewById(R.id.txtpass);
        btnEntrar = findViewById(R.id.btnEntrar);
        btnSalir = findViewById(R.id.btnCerrar);
    }
}
