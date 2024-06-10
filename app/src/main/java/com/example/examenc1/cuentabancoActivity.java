package com.example.examenc1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class cuentabancoActivity extends AppCompatActivity {

    private TextView lblNombre;
    private EditText txtNumCuenta;
    private EditText txtNombre;
    private EditText txtBanco;
    private EditText txtSaldo;
    private EditText txtCantidad;

    private Button btnCerrar, btnAplicar, btnLimpiar;
    private Spinner spnMov;
    private EditText txtNuevoSaldo;

    private cuentaBanco cuenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cuentabanco);
        iniciarComponentes();

        // Obtener la cuentaBanco de la intención
        String nombre = getIntent().getStringExtra("USUARIO");

        // Asignar el nombre al TextView
        lblNombre.setText(nombre);

        // Configurar el listener para el botón "Cerrar"
        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Cerrar la actividad
            }
        });

        // Configurar el listener para el botón "Aplicar"
        btnAplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener el saldo actual
                float saldoActual = cuenta.obtenerSaldo();
                // Obtener la cantidad ingresada por el usuario
                float cantidad = Float.parseFloat(txtCantidad.getText().toString());

                // Verificar si la cantidad es válida
                if (cantidad > 0) {
                    // Realizar la operación de depósito
                    cuenta.depositarDinero(cantidad);
                    // Mostrar mensaje de éxito
                    Toast.makeText(cuentabancoActivity.this, "Depósito exitoso", Toast.LENGTH_SHORT).show();
                    // Actualizar el saldo mostrado en el EditText
                    txtSaldo.setText(String.valueOf(cuenta.obtenerSaldo()));

                    // Asignar los valores actualizados de la cuenta a los EditText correspondientes
                    txtNumCuenta.setText("10");
                    txtNombre.setText("Usuario");
                    txtBanco.setText("Bancome");

                    // Desbloquear los campos de la segunda columna
                    desbloquearSegundaColumna();
                } else {
                    // Mostrar mensaje de error si la cantidad no es válida
                    Toast.makeText(cuentabancoActivity.this, "La cantidad ingresada no es válida", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Configurar el listener para el botón "Limpiar"
        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Limpiar los EditText
                txtNumCuenta.setText("");
                txtNombre.setText("");
                txtBanco.setText("");
                txtSaldo.setText("");
                txtCantidad.setText("");
                txtNuevoSaldo.setText("");
                bloquearSegundaColumna();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void iniciarComponentes(){
        lblNombre = findViewById(R.id.lbluser);
        txtNumCuenta = findViewById(R.id.txtNumCuenta);
        txtNombre = findViewById(R.id.txtNombre);
        txtSaldo = findViewById(R.id.txtSaldo);
        txtBanco = findViewById(R.id.txtBanco);
        txtCantidad = findViewById(R.id.txtcantidad);

        btnAplicar = findViewById(R.id.btnaplicar);
        btnCerrar = findViewById(R.id.btnCerrar);
        btnLimpiar = findViewById(R.id.btnLimpiar);

        spnMov = findViewById(R.id.spnMov);
        txtNuevoSaldo = findViewById(R.id.txtnuevoSaldo);

        bloquearSegundaColumna();
    }

    private void bloquearSegundaColumna() {
        spnMov.setEnabled(false);
        txtCantidad.setEnabled(false);
        txtNuevoSaldo.setEnabled(false);
    }

    private void desbloquearSegundaColumna() {
        spnMov.setEnabled(true);
        txtCantidad.setEnabled(true);
        txtNuevoSaldo.setEnabled(true);
    }
}
