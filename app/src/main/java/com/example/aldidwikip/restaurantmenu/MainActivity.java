package com.example.aldidwikip.restaurantmenu;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnminusKopi, btnplusKopi, btnminusPangsit, btnplusPangsit, btnminusDonut, btnplusDonut,
            btnminusBronis, btnplusBronis, btnpesan, btnreset;
    TextView textQuantityKopi, textQuantityPangsit, textQuantityDonut, textQuantityBronis, displayharga;
    int quantitykopi = 0;
    int quantitypangsit = 0;
    int quantitydonut = 0;
    int quantitybronis = 0;
    int hargakopi = 0;
    int hargapangsit = 0;
    int hargadonut = 0;
    int hargabronis = 0;
    int totalharga = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnminusKopi = findViewById(R.id.btnminusKopi);
        btnplusKopi = findViewById(R.id.btnplusKopi);
        btnminusPangsit = findViewById(R.id.btnminusPangsit);
        btnplusPangsit = findViewById(R.id.btnplusPangsit);
        btnminusDonut = findViewById(R.id.btnminusDonut);
        btnplusDonut = findViewById(R.id.btnplusDonut);
        btnminusBronis = findViewById(R.id.btnminusBronis);
        btnplusBronis = findViewById(R.id.btnplusBronis);
        btnpesan = findViewById(R.id.btnpesan);
        btnreset = findViewById(R.id.btnreset);

        textQuantityKopi = findViewById(R.id.textQuantityKopi);
        textQuantityPangsit = findViewById(R.id.textQuantityPangsit);
        textQuantityDonut = findViewById(R.id.textQuantityDonut);
        textQuantityBronis = findViewById(R.id.textQuantityBronis);
        displayharga = findViewById(R.id.displayharga);

        btnplusKopi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantitykopi++;
                textQuantityKopi.setText("" + quantitykopi);
            }
        });
        btnminusKopi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantitykopi != 0) {
                    quantitykopi--;
                    textQuantityKopi.setText("" + quantitykopi);
                }
            }
        });
        btnplusPangsit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantitypangsit++;
                textQuantityPangsit.setText("" + quantitypangsit);
            }
        });
        btnminusPangsit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantitypangsit != 0) {
                    quantitypangsit--;
                    textQuantityPangsit.setText("" + quantitypangsit);
                }
            }
        });
        btnplusDonut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantitydonut++;
                textQuantityDonut.setText("" + quantitydonut);
            }
        });
        btnminusDonut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantitydonut != 0) {
                    quantitydonut--;
                    textQuantityDonut.setText("" + quantitydonut);
                }
            }
        });
        btnminusBronis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantitybronis != 0) {
                    quantitybronis--;
                    textQuantityBronis.setText("" + quantitybronis);
                }
            }
        });
        btnplusBronis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantitybronis++;
                textQuantityBronis.setText("" + quantitybronis);
            }
        });
        btnpesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hargakopi = quantitykopi * 2000;
                hargapangsit = quantitypangsit * 5000;
                hargadonut = quantitydonut * 7000;
                hargabronis = quantitybronis * 10000;
                totalharga = hargakopi + hargapangsit + hargadonut + hargabronis;

                if (totalharga == 0) {
                    AlertDialog alertDialog1 = new AlertDialog.Builder(MainActivity.this).create();
                    alertDialog1.setTitle("Alert");
                    alertDialog1.setMessage("Please Input Quantity");
                    alertDialog1.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog1.show();
                } else {
                    displayharga.setText("Total Harga : Rp. " + totalharga);
                }
            }
        });
        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textQuantityKopi.setText("0");
                textQuantityPangsit.setText("0");
                textQuantityDonut.setText("0");
                textQuantityBronis.setText("0");
                quantitykopi = 0;
                quantitypangsit = 0;
                quantitydonut = 0;
                quantitybronis = 0;
                totalharga = 0;
                hargakopi = 0;
                hargapangsit = 0;
                hargadonut = 0;
                hargabronis = 0;
                displayharga.setText("");
            }
        });
    }

    public void onBackPressed() {
        AlertDialog alertDialog2 = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog2.setTitle("Alert");
        alertDialog2.setMessage("Are You Sure ?");
        alertDialog2.setButton(AlertDialog.BUTTON_NEGATIVE, "No",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog2.setButton(AlertDialog.BUTTON_POSITIVE, "Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        moveTaskToBack(true);
                        finish();
                    }
                });
        alertDialog2.show();
    }
}
