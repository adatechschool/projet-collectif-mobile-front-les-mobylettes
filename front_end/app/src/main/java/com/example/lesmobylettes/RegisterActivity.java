package com.example.lesmobylettes;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText emailEditText;
    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Liaison des vues XML avec les variables Java
        emailEditText = findViewById(R.id.email_edit_text);
        usernameEditText = findViewById(R.id.username_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);
        registerButton = findViewById(R.id.register_button);

        // Gestion du clic sur le bouton de création de compte
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString().trim();
                String username = usernameEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                // Validation des champs
                if (email.isEmpty()) {
                    emailEditText.setError("Veuillez entrer un email");
                    return;
                }

                if (username.isEmpty()) {
                    usernameEditText.setError("Veuillez entrer un nom d'utilisateur");
                    return;
                }

                if (password.isEmpty()) {
                    passwordEditText.setError("Veuillez entrer un mot de passe");
                    return;
                }

                if (password.length() < 6) {
                    passwordEditText.setError("Le mot de passe doit contenir au moins 6 caractères");
                    return;
                }

                // Code pour enregistrer l'utilisateur (base de données, Firebase, etc.)
                // Exemple: ajout dans une base de données SQLite ou un appel à une API
                // Ici, nous allons simplement afficher un message de réussite

                Toast.makeText(RegisterActivity.this, "Compte créé avec succès", Toast.LENGTH_SHORT).show();

                // Redirection vers l'activité principale après la création du compte
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
                finish();  // Ferme l'activité de création de compte
            }
        });
    }
}
