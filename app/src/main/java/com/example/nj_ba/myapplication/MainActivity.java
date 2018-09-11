package com.example.nj_ba.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {
    protected int[] arrayData;
    protected Button btnCalc;
    private final int ARRAY_SIZE = 1000;
    protected TextView tvAvg, tvVar, tvStdDev;

    protected void makeArray(int nSize) {
        arrayData = new int[nSize];
    }

    protected void fillArray(int nSize) {
        for(int i = 0; i < nSize; i++)
        {
            arrayData[i] = i+1;
        }

    }

    protected double getAvg(int nSize) {
        double sum= 0.;
        for(int i = 0; i < nSize; i++)
        {
            sum += arrayData[i];
        }
        return sum/nSize;
    }

    protected double getVar(int nSize) {
        double sumSquare = 0.;
        for(int i = 0; i < nSize; i++)
        {
            sumSquare += arrayData[i]*arrayData[i];
        }
        double avg = getAvg(nSize);
        return sumSquare / nSize - avg*avg;
    }

    protected double getStdDev(int nSize) {
        return Math.sqrt(getVar(nSize));
    }

    protected void printTextView(double avg, double var, double stdDev)
    {
        String sAvg = String.format("평균 = %g", avg);
        tvAvg.setText(sAvg);
        String sVar = String.format("분산 = %g", var);
        tvVar.setText(sVar);
        String sStdDev = String.format("표준편차 = %g", stdDev);
        tvStdDev.setText(sStdDev);

    }

    protected void calcArrayStat() {
        makeArray(ARRAY_SIZE);
        fillArray(ARRAY_SIZE);
        double avg = getAvg(ARRAY_SIZE);
        double var = getVar(ARRAY_SIZE);
        double stdDev = getStdDev(ARRAY_SIZE);
        printTextView(avg, var, stdDev);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalc = (Button) findViewById(R.id.btnCalc);
        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcArrayStat();
            }
        });

        tvAvg = (TextView) findViewById(R.id.tvAvg);
        tvVar = (TextView) findViewById(R.id.tvVar);
        tvStdDev = (TextView) findViewById(R.id.tvStdDev);
    }
}