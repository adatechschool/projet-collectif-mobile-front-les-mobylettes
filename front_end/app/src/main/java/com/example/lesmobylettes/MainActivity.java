package com.example.lesmobylettes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
/*import android.widget.TextView;*/
import android.graphics.Typeface;
import androidx.core.content.res.ResourcesCompat;
import android.widget.Toast;
import android.widget.EditText;
import me.grantland.widget.AutofitTextView;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.SharedPreferences;

// TODO import androidx.navigation.NavController;
//import androidx.navigation.Navigation;
//import androidx.navigation.ui.AppBarConfiguration;
//import androidx.navigation.ui.NavigationUI;*/

import com.example.lesmobylettes.databinding.ActivityMainBinding;

//import android.view.Menu;
//import android.view.MenuItem;*/

public class MainActivity extends AppCompatActivity {

   // private AppBarConfiguration appBarConfiguration;

    private ActivityMainBinding binding;

    //private TextView textView;

    private Button btnSpotList;
    // Déclaration des variables pour les EditText
    private EditText useremailEditText;
    private EditText passwordEditText;

    // Informations d'identification simulées (pour l'exemple)
    private static final String VALID_USEREMAIL = "user@example.com";
    private static final String VALID_PASSWORD = "password123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        AutofitTextView autoFitTextView = findViewById(R.id.autoFitTextView);
        Typeface typeface = ResourcesCompat.getFont(this, R.font.poppins_regular);
        autoFitTextView.setTypeface(typeface);

        // Liaison des EditText avec les vues XML
        useremailEditText = findViewById(R.id.email_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);

        Button btnRegister = findViewById(R.id.btnRegister);
        Button btnLogin = findViewById(R.id.btnLogin);
        btnSpotList = findViewById(R.id.btnSpotList);


        //setSupportActionBar(binding.toolbar);

        //NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
       // appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        //NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);




        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Action pour le bouton Register
                Toast.makeText(MainActivity.this, "Register button clicked", Toast.LENGTH_SHORT).show();
                // Redirection vers l'activité principale après la création du compte
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();  // Ferme l'activité de création de compte
            }
        });





        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Action pour le bouton Login
                // Obtenir le texte des EditText
                String enteredUserEmail = useremailEditText.getText().toString();
                String enteredPassword = passwordEditText.getText().toString();
                // Récupération des données utilisateur depuis SharedPreferences
                SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
                String savedUserEmail = sharedPreferences.getString("userEmail", null);
                String savedPassword = sharedPreferences.getString("password", null);

                // Validation des informations d'identification
                if (savedUserEmail != null && savedPassword != null) {
                    if (savedUserEmail.equals(enteredUserEmail) && savedPassword.equals(enteredPassword)) {
                        Toast.makeText(MainActivity.this, "Connexion réussie", Toast.LENGTH_SHORT).show();

                        // Redirection vers le Dashboard ou l'activité principale
                        Intent intent = new Intent(MainActivity.this, DashboardActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(MainActivity.this, "Nom d'utilisateur ou mot de passe incorrect", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Aucun compte trouvé, veuillez vous inscrire", Toast.LENGTH_SHORT).show();
                }
            }
        });






        btnSpotList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(MainActivity.this, SpotList.class);
                startActivity(intent);
            }
        });
    }

   // @Override
    //public boolean onCreateOptionsMenu(Menu menu) {
        //// Inflate the menu; this adds items to the action bar if it is present.
      //  getMenuInflater().inflate(R.menu.menu_main, menu);
       // return true;
   // }0

   // @Override
    //public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
      //  int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //if (id == R.id.action_settings) {
         //   return true;
        //}

      //  return super.onOptionsItemSelected(item);
    //}

    //@Override
    //public boolean onSupportNavigateUp() {
      //  NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
       // return NavigationUI.navigateUp(navController, appBarConfiguration)
         //       || super.onSupportNavigateUp();
    //}
}