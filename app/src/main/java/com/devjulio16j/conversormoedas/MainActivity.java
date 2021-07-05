package com.devjulio16j.conversormoedas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.devjulio16j.conversormoedas.client.RetrofitClient;
import com.devjulio16j.conversormoedas.model.Coin;
import com.devjulio16j.conversormoedas.model.Result;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, TextWatcher {

    private final ViewHolder mViewHolder = new ViewHolder();

    private Coin btcCoin;
    private Coin usdCoin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mViewHolder.editValue = findViewById(R.id.edit_value);
        this.mViewHolder.editValue.addTextChangedListener(this);
        this.mViewHolder.textDolar = findViewById(R.id.text_dolar);
        this.mViewHolder.textBitcoin = findViewById(R.id.text_bitcoin);
        this.mViewHolder.buttonCalculate = findViewById(R.id.button_calculate);

        this.mViewHolder.buttonCalculate.setOnClickListener(this);
        this.clearValues();
        getQuotations();
    }

    private void clearValues() {
        this.mViewHolder.textDolar.setText("");
        this.mViewHolder.textBitcoin.setText("");
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_calculate) {
            String value = this.mViewHolder.editValue.getText().toString();
            if ("".equals(value)) {
                Toast.makeText(this, this.getString(R.string.infome_um_valor), Toast.LENGTH_LONG).show();
            } else calculate(value);
        }
    }

    private void calculate(String value) {
        Double real = Double.valueOf(value);
        this.mViewHolder.textDolar.setText(String.format("%.2f", (real / usdCoin.getQuotation())));
        this.mViewHolder.textBitcoin.setText(String.format("%.6f", (real / btcCoin.getQuotation())));
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    @Override
    public void afterTextChanged(Editable s) {
        if (!"".contentEquals(s)) {
            calculate(s.toString());
        }
    }

    private static class ViewHolder {
        EditText editValue;
        TextView textDolar;
        TextView textBitcoin;
        Button buttonCalculate;

    }

    private void getQuotations() {
        Call<Result> call = RetrofitClient.getInstance().getMyQuotationApi().getQuotations();
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Result result = response.body();
                btcCoin = result.getBTCBRL();
                usdCoin = result.getUSDBRL();
                btcCoin.setQuotation(btcCoin.getQuotation() * 1000);
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "An error has occured", Toast.LENGTH_LONG).show();
            }

        });
    }
}